package com.bayonasoftware.batteryplus.api.commons.employee.domain;

import com.bayonasoftware.batteryplus.api.commons.address.domain.AddressDomain;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.PersonDTO;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Address;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Person;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Telephone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class PersonDomain {

  private AddressDomain address;

  private int id;

  private String name;

  private String lastName;

  private String secondLastName;

  private String ine;

  private String driverLicense;

  private Set<TelephoneDomain> telephones;

  public void getValueFromEntity(Person entity) {
    var telephones = entity.getTelephones().stream().map(item -> {
      return TelephoneDomain.builder()
          .number(item.getNumber())
          .extensions(item.getExtensions())
          .build();
    }).collect(Collectors.toSet());

    var address = new AddressDomain();
    address.getValueFromEntity(entity.getAddress());

    this.address = address;
    this.id = entity.getId();
    this.name = entity.getName();
    this.lastName = entity.getLastName();
    this.secondLastName = entity.getSecondLastName();
    this.ine = entity.getIne();
    this.driverLicense = entity.getDriverLicense();
    this.telephones = telephones;
  }

  public void getValuesFromDTO(PersonDTO dto) {
    var telephones = dto.getTelephones().stream().map(item -> {
      return TelephoneDomain.builder()
          .number(item.getNumber())
          .extensions(item.getExtensions())
          .build();
    }).collect(Collectors.toSet());

    var address = AddressDomain.builder()
        .id(dto.getAddress().getId())
        .build();

    this.address = address;
    this.id = dto.getId();
    this.name = dto.getName();
    this.lastName = dto.getLastName();
    this.secondLastName = dto.getSecondLastName();
    this.ine = dto.getIne();
    this.driverLicense = dto.getDriverLicense();
    this.telephones = telephones;
  }

  public Person toEntity() {

    var address = Address.builder()
        .id(getAddress().getId())
        .build();

    Set<Telephone> telephones = this.telephones.stream().map(item -> {
      return Telephone.builder()
          .number(item.getNumber())
          .extensions(item.getExtensions())
          .build();
    }).collect(Collectors.toSet());

    var person = Person.builder()
        .address(address)
        .name(this.name)
        .lastName(this.lastName)
        .secondLastName(this.secondLastName)
        .ine(this.ine)
        .driverLicense(this.driverLicense)
        .telephones(telephones)
        .build();

    return  person;
  }

}
