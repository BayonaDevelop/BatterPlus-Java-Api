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
@Table(schema = "dbo", name = "Person")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Person {

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Address_ID")
  private Address address;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Name", length = 2147483647, nullable = false)
  private String name;

  @Column(name = "Last_Name", length = 2147483647, nullable = false)
  private String lastName;

  @Column(name = "Second_Last_Name", length = 2147483647, nullable = false)
  private String secondLastName;

  @Column(name = "INE", length = 2147483647)
  private String ine;

  @Column(name = "Driver_License", length = 2147483647)
  private String driverLicense;

  @Column(name = "Email", length = 2147483647)
  private String email;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
  private Set<Telephone> telephones;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
  private Set<Movement> movements;

}
