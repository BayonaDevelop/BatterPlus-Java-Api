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
public class MunicipalityDomain {

  private int id;

  private String name;

  private String coatOfArms;

}
