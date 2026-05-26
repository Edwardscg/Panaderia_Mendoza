package com.mendozabakery.bakeryappbackend.service;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.ProductCategory;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.repository.IProductCategoryRepositoryI;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProductCategoryService extends GenericService<ProductCategory, Integer>
        implements IProductCategoryService {

    private final IProductCategoryRepositoryI repo;

    @Override
    protected IGenericRepository<ProductCategory, Integer> getRepo() {
        return repo;
    }
}