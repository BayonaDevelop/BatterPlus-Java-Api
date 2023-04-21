package com.bayonasoftware.batteryplus.api.infrastructure.models.dto.generics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {

  private DropDownDTO country;

  private DropDownDTO city;

  private DropDownDTO municipality;

  private DropDownDTO location;

  private DropDownDTO colony;

  private DropDownDTO street;

  private DropDownDTO streetA;

  private DropDownDTO streetB;

  private long id;

  private String externalNumber;

  private String internalNumber;

  private String references;

}
