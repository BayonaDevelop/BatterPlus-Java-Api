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

import java.math.BigDecimal;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "dbo", name = "Commercial_Branch")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class CommercialBranch {

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Address_ID")
  private Address address;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Matrix_ID")
  private CommercialBranch mainBranch;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Name", length = 2147483647, nullable = false)
  private String name;

  @Column(name = "Active")
  private Boolean active;

  @Column(name = "Matrix")
  private Boolean matrix;

  @Column(name = "Latitude", precision = 10)
  private BigDecimal latitude;

  @Column(name = "Longitude", precision = 10)
  private BigDecimal longitude;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "commercialBranch")
  private Set<Warehouse> warehouses;

}
