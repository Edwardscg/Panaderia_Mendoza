package com.mendozabakery.bakeryappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployee;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 15)
    private String dni;

    @Column(length = 15)
    private String phone;

<<<<<<< HEAD
    @Column(length = 100)
    private String email;

    @Column(nullable = false, length = 50)
=======
    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 70)
>>>>>>> 548ce5e59d8f02655bdaa7f4d5a5315cf75b3dd1
    private String position;

    @Column(nullable = false)
    private boolean status;
<<<<<<< HEAD
=======

    @OneToOne(mappedBy = "employee")
    @JsonIgnore
    private UserAccount userAccount;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Set<Purchase> purchases;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Set<Sale> sales;
>>>>>>> 548ce5e59d8f02655bdaa7f4d5a5315cf75b3dd1
}
