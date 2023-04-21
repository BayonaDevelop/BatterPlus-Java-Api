package com.bayonasoftware.batteryplus.api.commons.domain.models;

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
public class CityDomain {

  private int id;

  private String code;

  private String name;

  private String coatOfArms;

}
