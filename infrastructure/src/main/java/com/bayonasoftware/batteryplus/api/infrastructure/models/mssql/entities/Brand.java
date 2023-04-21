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
@Table(schema = "dbo", name = "Brand")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Brand {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Name", nullable = false, length = 2147483647)
  private String name;

  @Column(name = "Initials", length = 10)
  private String initials;

  @Column(name = "Active", nullable = false)
  private Boolean active;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
  private Set<SubBrand> subBrands;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
  private Set<BciWarranty> bciWarranties;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
  private Set<CoverageBrand> coverageBrands;

}
