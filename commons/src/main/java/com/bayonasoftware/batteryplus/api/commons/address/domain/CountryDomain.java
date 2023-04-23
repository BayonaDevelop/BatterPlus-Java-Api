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
public class CountryDomain {

  private int id;

  private String code;

  private String name;

  private String flag;

}
