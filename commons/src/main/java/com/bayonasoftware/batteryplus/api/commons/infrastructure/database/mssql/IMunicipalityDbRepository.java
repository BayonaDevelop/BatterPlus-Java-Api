package com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql;

import com.bayonasoftware.batteryplus.api.commons.domain.models.MunicipalityDomain;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Municipality;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMunicipalityDbRepository extends CrudRepository<Municipality, Integer> {

  @Query("SELECT " +
      "new com.bayonasoftware.batteryplus.api.commons.domain.models.MunicipalityDomain(entity.id, entity.name, entity.coatOfArms) " +
      "FROM Municipality entity " +
      "WHERE entity.city.id = :cityId " +
      "ORDER BY entity.code")
  List<MunicipalityDomain> getAllByCityId(@Param("cityId") int cityId);

}
