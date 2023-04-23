package com.bayonasoftware.batteryplus.api.infrastructure.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDTO {

  private AddressDTO address;

  private int id;

  private String name;

  private String lastName;

  private String secondLastName;

  private String ine;

  private String driverLicense;

  private Set<TelephoneDTO> telephones;

}
