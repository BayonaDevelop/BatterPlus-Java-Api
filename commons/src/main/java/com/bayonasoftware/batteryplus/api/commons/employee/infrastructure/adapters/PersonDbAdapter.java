package com.bayonasoftware.batteryplus.api.commons.employee.infrastructure.adapters;

import com.bayonasoftware.batteryplus.api.commons.employee.domain.PersonDomain;
import com.bayonasoftware.batteryplus.api.commons.employee.domain.repositories.IPersonRepository;
import com.bayonasoftware.batteryplus.api.commons.employee.infrastructure.database.IPersonDbRepository;
import com.bayonasoftware.batteryplus.api.commons.employee.infrastructure.database.ITelephoneDbRepository;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Person;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Telephone;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PersonDbAdapter implements IPersonRepository {

  private final ITelephoneDbRepository telephoneDbRepository;
  private final IPersonDbRepository personDbRepository;

  public PersonDbAdapter(
      final ITelephoneDbRepository telephoneDbRepository,
      final IPersonDbRepository personDbRepository
      ) {

    this.telephoneDbRepository = telephoneDbRepository;
    this.personDbRepository = personDbRepository;
  }

  @Override
  public Integer create(PersonDomain domain) {
    Person person = domain.toEntity();
    var telephones = person.getTelephones();

    person = personDbRepository.save(person);

    for (Telephone item: telephones) {
      var aux = Person.builder().id(person.getId()).build();
      item.setPerson(aux);
      telephoneDbRepository.save(item);
    }

    return person.getId();
  }

}
