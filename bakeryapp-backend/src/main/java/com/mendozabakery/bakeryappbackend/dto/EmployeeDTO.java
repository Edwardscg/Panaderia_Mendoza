package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer idEmployee;
    @NotNull
    @Size(min = 3, max = 70, message = "El nombre no puede ser menor a 3 carácteres ni mayor a 50 carácteres")
    private String firstName;
    @NotNull
    @Size(min = 3, max = 70, message = "El apellido no puede ser menor a 3 carácteres ni mayor a 50 carácteres")
    private String lastName;
    @Size(min = 8, max = 20)
    @NotNull
    private String dni;
    @NotNull
    @Size(min = 9, max = 15)
    private String phone;
    @NotNull
    @Size(min = 13, max = 100, message = "El correo debe tener entre 13 y 100 caracteres")
    private String email;
    @NotNull
    private String position;
    @NotNull
    private Boolean status;
}
