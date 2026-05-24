package com.mendozabakery.bakeryappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.time.LocalDateTime;

=======
>>>>>>> 548ce5e59d8f02655bdaa7f4d5a5315cf75b3dd1
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

<<<<<<< HEAD
    @Column(nullable = false)
    private LocalDateTime lastUpdate;

    //Relacion con Product 1 a 1
=======
>>>>>>> 548ce5e59d8f02655bdaa7f4d5a5315cf75b3dd1
    @OneToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;
}
