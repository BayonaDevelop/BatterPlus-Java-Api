package com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(schema = "dbo", name = "Bci_Warranty")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class BciWarranty {

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Bci_Base_ID")
  private BciBase bciBase;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Line_ID")
  private Line line;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Brand_ID")
  private Brand brand;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Sub_Brand_ID")
  private SubBrand subBrand;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Amperage", nullable = false, length = 2147483647)
  private String amperage;

  @Column(name = "Active")
  private Boolean active;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "bciWarranty")
  private Set<Accumulator> accumulators;

}
