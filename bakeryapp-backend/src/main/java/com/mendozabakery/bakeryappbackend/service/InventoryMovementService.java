package com.mendozabakery.bakeryappbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.model.InventoryMovement;
import com.mendozabakery.bakeryappbackend.repository.IInventoryMovementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryMovementService implements IInventoryMovementService{
    private final IInventoryMovementRepository repo;

    @Override
    public InventoryMovement save(InventoryMovement movement) throws Exception {
        return repo.save(movement);
    }

    @Override
    public InventoryMovement update(InventoryMovement movement, Integer id) throws Exception {
        movement.setIdInventoryMovement(id);
        return repo.save(movement);
    }

    @Override
    public List<InventoryMovement> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public InventoryMovement findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new InventoryMovement());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
