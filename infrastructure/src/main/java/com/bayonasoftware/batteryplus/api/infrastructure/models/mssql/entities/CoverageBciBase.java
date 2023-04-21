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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "dbo", name = "Coverage_Bci_Base")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class CoverageBciBase {

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Coverage_Type_ID")
  private CoverageType coverageType;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Bci_Base_ID")
  private BciBase bciBase;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Months_Start", nullable = false)
  private int monthsStart;

  @Column(name = "Months_End", nullable = false)
  private int monthsEnd;

  @Column(name = "Percentage", nullable = false)
  private int percentage;

}
