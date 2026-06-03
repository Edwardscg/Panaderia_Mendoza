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
    @Size(min = 3, max = 50,
          message = "El nombre no puede ser menor a 3 caracteres ni mayor a 50 caracteres")
    private String name;

    @NotNull
    @Size(min = 5, max = 150,
          message = "La descripción no puede ser menor a 5 caracteres ni mayor a 150 caracteres")
    private String description;

    @NotNull
    private Boolean status;
}