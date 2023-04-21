package com.bayonasoftware.batteryplus.api.commons.domain.repositories;

import com.bayonasoftware.batteryplus.api.commons.domain.models.AddressDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.CityDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.ColonyDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.CountryDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.LocationDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.MunicipalityDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.models.StreetDomain;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.generics.AddressDTO;

import java.util.List;

public interface IAddressRepository {

  List<CountryDomain> getAllCountries();

  List<CityDomain> getCitiesByCountryId(int countryId);

  List<MunicipalityDomain> getMunicipalitiesByCityId(int cityId);

  List<LocationDomain> getLocationsByMunicipalityIdAndName(int municipalityId, String name);

  List<ColonyDomain> getColoniesByLocationIdAndName(int locationId, String name);

  List<ColonyDomain> getColoniesByZipCode(String zipCode);

  List<StreetDomain> getStreetsByColonyIAndName(int colonyId, String name);

  AddressDTO create(AddressDomain domain);

}
