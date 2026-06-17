package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDTO {

    private Integer idCategory;

    @NotNull
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    private String name;

    @NotNull
    @Size(max = 150, message = "La descripción no puede superar los 150 caracteres")
    private String description;

    @NotNull
    private Boolean status;
}