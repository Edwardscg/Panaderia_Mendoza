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
//@Table(name = "sale")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sale {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSale;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

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
}
