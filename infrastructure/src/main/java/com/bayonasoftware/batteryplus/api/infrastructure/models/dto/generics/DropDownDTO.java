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
public class DropDownDTO {

  private Object id;

  private String label;

  private String complement;

}
