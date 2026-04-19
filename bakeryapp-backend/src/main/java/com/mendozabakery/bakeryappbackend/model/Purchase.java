package com.mendozabakery.bakeryappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

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
    private Date purchaseDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(nullable = false, length = 50)
    private String receiptType;

    @Column(nullable = false, length = 10)
    private String receiptNumber;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    @JoinColumn(name = "id_supplier", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_SUPPLIER"))
    private Supplier supplier;

    @Column(nullable = false)
    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASE_EMPLOYEE"))
    private Employee employee;
}