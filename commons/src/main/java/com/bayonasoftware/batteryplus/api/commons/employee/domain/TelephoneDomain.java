package com.bayonasoftware.batteryplus.api.commons.employee.domain;

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
public class TelephoneDomain {

  private int id;

  private String number;

  private String extensions;

}
