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

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEmployee;

    @Column(nullable = false, length = 70)
    private String firstName;

    @Column(nullable = false, length = 70)
    private String lastName;

    @Column(nullable = false, length = 8)
    private String dni;

    @Column(nullable = false, length = 9)
    private String phone;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 70)
    private String position;

    @Column(nullable = false)
    private boolean status;

    @OneToOne(mappedBy = "employee")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "employee")
    private Set<Purchase> purchases;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Set<Sale> sales;
}
