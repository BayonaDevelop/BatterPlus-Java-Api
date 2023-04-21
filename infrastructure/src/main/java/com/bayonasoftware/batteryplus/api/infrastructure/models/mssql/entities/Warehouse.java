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
@Table(schema = "dbo", name = "Warehouse")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Warehouse {

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Address_ID")
  private Address address;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Commercial_Branch_ID")
  private CommercialBranch commercialBranch;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Name", nullable = false, length = 2147483647)
  private String name;

  @Column(name = "Active")
  private Boolean active;

  @Column(name = "Latitude", precision = 10)
  private BigDecimal latitude;

  @Column(name = "Longitude", precision = 10)
  private BigDecimal longitude;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse")
  private Set<WarehouseSection> warehouseSections;

}
