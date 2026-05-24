package com.mendozabakery.bakeryappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Inventory {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idInventory;

    @Column(nullable = false)
    private int currentStock;

    @Column(nullable = false)
    private LocalDateTime lastUpdate;

    //Relacion con Product 1 a 1
    @OneToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;
}
