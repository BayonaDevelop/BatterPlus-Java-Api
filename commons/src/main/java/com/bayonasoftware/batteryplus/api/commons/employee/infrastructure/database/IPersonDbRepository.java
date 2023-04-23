package com.bayonasoftware.batteryplus.api.commons.employee.infrastructure.database;

import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonDbRepository extends CrudRepository<Person, Integer> {
}
