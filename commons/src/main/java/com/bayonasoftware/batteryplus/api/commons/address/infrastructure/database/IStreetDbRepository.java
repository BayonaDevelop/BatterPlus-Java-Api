package com.bayonasoftware.batteryplus.api.commons.address.infrastructure.database;

import com.bayonasoftware.batteryplus.api.commons.address.domain.StreetDomain;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Street;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStreetDbRepository extends CrudRepository<Street, Integer> {

  @Query("SELECT " +
      "new com.bayonasoftware.batteryplus.api.commons.address.domain.StreetDomain(entity.id, entity.name) " +
      "FROM Street entity " +
      "WHERE entity.colony.id = :colonyId " +
      "AND entity.name LIKE :name " +
      "ORDER BY entity.name")
  List<StreetDomain> getAllByColonyIdAndName(@Param("colonyId") int colonyId, @Param("name") String name);

}
