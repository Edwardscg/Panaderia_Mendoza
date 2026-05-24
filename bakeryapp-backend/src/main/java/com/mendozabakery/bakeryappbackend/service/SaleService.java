package com.mendozabakery.bakeryappbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.model.Sale;
import com.mendozabakery.bakeryappbackend.repository.ISaleRepositoryI;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService{
    private final ISaleRepositoryI repo;

    @Override
    public Sale save(Sale sale) throws Exception {
        return repo.save(sale);
    }

    @Override
    public Sale update(Sale sale, Integer id) throws Exception {
        sale.setIdSale(id);
        return repo.save(sale);
    }

    @Override
    public List<Sale> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Sale findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Sale());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
