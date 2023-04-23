package com.bayonasoftware.batteryplus.api.commons.employee.application.services;

import com.bayonasoftware.batteryplus.api.commons.address.domain.AddressDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.repositories.IAddressRepository;
import com.bayonasoftware.batteryplus.api.commons.employee.application.usecases.IPersonServices;
import com.bayonasoftware.batteryplus.api.commons.employee.domain.PersonDomain;
import com.bayonasoftware.batteryplus.api.commons.employee.domain.repositories.IPersonRepository;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.PersonDTO;

public class PersonServices implements IPersonServices {

  private final IAddressRepository addressRepository;
  private final IPersonRepository personRepository;

  public PersonServices(
      final IAddressRepository addressRepository,
      final IPersonRepository personRepository
      ) {
    this.addressRepository = addressRepository;
    this.personRepository = personRepository;
  }

  @Override
  public PersonDTO create(PersonDTO dto) {
    AddressDomain addressDomain = new AddressDomain();
    addressDomain.getValuesFromDTO(dto.getAddress());
    dto.setAddress(addressRepository.create(addressDomain));

    PersonDomain person = new PersonDomain();
    person.getValuesFromDTO(dto);
    person.setAddress(addressDomain);

    dto.setId(personRepository.create(person));

    return dto;
  }
}
