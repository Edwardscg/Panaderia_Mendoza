package com.mendozabakery.bakeryappbackend.controller;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Supplier;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.mendozabakery.bakeryappbackend.service.ISupplierService;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final ISupplierService service;

    @GetMapping
    public List<Supplier> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Supplier findById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public Supplier save(@RequestBody Supplier supplier) throws Exception {
        return service.save(supplier);
    }

    @PutMapping("/{id}")
    public Supplier update(@RequestBody Supplier supplier, @PathVariable("id") Integer id) throws Exception {
        return service.update(supplier, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}