package com.bayonasoftware.batteryplus.api.commons.address.domain;

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
public class ColonyDomain {

  private int id;

  private String zipCode;

  private String name;

}
