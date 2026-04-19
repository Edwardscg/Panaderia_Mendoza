package com.mendozabakery.bakeryappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sale {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSale;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date saleDate;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false, length = 50)
    private String receiptType;

    @Column(nullable = false, length = 50)
    private String receiptNumber;

    @Column(nullable = false, length = 50)
    private String paymentMethod;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_CUSTOMER"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_EMPLOYEE"))
    private Employee employee;
}
