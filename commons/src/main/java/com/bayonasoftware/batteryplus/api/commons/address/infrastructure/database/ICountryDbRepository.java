package com.bayonasoftware.batteryplus.api.commons.address.infrastructure.database;

import com.bayonasoftware.batteryplus.api.commons.address.domain.CountryDomain;
import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountryDbRepository extends CrudRepository<Country, Integer> {

  @Query("SELECT new com.bayonasoftware.batteryplus.api.commons.address.domain.CountryDomain(entity.id, entity.code, entity.name, entity.flag) FROM Country entity ORDER BY entity.id")
  List<CountryDomain> getAll();

}
