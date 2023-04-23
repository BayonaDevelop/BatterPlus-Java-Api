package com.bayonasoftware.batteryplus.api.commons.address.domain;

import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.AddressDTO;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.generics.DropDownDTO;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class AddressDomain {

  private CountryDomain country;

  private CityDomain city;

  private MunicipalityDomain municipality;

  private LocationDomain location;

  private ColonyDomain colony;

  private StreetDomain street;

  private StreetDomain streetA;

  private StreetDomain streetB;

  private long id;

  private String externalNumber;

  private String internalNumber;

  private String references;

  public void getValueFromEntity(Address entity) {

    CountryDomain _country = CountryDomain.builder()
        .id(entity.getStreet().getColony().getLocation().getMunicipality().getCity().getCountry().getId())
        .name(entity.getStreet().getColony().getLocation().getMunicipality().getCity().getCountry().getName())
        .build();

    CityDomain _city = CityDomain.builder()
        .id(entity.getStreet().getColony().getLocation().getMunicipality().getCity().getId())
        .name(entity.getStreet().getColony().getLocation().getMunicipality().getCity().getName())
        .build();

    MunicipalityDomain _municipality = MunicipalityDomain.builder()
        .id(entity.getStreet().getColony().getLocation().getMunicipality().getId())
        .name(entity.getStreet().getColony().getLocation().getMunicipality().getName())
        .build();

    LocationDomain _location = LocationDomain.builder()
        .id(entity.getStreet().getColony().getLocation().getId())
        .name(entity.getStreet().getColony().getLocation().getName())
        .build();

    ColonyDomain _colony = ColonyDomain.builder()
        .id(entity.getStreet().getColony().getId())
        .name(entity.getStreet().getColony().getName())
        .build();

    StreetDomain _street = StreetDomain.builder()
        .id(entity.getStreet().getId())
        .name(entity.getStreet().getName())
        .build();

    StreetDomain _streetA = StreetDomain.builder()
        .id(entity.getStreetA().getId())
        .name(entity.getStreetA().getName())
        .build();

    StreetDomain _streetB = StreetDomain.builder()
        .id(entity.getStreetB().getId())
        .name(entity.getStreetB().getName())
        .build();

    this.country =_country;
    this.city = _city;
    this.location = _location;
    this.colony = _colony;
    this.street = _street;
    this.streetA = _streetA;
    this.streetB = _streetB;
    this.id = entity.getId();
    this.internalNumber = entity.getInternalNumber();
    this.externalNumber = entity.getExternalNumber();
    this.references = entity.getReference();
  }

  public void getValuesFromDTO(AddressDTO dto) {

    MunicipalityDomain _municipality = MunicipalityDomain.builder()
        .id(dto.getMunicipality().getId() == null ? 0 : Integer.parseInt(dto.getMunicipality().getId().toString()))
        .build();

    LocationDomain _location = LocationDomain.builder()
        .id(dto.getLocation().getId() == null ? 0 : Integer.parseInt(dto.getLocation().getId().toString()))
        .name(dto.getLocation().getLabel())
        .build();

    ColonyDomain _colony = ColonyDomain.builder()
        .id(dto.getColony().getId() == null ? 0 : Integer.parseInt(dto.getColony().getId().toString()))
        .name(dto.getColony().getLabel())
        .zipCode(dto.getColony().getComplement())
        .build();

    StreetDomain _street = StreetDomain.builder()
        .id(dto.getStreet().getId() == null ? 0 : Integer.parseInt(dto.getStreet().getId().toString()))
        .name(dto.getStreet().getLabel())
        .build();

    StreetDomain _streetA = StreetDomain.builder()
        .id(dto.getStreetA().getId() == null ? 0 : Integer.parseInt(dto.getStreetA().getId().toString()))
        .name(dto.getStreetA().getLabel())
        .build();

    StreetDomain _streetB = StreetDomain.builder()
        .id(dto.getStreetB().getId() == null ? 0 : Integer.parseInt(dto.getStreetB().getId().toString()))
        .name(dto.getStreetB().getLabel())
        .build();

    this.setMunicipality(_municipality);
    this.setLocation(_location);
    this.setColony(_colony);
    this.setStreet(_street);
    this.setStreetA(_streetA);
    this.setStreetB(_streetB);
    this.setInternalNumber(dto.getInternalNumber());
    this.setExternalNumber(dto.getExternalNumber());
    this.setReferences(dto.getReferences());
  }

  public AddressDTO toDTO() {

    DropDownDTO _municipality = DropDownDTO.builder()
        .id(municipality.getId())
        .label(municipality.getName())
        .build();

    DropDownDTO _location = DropDownDTO.builder()
        .id(this.location.getId())
        .label(this.location.getName())
        .build();

    DropDownDTO _colony = DropDownDTO.builder()
        .id(this.colony.getId())
        .label(this.colony.getName())
        .build();

    DropDownDTO _street = DropDownDTO.builder()
        .id(this.street.getId())
        .label(this.street.getName())
        .build();

    DropDownDTO _streetA = DropDownDTO.builder()
        .id(this.streetA.getId())
        .label(this.streetA.getName())
        .build();

    DropDownDTO _streetB = DropDownDTO.builder()
        .id(this.streetB.getId())
        .label(this.streetB.getName())
        .build();

    return AddressDTO.builder()
        .street(_street)
        .streetA(_streetA)
        .streetB(_streetB)
        .id(this.id)
        .externalNumber(this.externalNumber)
        .internalNumber(this.internalNumber)
        .references(this.references)
        .build();
  }


}
