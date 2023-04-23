package com.bayonasoftware.batteryplus.api.commons.address.infrastructure.database;

import com.bayonasoftware.batteryplus.api.commons.address.domain.ColonyDomain;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Colony;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IColonyDbRepository extends CrudRepository<Colony, Integer> {

  @Query("SELECT " +
      "new com.bayonasoftware.batteryplus.api.commons.address.domain.ColonyDomain(entity.id, entity.zipCode, entity.name) " +
      "FROM Colony entity " +
      "WHERE entity.zipCode = :zipcode " +
      "ORDER BY entity.name")
  List<ColonyDomain> getAllByZipCode(@Param("zipcode") String zipcode);

  @Query("SELECT " +
      "new com.bayonasoftware.batteryplus.api.commons.address.domain.ColonyDomain(entity.id, entity.zipCode, entity.name) " +
      "FROM Colony entity " +
      "WHERE entity.location.id = :locationId " +
      "AND entity.name LIKE :name " +
      "ORDER BY entity.name")
  List<ColonyDomain> getAllByLocationIdAndName(@Param("locationId") int locationId, @Param("name") String name);

}
