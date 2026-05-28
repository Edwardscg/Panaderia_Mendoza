package com.mendozabakery.bakeryappbackend.service;

import com.mendozabakery.bakeryappbackend.model.Product;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
import com.mendozabakery.bakeryappbackend.repository.IProductRepositoryI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService extends GenericService<Product, Integer> implements IProductService{
    private final IProductRepositoryI repo;

    @Override
    protected IGenericRepository<Product, Integer> getRepo() {
        return repo;
    }

//    @Override
//    public Product save (Product product) throws Exception{
//        return repo.save(product);
//    }
//
//    @Override
//    public Product update (Product product, Integer id) throws Exception{
//        product.setIdProduct(id);
//        return repo.save(product);
//    }
//
//    @Override
//    public List<Product> findAll() throws Exception{
//        return repo.findAll();
//    }
//
//    @Override
//    public Product findById(Integer id) throws Exception{
//        return repo.findById(id).orElse(new Product());
//    }
//
//    @Override
//    public void delete(Integer id) throws Exception{
//        repo.deleteById(id);
//    }
}
