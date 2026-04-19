package com.mendozabakery.bakeryappbackend.model;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String position;

    @Column(nullable = false)
    private boolean status;
}