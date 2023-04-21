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
import jakarta.persistence.OneToOne;
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
@Table(schema = "dbo", name = "Employee")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Employee {

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Person_ID")
  private Person person;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Commercial_Branch_ID")
  private CommercialBranch commercialBranch;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Email", length = 2147483647)
  private String email;

  @Column(name = "Active")
  private Boolean active;

  @JsonIgnore
  @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee")
  private User user;

}
