package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailDTO {

    private Integer idSaleDetail;

    @NotNull
    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private Integer quantity;

    @NotNull
    private BigDecimal unitCost;

    @NotNull
    private BigDecimal subtotal;

    @NotNull
    private Integer idSale;

    @NotNull
    private Integer idProduct;
}