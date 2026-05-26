package com.mendozabakery.bakeryappbackend.service;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Customer;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
import org.modelmapper.internal.bytebuddy.description.type.TypeList;
import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.model.Inventory;
import com.mendozabakery.bakeryappbackend.repository.IInventoryRepositoryI;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService extends GenericService<Inventory, Integer> implements IInventoryService {

    private final IInventoryRepositoryI repo;

    @Override
    protected IGenericRepository<Inventory, Integer> getRepo() {
        return repo;
    }

//    @Override
//    public Inventory update(Inventory inventory, Integer id) throws Exception {
//        inventory.setIdInventory(id);
//        return repo.save(inventory);
//    }
//
//    @Override
//    public List<Inventory> findAll() throws Exception {
//        return repo.findAll();
//    }
//
//    @Override
//    public Inventory findById(Integer id) throws Exception {
//        return repo.findById(id).orElse(new Inventory());
//    }
//
//    @Override
//    public void delete(Integer id) throws Exception {
//        repo.deleteById(id);
//    }
}
