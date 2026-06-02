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

    @Column(length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String position;

    @Column(nullable = false)
    private Boolean status;

    @OneToOne(mappedBy = "employee")
    @JsonIgnore
    private UserAccount userAccount;

}