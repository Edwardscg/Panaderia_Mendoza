package com.mendozabakery.bakeryappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PurchaseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPurchaseDetail;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitCost;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_purchase", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASEDETAIL_PURCHASE"))
    private Purchase purchase;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_product", nullable = false, foreignKey = @ForeignKey(name = "FK_PURCHASEDETAIL_PRODUCT"))
    private Product product;
}
