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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(schema = "dbo", name = "Users")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class User {

  @JsonIgnore
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Employee_ID")
  private Employee employee;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "UserName", nullable = false, length = 2147483647)
  private String userName;

  @Column(name = "Password", nullable = false, length = 2147483647)
  private String password;

  @Column(name = "Enabled")
  private Boolean enabled;

  @Column(name = "Attempts")
  private int attempts;

  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      schema = "dbo",
      name = "Users_Roles",
      joinColumns ={ @JoinColumn(name = "user_id", nullable = false, updatable = false)},
      inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) }
  )
  private Set<Role> roles;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private Set<Movement> createdMovements;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "servingUser")
  private Set<Movement> cateredMovements;

}
