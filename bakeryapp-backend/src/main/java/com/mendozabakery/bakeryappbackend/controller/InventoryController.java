package com.mendozabakery.bakeryappbackend.controller;

import java.net.URI;
import java.util.List;

import com.mendozabakery.bakeryappbackend.dto.InventoryDTO;
import com.mendozabakery.bakeryappbackend.model.Inventory;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mendozabakery.bakeryappbackend.service.IInventoryService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/inventories")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class InventoryController {

    private final IInventoryService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<InventoryDTO>> findAll() throws Exception {

        List<InventoryDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, InventoryDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> findById(@PathVariable Integer id) throws Exception {

        Inventory obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody InventoryDTO dto) throws Exception {

        Inventory obj = service.save(modelMapper.map(dto, Inventory.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdInventory()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryDTO> update(@RequestBody InventoryDTO dto, @PathVariable Integer id) throws Exception {

        Inventory obj = service.update(modelMapper.map(dto, Inventory.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, InventoryDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}