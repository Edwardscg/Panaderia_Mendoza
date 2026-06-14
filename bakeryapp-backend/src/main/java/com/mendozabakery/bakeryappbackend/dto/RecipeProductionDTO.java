package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeProductionDTO {

    private Integer idProduction;

    @NotNull
    @Min(value = 1, message = "La cantidad producida debe ser mayor a 0")
    private Integer quantityProduced;

    @NotNull
    private LocalDateTime productionDate;

    @NotNull
    private Integer idRecipe;

    @NotNull
    private Integer idEmployee;
}