package com.mendozabakery.bakeryappbackend.service.implementation;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Supplier;
import com.mendozabakery.bakeryappbackend.service.ISupplierService;
import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.repository.ISupplierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierService implements ISupplierService {

    private final ISupplierRepository repo;

    @Override
    public Supplier save(Supplier supplier) throws Exception {
        return repo.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier, Integer id) throws Exception {
        supplier.setIdSupplier(id);
        return repo.save(supplier);
    }

    @Override
    public List<Supplier> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Supplier findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Supplier());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}