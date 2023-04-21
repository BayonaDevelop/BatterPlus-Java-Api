package com.bayonasoftware.batteryplus.api.commons.application.services;

import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.generics.AddressDTO;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.generics.DropDownDTO;

import java.util.List;

public interface IAddressUseCases {

  List<DropDownDTO> getAllCountries();

  List<DropDownDTO> getCitiesByCountryId(int countryId);

  List<DropDownDTO> getMunicipalitiesByCityId(int cityId);

  List<DropDownDTO> getLocationsByMunicipalityIdAndName(int municipalityId, String name);

  List<DropDownDTO> getColoniesByLocationIdAndName(int locationId, String name);

  List<DropDownDTO> getColoniesByZipCode(String zipCode);

  List<DropDownDTO> getStreetsByColonyIdAndName(int colonyId, String name);

  AddressDTO create(AddressDTO address);

}
