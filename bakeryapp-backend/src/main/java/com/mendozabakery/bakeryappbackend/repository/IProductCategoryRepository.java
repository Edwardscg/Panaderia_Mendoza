package com.mendozabakery.bakeryappbackend.repository;

import com.mendozabakery.bakeryappbackend.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
