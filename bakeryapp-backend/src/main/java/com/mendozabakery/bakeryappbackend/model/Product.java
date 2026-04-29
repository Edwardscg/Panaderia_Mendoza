package com.mendozabakery.bakeryappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProduct;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 120)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salePrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal productionCost;

    @Column(nullable = false, length = 30)
    private String type;

    @Column(nullable = false, length = 30)
    private String unitMeasure;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_category", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY"))
    private ProductCategory category;

    @OneToOne(mappedBy = "product")
    @JsonIgnore
    private Inventory inventory;

    @OneToMany(mappedBy = "product")
    private Set<Recipe> recipes;

    @OneToMany(mappedBy = "product")
    private Set<PurchaseDetail> purchaseDetails;

    @OneToMany(mappedBy = "product")
    private Set<RecipeDetail> recipeDetails;

    @OneToMany(mappedBy = "product")
    private Set<SaleDetail> saleDetails;
}
