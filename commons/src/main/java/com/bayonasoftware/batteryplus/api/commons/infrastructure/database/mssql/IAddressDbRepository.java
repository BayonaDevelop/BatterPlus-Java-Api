package com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql;

import com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressDbRepository extends CrudRepository<Address, Long> {
}
