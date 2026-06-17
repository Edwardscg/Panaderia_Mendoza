package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTO {
    private Integer idUser;

    @NotNull
    @Size(min = 3, max = 70, message = "El nombre de usuario no puede ser menor a 3 caracteres ni mayor a 70 caracteres")
    private String username;

    @NotNull
    @Size(min = 8, max = 100, message = "La contraseña debe tener entre 8 y 100 caracteres")
    private String password;

    @NotNull
    private Boolean status;

    @NotNull
    private Integer idEmployee;
}
