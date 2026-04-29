package com.mendozabakery.bakeryappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPurchase;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime purchaseDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(nullable = false, length = 50)
    private String receiptType;

    @Column(nullable = false, length = 10)
    private String receiptNumber;

    @ManyToOne
    @JoinColumn(name = "id_supplier", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_SUPPLIER"))
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_EMPLOYEE"))
    private Employee employee;

    @OneToMany(mappedBy = "purchase")
    @JsonIgnore
    private Set<PurchaseDetail> purchaseDetails;
}