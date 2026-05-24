package com.mendozabakery.bakeryappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCategory;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products;
}
