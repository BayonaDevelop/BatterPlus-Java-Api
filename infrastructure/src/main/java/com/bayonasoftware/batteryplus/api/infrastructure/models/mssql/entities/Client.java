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
@Table(schema = "dbo", name = "Client")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Code", length = 2147483647, nullable = false)
  private Integer code;

  @Column(name = "Name", length = 2147483647)
  private String name;

  @Column(name = "Classification", length = 2147483647)
  private String classification;

  @Column(name = "Seller", length = 2147483647)
  private String seller;

  @Column(name = "Has_Veicle_Fleet")
  private Boolean hasVeicleFleet;

  @Column(name = "Active", nullable = false)
  private boolean active;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
  private Set<Movement> movements;

}
