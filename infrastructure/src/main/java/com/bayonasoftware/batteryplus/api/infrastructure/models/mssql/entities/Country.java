package com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "dbo", name = "Country")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Code", length = 10)
  private String code;

  @Column(name = "Code_ISO2", length = 10)
  private String codeIso2;

  @Column(name = "Name", length = 2147483647, nullable = false)
  private String name;

  @Column(name = "Postal_Code_Regex", length = 2147483647)
  private String postalCodeRegex;

  @Column(name = "Sat_Registry_Regex", length = 2147483647)
  private String satRegistryRegex;

  @Column(name = "Region", length = 2147483647)
  private String region;

  @Column(name = "Coat_Of_Arms", length = 2147483647)
  private String coatOfArms;

  @Column(name = "Flag", length = 2147483647)
  private String flag;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
  private Set<City> cities;

}
