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
public class PurchaseDTO {

    private Integer idPurchase;

    @NotNull
    private LocalDateTime purchaseDate;

    @NotNull
    private BigDecimal total;

    @NotNull
    @Size(min = 3, max = 50, message = "El tipo de comprobante debe tener entre 3 y 50 caracteres")
    private String receiptType;

    @NotNull
    @Size(min = 1, max = 10, message = "El número de comprobante no puede superar los 10 caracteres")
    private String receiptNumber;

    @NotNull
    private Integer idSupplier;

    @NotNull
    private Integer idEmployee;
}