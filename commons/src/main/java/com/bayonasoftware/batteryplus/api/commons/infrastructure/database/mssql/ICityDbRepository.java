package com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql;

import com.bayonasoftware.batteryplus.api.commons.domain.models.CityDomain;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityDbRepository extends CrudRepository<City, Integer> {

  @Query("SELECT " +
      "new com.bayonasoftware.batteryplus.api.commons.domain.models.CityDomain(entity.id, entity.code, entity.name, entity.coatOfArms) " +
      "FROM City entity " +
      "WHERE entity.country.id = :countryId " +
      "ORDER BY entity.code")
  List<CityDomain> getAllByCountryId(@Param("countryId") int countryId);

}
