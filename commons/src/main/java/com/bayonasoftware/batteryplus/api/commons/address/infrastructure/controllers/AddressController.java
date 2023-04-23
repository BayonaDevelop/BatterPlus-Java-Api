package com.bayonasoftware.batteryplus.api.commons.address.infrastructure.controllers;

import com.bayonasoftware.batteryplus.api.commons.address.application.usecases.IAddressServices;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.AddressDTO;
import com.bayonasoftware.batteryplus.api.infrastructure.models.dto.generics.DropDownDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

  private final IAddressServices addressService;

  public AddressController(final IAddressServices addressService) {
    this.addressService = addressService;
  }

  @GetMapping("/countries")
  public List<DropDownDTO> getAllCountries() {
    return addressService.getAllCountries();
  }

  @GetMapping("/country/{countryId}/cities")
  public List<DropDownDTO> getCitiesByCountryId(@PathVariable int countryId) {
    return addressService.getCitiesByCountryId(countryId);
  }

  @GetMapping("/city/{cityId}/municipalities")
  public List<DropDownDTO> getMunicipalitiesByCityId(@PathVariable int cityId) {
    return addressService.getMunicipalitiesByCityId(cityId);
  }

  @GetMapping("/municipality/{municipalityId}/locations")
  public List<DropDownDTO> getLocationsByMunicipalityID(@PathVariable int municipalityId, @RequestParam String name) {
    return addressService.getLocationsByMunicipalityIdAndName(municipalityId, name);
  }

  @GetMapping("location/{locationId}/colonies")
  public List<DropDownDTO> getColoniesByLocationIdAndName(@PathVariable int locationId, @RequestParam String name) {
    return addressService.getColoniesByLocationIdAndName(locationId, name);
  }

  @GetMapping("/location/colonies")
  public List<DropDownDTO> getColoniesByZipCode(@RequestParam String zipCode) {
    return addressService.getColoniesByZipCode(zipCode);
  }

  @GetMapping("/colony/{colonyId}/streets")
  public List<DropDownDTO> getStreetsByColonyIAndName(@PathVariable int colonyId, @RequestParam String name) {
    return addressService.getStreetsByColonyIdAndName(colonyId, name);
  }

  @PostMapping("/create")
  public AddressDTO create(@RequestBody AddressDTO address) {
    return addressService.create(address);
  }

}
