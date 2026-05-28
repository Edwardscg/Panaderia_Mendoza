package com.mendozabakery.bakeryappbackend.service;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Customer;
import com.mendozabakery.bakeryappbackend.model.Supplier;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.repository.ISupplierRepositoryI;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierService extends GenericService<Supplier, Integer> implements ISupplierService {

    private final ISupplierRepositoryI repo;

    @Override
    protected IGenericRepository<Supplier, Integer> getRepo() {
        return repo;
    }


//    @Override
//    public Supplier update(Supplier supplier, Integer id) throws Exception {
//        supplier.setIdSupplier(id);
//        return repo.save(supplier);
//    }
//
//    @Override
//    public List<Supplier> findAll() throws Exception {
//        return repo.findAll();
//    }
//
//    @Override
//    public Supplier findById(Integer id) throws Exception {
//        return repo.findById(id).orElse(new Supplier());
//    }
//
//    @Override
//    public void delete(Integer id) throws Exception {
//        repo.deleteById(id);
//    }
}