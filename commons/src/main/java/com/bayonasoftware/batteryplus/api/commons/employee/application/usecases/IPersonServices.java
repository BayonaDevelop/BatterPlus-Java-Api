package com.bayonasoftware.batteryplus.api.commons.employee.application.usecases;

import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.PersonDTO;

public interface IPersonServices {

  PersonDTO create(PersonDTO dto);

}
