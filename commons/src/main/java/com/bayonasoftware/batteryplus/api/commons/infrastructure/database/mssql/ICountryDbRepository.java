package com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql;

import com.bayonasoftware.batteryplus.api.commons.domain.models.CountryDomain;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountryDbRepository extends CrudRepository<Country, Integer> {

  @Query("SELECT new com.bayonasoftware.batteryplus.api.commons.domain.models.CountryDomain(entity.id, entity.code, entity.name, entity.flag) FROM Country entity ORDER BY entity.id")
  List<CountryDomain> getAll();

}
