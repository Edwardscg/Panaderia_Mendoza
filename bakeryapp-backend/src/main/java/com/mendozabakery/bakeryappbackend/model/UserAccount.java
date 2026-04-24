package com.mendozabakery.bakeryappbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUser;

    @Column(nullable = false, length = 70)
    private String username;


    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String role;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne

    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_USERACCOUNT_EMPLOYEE"))
    private Employee employee;
}

