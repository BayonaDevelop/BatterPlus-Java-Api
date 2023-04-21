package com.bayonasoftware.batteryplus.api.infrastructure.models.mssql.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "dbo", name = "Movement")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Movement {

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Warehouse_Section_Origin_ID")
  private WarehouseSection sectionOrigin;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Warehouse_Section_ID")
  private WarehouseSection section;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "User_ID")
  private User user;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Serving_User_ID")
  private User servingUser;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Client_ID")
  private Client client;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Person_ID")
  private Person person;

  @Id
  @Column(name = "Id", nullable = false)
  private int id;

  @Column(name = "Type", nullable = false)
  private short type;

  @Column(name = "Status", nullable = true)
  private Short status;

  @Column(name = "Reception_Date", nullable = true)
  private Date receptionDate;

  @Column(name = "Comments", nullable = true, length = 2147483647)
  private String comments;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "movement")
  private Set<MovementDetail> details;

}
