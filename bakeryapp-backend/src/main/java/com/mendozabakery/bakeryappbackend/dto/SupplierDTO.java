package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

    private Integer idSupplier;

    @NotNull
    @Size(min = 3, max = 100, message = "La razón social debe tener entre 3 y 100 caracteres"
    )
    private String businessName;

    @NotNull
    @Size(min = 11, max = 11, message = "El RUC debe tener exactamente 11 caracteres")
    private String ruc;

    @NotNull
    @Size(min = 9, max = 10, message = "El teléfono debe tener entre 9 y 10 caracteres")
    private String phone;

    @NotNull
    @Size(min = 5, max = 100, message = "El correo debe tener entre 5 y 100 caracteres")
    private String email;

    @NotNull
    @Size(min = 5, max = 150, message = "La dirección debe tener entre 5 y 150 caracteres")
    private String address;

    @NotNull
    private Boolean status;
}