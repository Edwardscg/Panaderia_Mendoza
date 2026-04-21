package com.mendozabakery.bakeryappbackend.service;

import java.util.List;
import com.mendozabakery.bakeryappbackend.model.Inventory;

public interface IInventoryService {

    Inventory save(Inventory inventory) throws Exception;

    Inventory update(Inventory inventory, Integer id) throws Exception;

    List<Inventory> findAll() throws Exception;

    Inventory findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
