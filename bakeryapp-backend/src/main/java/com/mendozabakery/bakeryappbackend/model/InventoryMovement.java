package com.mendozabakery.bakeryappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class InventoryMovement {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovement;

    @Column(nullable = false, length = 50)
    private String movementType; // ENTRADA / SALIDA

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date movementDate;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    @JoinColumn(name = "id_product", nullable = false, foreignKey = @ForeignKey(name = "FK_MOVEMENT_PRODUCT"))
    private Product product;

    @Column(nullable = true)
    @JoinColumn(name = "id_sale", nullable = false, foreignKey = @ForeignKey(name = "FK_MOVEMENT_SALE"))
    private Sale sale;

    @Column(nullable = true)
    @JoinColumn(name = "id_purchase", nullable = false, foreignKey = @ForeignKey(name = "FK_MOVEMENT_PURCHASE"))
    private Purchase purchase;
}
