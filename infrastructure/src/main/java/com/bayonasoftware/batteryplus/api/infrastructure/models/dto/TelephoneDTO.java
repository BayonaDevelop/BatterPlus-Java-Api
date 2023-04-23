package com.bayonasoftware.batteryplus.api.infrastructure.models.dto;

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
public class TelephoneDTO {

  private int id;

  private String number;

  private String extensions;

}
