package com.mendozabakery.bakeryappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
<<<<<<< HEAD
=======
import java.util.Set;
>>>>>>> 548ce5e59d8f02655bdaa7f4d5a5315cf75b3dd1

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
    private LocalDateTime saleDate;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false, length = 50)
    private String receiptType;

    @Column(nullable = false, length = 50)
    private String receiptNumber;

    @Column(nullable = false, length = 50)
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_CUSTOMER"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_EMPLOYEE"))
    private Employee employee;

    @OneToMany(mappedBy = "sale")
    @JsonIgnore
    private Set<SaleDetail> saleDetails;
}
