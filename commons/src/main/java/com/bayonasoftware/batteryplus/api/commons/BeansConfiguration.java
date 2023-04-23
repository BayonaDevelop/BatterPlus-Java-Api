package com.bayonasoftware.batteryplus.api.commons;

import com.bayonasoftware.batteryplus.api.commons.address.application.services.AddressServices;
import com.bayonasoftware.batteryplus.api.commons.address.application.usecases.IAddressServices;
import com.bayonasoftware.batteryplus.api.commons.address.domain.repositories.IAddressRepository;
import com.bayonasoftware.batteryplus.api.commons.employee.application.services.PersonServices;
import com.bayonasoftware.batteryplus.api.commons.employee.application.usecases.IPersonServices;
import com.bayonasoftware.batteryplus.api.commons.employee.domain.repositories.IPersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeansConfiguration {

  @Bean
  IAddressServices addressServices(IAddressRepository repository) {
    return new AddressServices(repository);
  }

  @Bean
  IPersonServices personServices(IAddressRepository addressRepository, IPersonRepository personRepository) {
    return new PersonServices(addressRepository, personRepository);
  }

}
