package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Integer idCustomer;

    @NotNull
    @Size(min = 3, max = 70, message = "El nombre no puede ser menor a 3 carácteres, ni mayor a 70 carácteres")
    private String nameCustomer;

    @Size(min = 8, max = 20)
    private String dni;

    @Size(min = 9, max = 15)
    private String phone;

    @Size(min = 13, max = 100)
    private String email;

    @NotNull
    private Boolean status;
}
