package com.mendozabakery.bakeryappbackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {

    private Integer idInventory;

    @NotNull
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer currentStock;

    @NotNull
    private LocalDateTime lastUpdate;

    @NotNull
    private Integer idProduct;
}