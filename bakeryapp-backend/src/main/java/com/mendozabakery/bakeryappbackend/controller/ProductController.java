package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.model.Product;
import com.mendozabakery.bakeryappbackend.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {
    private final IProductService service;

    @GetMapping
    public List<Product> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) throws Exception{
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product, @PathVariable("id") Integer id) throws Exception{
        return service.update(product, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
