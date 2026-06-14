package com.mendozabakery.bakeryappbackend.service.implementation;

import com.mendozabakery.bakeryappbackend.model.ProductCategory;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
import com.mendozabakery.bakeryappbackend.service.IProductCategoryService;
import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.repository.IProductCategoryRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProductCategoryService extends GenericService<ProductCategory, Integer>
        implements IProductCategoryService {

    private final IProductCategoryRepository repo;

    @Override
    protected IGenericRepository<ProductCategory, Integer> getRepo() {
        return repo;
    }
}