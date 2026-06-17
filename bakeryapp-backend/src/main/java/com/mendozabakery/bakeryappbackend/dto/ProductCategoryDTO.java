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
<<<<<<< HEAD
    @Size(min = 3, max = 50,
          message = "El nombre no puede ser menor a 3 caracteres ni mayor a 50 caracteres")
    private String name;

    @NotNull
    @Size(min = 5, max = 150,
          message = "La descripción no puede ser menor a 5 caracteres ni mayor a 150 caracteres")
=======
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    private String name;

    @NotNull
    @Size(max = 150, message = "La descripción no puede superar los 150 caracteres")
>>>>>>> 59e83850611de3ac76a569b2b78ee2c688a20d3c
    private String description;

    @NotNull
    private Boolean status;
}