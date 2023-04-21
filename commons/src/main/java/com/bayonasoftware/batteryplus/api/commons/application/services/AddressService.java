package com.bayonasoftware.batteryplus.api.commons.application.services;

import com.bayonasoftware.batteryplus.api.commons.domain.models.AddressDomain;
import com.bayonasoftware.batteryplus.api.commons.domain.repositories.IAddressRepository;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.generics.AddressDTO;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.generics.DropDownDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AddressService implements IAddressUseCases {

  private final IAddressRepository addressDomainRepository;

  public AddressService(IAddressRepository addressDomainRepository) {
    this.addressDomainRepository = addressDomainRepository;
  }

  @Override
  public List<DropDownDTO> getAllCountries() {
    return addressDomainRepository.getAllCountries().stream().map(origin -> {
      return DropDownDTO.builder()
          .id(origin.getId())
          .label(origin.getName())
          .complement(origin.getFlag())
          .build();
    }).collect(Collectors.toList());
  }

  @Override
  public List<DropDownDTO> getCitiesByCountryId(int countryId) {
    return addressDomainRepository.getCitiesByCountryId(countryId).stream().map(origin -> {
      return DropDownDTO.builder()
          .id(origin.getId())
          .label(origin.getName())
          .complement(origin.getCoatOfArms())
          .build();
    }).collect(Collectors.toList());
  }

  @Override
  public List<DropDownDTO> getMunicipalitiesByCityId(int cityId) {
    return addressDomainRepository.getMunicipalitiesByCityId(cityId).stream().map(origin -> {
      return DropDownDTO.builder()
          .id(origin.getId())
          .label(origin.getName())
          .complement(origin.getCoatOfArms())
          .build();
    }).collect(Collectors.toList());
  }

  @Override
  public List<DropDownDTO> getLocationsByMunicipalityIdAndName(int municipalityId, String name) {
    String locationName = "%"+ (name.length() > 0 ? name : "") +"%";

    return addressDomainRepository.getLocationsByMunicipalityIdAndName(municipalityId, locationName).stream().map(origin -> {
      return DropDownDTO.builder()
          .id(origin.getId())
          .label(origin.getName())
          .build();
    }).collect(Collectors.toList());
  }

  @Override
  public List<DropDownDTO> getColoniesByLocationIdAndName(int locationId, String name) {
    String colonyName = "%"+ (name.length() > 0 ? name : "") +"%";

    return addressDomainRepository.getColoniesByLocationIdAndName(locationId, colonyName).stream().map(origin -> {
      return DropDownDTO.builder()
          .id(origin.getId())
          .label(origin.getName())
          .build();
    }).collect(Collectors.toList());
  }

  @Override
  public List<DropDownDTO> getColoniesByZipCode(String zipCode) {
    return addressDomainRepository.getColoniesByZipCode(zipCode).stream().map(origin -> {
      return DropDownDTO.builder()
          .id(origin.getId())
          .label(origin.getName())
          .complement(origin.getZipCode())
          .build();
    }).collect(Collectors.toList());
  }

  @Override
  public List<DropDownDTO> getStreetsByColonyIdAndName(int colonyId, String name) {
    String streetName = "%"+ (name.length() > 0 ? name : "") +"%";

    return addressDomainRepository.getStreetsByColonyIAndName(colonyId, streetName).stream().map(origin -> {
      return DropDownDTO.builder()
          .id(origin.getId())
          .label(origin.getName())
          .build();
    }).collect(Collectors.toList());
  }

  @Override
  public AddressDTO create(AddressDTO dto) {
    if (dto.getLocation().getLabel() == null || dto.getLocation().getLabel().length() < 1)
      dto.getLocation().setLabel("Sin nombre");

    if(dto.getStreet().getLabel() == null || dto.getStreet().getLabel().length() < 1)
      dto.getStreet().setLabel("Sin nombre");

    if(dto.getStreetA().getLabel() == null || dto.getStreetA().getLabel().length() < 1)
      dto.getStreetA().setLabel(null);

    if(dto.getStreetB().getLabel() == null || dto.getStreetB().getLabel().length() < 1)
      dto.getStreetB().setLabel(null);

    if(dto.getExternalNumber() == null || dto.getExternalNumber().length() < 1)
      dto.setExternalNumber("");

    if(dto.getInternalNumber() == null || dto.getInternalNumber().length() < 1)
      dto.setInternalNumber("");

    AddressDomain domain = new AddressDomain();
    domain.getValuesFromDTO(dto);
    return addressDomainRepository.create(domain);
  }
}
