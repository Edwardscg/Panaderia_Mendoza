package com.mendozabakery.bakeryappbackend.service;

import java.util.List;
import com.mendozabakery.bakeryappbackend.model.InventoryMovement;

public interface IInventoryMovementService {
    InventoryMovement save(InventoryMovement movement) throws Exception;

    List<InventoryMovement> findAll() throws Exception;

    InventoryMovement findById(Integer id) throws Exception;
}
