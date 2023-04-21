package com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "dbo", name = "Voltage")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Voltage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Hours", nullable = false, precision = 2)
  private BigDecimal hours;

  @Column(name = "Minimum", nullable = true, precision = 2)
  private BigDecimal minimum;

  @Column(name = "Maximum", nullable = true, precision = 2)
  private BigDecimal maximum;

  @Column(name = "Active", nullable = false)
  private boolean active;

}
