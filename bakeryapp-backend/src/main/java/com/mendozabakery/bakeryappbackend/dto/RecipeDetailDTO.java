package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDetailDTO {

    private Integer idRecipeDetail;

    @NotNull
    private Double quantity;

    @NotNull
    @Size(min = 1, max = 30, message = "La unidad debe tener entre 1 y 30 caracteres")
    private String unit;

    @NotNull
    private Integer idRecipe;

    @NotNull
    private Integer idProduct;
}