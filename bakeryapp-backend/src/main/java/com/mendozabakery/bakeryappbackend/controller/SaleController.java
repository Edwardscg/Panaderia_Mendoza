package com.mendozabakery.bakeryappbackend.controller;
import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Sale;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.mendozabakery.bakeryappbackend.service.ISaleService;
@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SaleController {
    private final ISaleService service;

    @GetMapping
    public List<Sale> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Sale findById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public Sale save(@RequestBody Sale sale) throws Exception {
        return service.save(sale);
    }

    @PutMapping("/{id}")
    public Sale update(@RequestBody Sale sale, @PathVariable("id") Integer id) throws Exception {
        return service.update(sale, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
