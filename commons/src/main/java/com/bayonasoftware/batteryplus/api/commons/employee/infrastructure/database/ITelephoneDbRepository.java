package com.bayonasoftware.batteryplus.api.commons.employee.infrastructure.database;

import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Person;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Telephone;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITelephoneDbRepository extends CrudRepository<Telephone, Integer> {

  void deleteByPerson(Person person);

  @Modifying
  @Query(nativeQuery = true, value = "INSERT INTO dbo.Telephone (Person_ID, Number, Extensions) VALUES (:personID, :number, :extensions)")
  void insert(@Param("personID") int personID, @Param("number") String number, @Param("extensions") String extensions);

}
