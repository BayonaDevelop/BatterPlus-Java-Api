package com.bayonasoftware.batteryplus.api.commons.employee.infrastructure.controllers;

import com.bayonasoftware.batteryplus.api.commons.employee.application.usecases.IPersonServices;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.PersonDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

  private final IPersonServices personServices;

  public PersonController(IPersonServices personServices) {
    this.personServices = personServices;
  }

  @PostMapping()
  public PersonDTO create(@RequestBody PersonDTO dto) {
    return personServices.create(dto);
  }

}
