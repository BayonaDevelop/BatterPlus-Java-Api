package com.bayonasoftware.batteryplus.api.commons.infrastructure.adapters;

import com.bayonasoftware.batteryplus.api.commons.domain.models.AddressDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.CityDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.ColonyDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.CountryDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.LocationDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.MunicipalityDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.StreetDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.repositories.IAddressRepository;
import com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql.IAddressDbRepository;
import com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql.ICityDbRepository;
import com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql.IColonyDbRepository;
import com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql.ICountryDbRepository;
import com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql.ILocationDbRepository;
import com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql.IMunicipalityDbRepository;
import com.bayonasoftware.batteryplus.api.commons.infrastructure.database.mssql.IStreetDbRepository;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.generics.AddressDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AddressAdapter implements IAddressRepository {

  private final ICountryDbRepository countryRepository;
  private final ICityDbRepository cityDbRepository;
  private final IMunicipalityDbRepository municipalityDbRepository;
  private final ILocationDbRepository locationDbRepository;
  private final IColonyDbRepository colonyDbRepository;
  private final IStreetDbRepository streetDbRepository;
  private final IAddressDbRepository addressDbRepository;

  @PersistenceContext
  private EntityManager em;

  public AddressAdapter(
      final ICountryDbRepository countryRepository,
      final ICityDbRepository cityDbRepository,
      final IMunicipalityDbRepository municipalityDbRepository,
      final ILocationDbRepository locationDbRepository,
      final IColonyDbRepository colonyDbRepository,
      final IStreetDbRepository streetDbRepository,
      final IAddressDbRepository addressDbRepository
  ) {

    this.countryRepository = countryRepository;
    this.cityDbRepository = cityDbRepository;
    this.municipalityDbRepository = municipalityDbRepository;
    this.locationDbRepository = locationDbRepository;
    this.colonyDbRepository = colonyDbRepository;
    this.streetDbRepository = streetDbRepository;
    this.addressDbRepository = addressDbRepository;
  }

  @Transactional(readOnly = true)
  @Override
  public List<CountryDomain> getAllCountries() {
    return countryRepository.getAll();
  }

  @Transactional(readOnly = true)
  @Override
  public List<CityDomain> getCitiesByCountryId(int countryId) {
    return cityDbRepository.getAllByCountryId(countryId);
  }

  @Transactional(readOnly = true)
  @Override
  public List<MunicipalityDomain> getMunicipalitiesByCityId(int cityId) {
    return municipalityDbRepository.getAllByCityId(cityId);
  }

  @Transactional(readOnly = true)
  @Override
  public List<LocationDomain> getLocationsByMunicipalityIdAndName(int municipalityId, String name) {
    return locationDbRepository.getAllByMunicipalityIdAndName(municipalityId, name);
  }

  @Transactional(readOnly = true)
  @Override
  public List<ColonyDomain> getColoniesByLocationIdAndName(int locationId, String name) {
    return colonyDbRepository.getAllByLocationIdAndName(locationId, name);
  }

  @Transactional(readOnly = true)
  @Override
  public List<ColonyDomain> getColoniesByZipCode(String zipCode) {
    return colonyDbRepository.getAllByZipCode(zipCode);
  }

  @Transactional(readOnly = true)
  @Override
  public List<StreetDomain> getStreetsByColonyIAndName(int colonyId, String name) {
    return streetDbRepository.getAllByColonyIdAndName(colonyId, name);
  }

  @Transactional
  @Override
  public AddressDTO create(AddressDomain domain) {

    Long id = 0L;

    StoredProcedureQuery createQuery = em.createNamedStoredProcedureQuery("CreateAddress");
    createQuery.setParameter("MunicipalityID", domain.getMunicipality().getId());
    createQuery.setParameter("Location", domain.getLocation().getName());
    createQuery.setParameter("ZipCode", domain.getColony().getZipCode());
    createQuery.setParameter("Colony", domain.getColony().getName());
    createQuery.setParameter("Street", domain.getStreet().getName());
    createQuery.setParameter("StreetA", domain.getStreetA().getName());
    createQuery.setParameter("StreetB", domain.getStreetB().getName());
    createQuery.setParameter("InternalNumber", domain.getInternalNumber());
    createQuery.setParameter("ExternalNumber", domain.getExternalNumber());
    createQuery.setParameter("Reference", domain.getReferences());
    createQuery.setParameter("ID", id);

    createQuery.execute();
    domain.setId((long) createQuery.getOutputParameterValue("ID"));

    return domain.toDTO();
  }
}
