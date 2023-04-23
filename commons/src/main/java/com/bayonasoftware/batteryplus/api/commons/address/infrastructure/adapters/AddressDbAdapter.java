package com.bayonasoftware.batteryplus.api.commons.address.infrastructure.adapters;

import com.bayonasoftware.batteryplus.api.commons.address.domain.AddressDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.CityDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.ColonyDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.CountryDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.LocationDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.MunicipalityDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.StreetDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.repositories.IAddressRepository;
import com.bayonasoftware.batteryplus.api.commons.address.infrastructure.database.IAddressDbRepository;
import com.bayonasoftware.batteryplus.api.commons.address.infrastructure.database.ICityDbRepository;
import com.bayonasoftware.batteryplus.api.commons.address.infrastructure.database.IColonyDbRepository;
import com.bayonasoftware.batteryplus.api.commons.address.infrastructure.database.ICountryDbRepository;
import com.bayonasoftware.batteryplus.api.commons.address.infrastructure.database.ILocationDbRepository;
import com.bayonasoftware.batteryplus.api.commons.address.infrastructure.database.IMunicipalityDbRepository;
import com.bayonasoftware.batteryplus.api.commons.address.infrastructure.database.IStreetDbRepository;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.AddressDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AddressDbAdapter implements IAddressRepository {

  private final ICountryDbRepository countryRepository;
  private final ICityDbRepository cityDbRepository;
  private final IMunicipalityDbRepository municipalityDbRepository;
  private final ILocationDbRepository locationDbRepository;
  private final IColonyDbRepository colonyDbRepository;
  private final IStreetDbRepository streetDbRepository;
  private final IAddressDbRepository addressDbRepository;

  @PersistenceContext
  private EntityManager em;

  public AddressDbAdapter(
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
