package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.model.Purchase;
import com.mendozabakery.bakeryappbackend.service.IPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PurchaseController {
    private final IPurchaseService service;

    @GetMapping
    public List<Purchase> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Purchase findById(@PathVariable Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Purchase save(@RequestBody Purchase purchase) throws Exception{
        return service.save(purchase);
    }

    @PutMapping("/{id}")
    public Purchase update(@RequestBody Purchase purchase, @PathVariable Integer id) throws Exception{
        purchase.setIdPurchase(id);
        return service.save(purchase);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception{
        service.delete(id);
    }
}
