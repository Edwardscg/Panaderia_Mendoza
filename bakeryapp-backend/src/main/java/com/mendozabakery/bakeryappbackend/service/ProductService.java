package com.mendozabakery.bakeryappbackend.service;

import com.mendozabakery.bakeryappbackend.model.Product;
import com.mendozabakery.bakeryappbackend.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final IProductRepository repo;

    @Override
    public Product save (Product product) throws Exception{
        return repo.save(product);
    }

    @Override
    public Product update (Product product, Integer id) throws Exception{
        product.setIdProduct(id);
        return repo.save(product);
    }

    @Override
    public List<Product> findAll() throws Exception{
        return repo.findAll();
    }

    @Override
    public Product findById(Integer id) throws Exception{
        return repo.findById(id).orElse(new Product());
    }

    @Override
    public void delete(Integer id) throws Exception{
        repo.deleteById(id);
    }
}
