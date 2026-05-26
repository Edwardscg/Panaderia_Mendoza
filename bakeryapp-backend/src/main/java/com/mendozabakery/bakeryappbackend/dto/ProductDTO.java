package com.mendozabakery.bakeryappbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Integer idProduct;
    private String name;
    private String description;
    private Double salePrice;
    private Double productionCost;
    private String type;
    private String unitMeasure;
    private Boolean status;
    private Integer idCategory;
}