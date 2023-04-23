package com.bayonasoftware.batteryplus.api.commons.employee.domain.repositories;

import com.bayonasoftware.batteryplus.api.commons.employee.domain.PersonDomain;

public interface IPersonRepository {

  Integer create(PersonDomain domain);

}
