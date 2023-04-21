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
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
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
@Table(schema = "dbo", name = "Address")
@JsonIgnoreProperties("hibernateLazyInitializer")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "CreateAddress",
        procedureName = "CreateAddress",
        resultClasses = { Long.class },
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "MunicipalityID"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "Location"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "ZipCode"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "Colony"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "Street"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "StreetA"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "StreetB"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "InternalNumber"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "ExternalNumber"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "Reference"),
            @StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "ID")
        }
    )
})
public class Address {

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Street_ID")
  private Street street;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Street_ID_A")
  private Street streetA;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Street_ID_B")
  private Street streetB;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id", nullable = false)
  private long id;

  @Column(name = "Internal_Number", length = 60)
  private String internalNumber;

  @Column(name = "External_Number", length = 60)
  private String externalNumber;

  @Column(name = "Reference", length = 2147483647)
  private String reference;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  private Set<Person> people;

}
