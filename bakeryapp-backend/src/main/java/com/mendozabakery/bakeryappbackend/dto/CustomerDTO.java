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
    @Size(min = 3, max = 50, message = "El nombre no puede ser menor a 3 carácteres")
    private String nameCustomer;
    private String dni;
    private String phone;
    private String email;
    @NotNull
    private Boolean status;
}
