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
    private Integer idInventoryMovement;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false, length = 50)
    private String type; // ENTRADA / SALIDA

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(nullable = false)
    private boolean status;
}
