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

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "dbo", name = "Accumulator")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Accumulator {

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Bci_Used_ID")
  private BciUsed bciUsed;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "Bci_Warranty_ID")
  private BciWarranty bciWarranty;

  @Id
  @Column(name = "Id", nullable = false)
  private long id;

  @Column(name = "Status", nullable = false)
  private int status;


  @Column(name = "Previous_Status", nullable = true)
  private Integer previousStatus;

  @Column(name = "Policy", nullable = false, length = 2147483647)
  private String policy;

  @Column(name = "Bill", nullable = true, length = 2147483647)
  private String bill;

  @Column(name = "Purchase_Note", nullable = true, length = 2147483647)
  private String purchaseNote;

  @Column(name = "Voltage", nullable = true, precision = 2)
  private BigDecimal voltage;

  @Column(name = "Price", nullable = true, precision = 2)
  private BigDecimal price;

  @Column(name = "From_Taxist", nullable = true)
  private Boolean fromTaxist;

  @Column(name = "Pressable", nullable = true)
  private Boolean pressable;

  @Column(name = "Borrowed", nullable = true)
  private Boolean borrowed;

  @Column(name = "Admission_Date", nullable = true)
  private Date admissionDate;

  @Column(name = "Policy_Date", nullable = true)
  private Date policyDate;

  @Column(name = "Sale_Date", nullable = true)
  private Date saleDate;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "accumulator")
  private Set<MovementDetail> movements;

}
