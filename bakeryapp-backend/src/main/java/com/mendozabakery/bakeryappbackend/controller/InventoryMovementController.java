package com.mendozabakery.bakeryappbackend.controller;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.InventoryMovement;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.mendozabakery.bakeryappbackend.service.IInventoryMovementService;

@RestController
@RequestMapping("/inventory-movements")
@RequiredArgsConstructor
public class InventoryMovementController {

    private final IInventoryMovementService service;

    @GetMapping
    public List<InventoryMovement> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public InventoryMovement findById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public InventoryMovement save(@RequestBody InventoryMovement movement) throws Exception {
        return service.save(movement);
    }
}
