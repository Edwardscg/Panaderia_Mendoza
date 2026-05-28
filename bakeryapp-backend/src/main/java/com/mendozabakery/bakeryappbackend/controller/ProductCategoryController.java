package com.mendozabakery.bakeryappbackend.controller;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.ProductCategory;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.mendozabakery.bakeryappbackend.service.IProductCategoryService;

@RestController
@RequestMapping("/product-categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductCategoryController {

    private final IProductCategoryService service;

    @GetMapping
    public List<ProductCategory> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductCategory findById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public ProductCategory save(@RequestBody ProductCategory productCategory) throws Exception {
        return service.save(productCategory);
    }

    @PutMapping("/{id}")
    public ProductCategory update(@RequestBody ProductCategory productCategory, @PathVariable("id") Integer id) throws Exception {
        return service.update(productCategory, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}