package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Integer idProduct;

    @NotNull
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    private String name;

    @NotNull
    @Size(max = 120, message = "La descripción no puede superar los 120 caracteres")
    private String description;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal salePrice;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal productionCost;

    @NotNull
    @Size(max = 30, message = "El tipo no puede superar los 30 caracteres")
    private String type;

    @NotNull
    @Size(max = 30, message = "La unidad de medida no puede superar los 30 caracteres")
    private String unitMeasure;

    @NotNull
    private Boolean status;

    @NotNull
    private Integer idCategory;
}