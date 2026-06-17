package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {

    private Integer idSale;

    @NotNull
    private LocalDateTime saleDate;

    @NotNull
    private BigDecimal total;

    @NotNull
    @Size(min = 3, max = 50, message = "El tipo de comprobante debe tener entre 3 y 50 caracteres")
    private String receiptType;

    @NotNull
    @Size(min = 1, max = 50, message = "El número de comprobante debe tener entre 1 y 50 caracteres")
    private String receiptNumber;

    @NotNull
    @Size(min = 3, max = 50, message = "El método de pago debe tener entre 3 y 50 caracteres")
    private String paymentMethod;

    @NotNull
    private Integer idCustomer;

    @NotNull
    private Integer idEmployee;
}