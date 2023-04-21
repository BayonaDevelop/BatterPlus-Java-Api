package com.bayonasoftware.batteryplus.api.commons;

import com.bayonasoftware.batteryplus.api.commons.application.services.AddressService;
import com.bayonasoftware.batteryplus.api.commons.application.services.IAddressUseCases;
import com.bayonasoftware.batteryplus.api.commons.domain.repositories.IAddressRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeansConfiguration {

  @Bean
  IAddressUseCases addressServices(IAddressRepository repository) {
    return new AddressService(repository);
  }

}
