package com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql;

import com.bayonasoftware.batteryplus.api.commons.domain.models.LocationDomain;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationDbRepository extends CrudRepository<Location, Integer> {

  @Query("SELECT " +
      "new com.bayonasoftware.batteryplus.api.commons.domain.models.LocationDomain(entity.id, entity.name) " +
      "FROM Location entity " +
      "WHERE entity.municipality.id = :municipalityId " +
      "AND entity.name LIKE :name " +
      "ORDER BY entity.code")
  List<LocationDomain> getAllByMunicipalityIdAndName(@Param("municipalityId") int municipalityId, @Param("name") String name);

}
