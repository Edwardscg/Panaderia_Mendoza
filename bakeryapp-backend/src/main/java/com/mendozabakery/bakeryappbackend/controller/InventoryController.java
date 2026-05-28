package com.mendozabakery.bakeryappbackend.controller;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Inventory;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.mendozabakery.bakeryappbackend.service.IInventoryService;

@RestController
@RequestMapping("/inventories")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InventoryController {

    private final IInventoryService service;

    @GetMapping
    public List<Inventory> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Inventory findById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public Inventory save(@RequestBody Inventory inventory) throws Exception {
        return service.save(inventory);
    }

    @PutMapping("/{id}")
    public Inventory update(@RequestBody Inventory inventory, @PathVariable("id") Integer id) throws Exception {
        return service.update(inventory, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
