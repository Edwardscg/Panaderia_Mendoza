package com.mendozabakery.bakeryappbackend.model;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
=======
import lombok.*;
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserAccount {
<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUser;

    @Column(nullable = false, length = 70)
    private String username;

    @Column(nullable = false, length = 120)
=======

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 100)
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
    private String password;

    @Column(nullable = false, length = 50)
    private String role;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_USERACCOUNT_EMPLOYEE"))
    private Employee employee;
}
=======
    @JoinColumn(name = "id_employee", nullable = false)
    private Employee employee;
}
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
