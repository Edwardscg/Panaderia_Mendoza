package com.mendozabakery.bakeryappbackend.service;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.ProductCategory;
import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.repository.IProductCategoryRepositoryI;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCategoryService implements IProductCategoryService {

    private final IProductCategoryRepositoryI repo;

    @Override
    public ProductCategory save(ProductCategory productCategory) throws Exception {
        return repo.save(productCategory);
    }

    @Override
    public ProductCategory update(ProductCategory productCategory, Integer id) throws Exception {
        productCategory.setIdCategory(id);
        return repo.save(productCategory);
    }

    @Override
    public List<ProductCategory> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public ProductCategory findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new ProductCategory());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}