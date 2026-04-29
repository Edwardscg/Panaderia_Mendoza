package com.mendozabakery.bakeryappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCustomer;

    @Column(nullable = false, length = 70)
    private String nameCustomer;

    @Column(nullable = true, length = 20)
    private String dni;

    @Column(nullable = true, length = 15)
    private String phone;

    @Column(nullable = true, length = 100)
    private String email;

    @Column(nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Sale> sales;
}
