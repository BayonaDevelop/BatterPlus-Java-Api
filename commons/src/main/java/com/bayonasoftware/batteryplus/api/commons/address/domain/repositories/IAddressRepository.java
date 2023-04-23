package com.bayonasoftware.batteryplus.api.commons.address.domain.repositories;

import com.bayonasoftware.batteryplus.api.commons.address.domain.AddressDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.CityDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.ColonyDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.CountryDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.LocationDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.MunicipalityDomain;
import com.bayonasoftware.batteryplus.api.commons.address.domain.StreetDomain;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.AddressDTO;

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
