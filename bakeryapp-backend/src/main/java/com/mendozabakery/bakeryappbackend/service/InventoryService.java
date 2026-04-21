package com.mendozabakery.bakeryappbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.model.Inventory;
import com.mendozabakery.bakeryappbackend.repository.IInventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService implements IInventoryService {

    private final IInventoryRepository repo;

    @Override
    public Inventory save(Inventory inventory) throws Exception {
        return repo.save(inventory);
    }

    @Override
    public Inventory update(Inventory inventory, Integer id) throws Exception {
        inventory.setIdInventory(id);
        return repo.save(inventory);
    }

    @Override
    public List<Inventory> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Inventory findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Inventory());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
