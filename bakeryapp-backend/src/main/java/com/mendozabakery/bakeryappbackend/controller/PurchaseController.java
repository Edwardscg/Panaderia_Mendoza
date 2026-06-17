package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.dto.PurchaseDTO;
import com.mendozabakery.bakeryappbackend.model.Purchase;
import com.mendozabakery.bakeryappbackend.service.IPurchaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class PurchaseController {

    private final IPurchaseService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PurchaseDTO>> findAll() throws Exception {

        List<PurchaseDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, PurchaseDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> findById(@PathVariable Integer id) throws Exception {

        Purchase obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PurchaseDTO dto) throws Exception {

        Purchase obj = service.save(modelMapper.map(dto, Purchase.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPurchase()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseDTO> update(@RequestBody PurchaseDTO dto, @PathVariable Integer id) throws Exception {

        Purchase obj = service.update(modelMapper.map(dto, Purchase.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, PurchaseDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}