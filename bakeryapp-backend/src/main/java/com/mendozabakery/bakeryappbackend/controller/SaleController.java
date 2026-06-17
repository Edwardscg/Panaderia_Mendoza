package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.dto.SaleDTO;
import com.mendozabakery.bakeryappbackend.model.Sale;
import com.mendozabakery.bakeryappbackend.service.ISaleService;
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
@RequestMapping("/sales")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class SaleController {

    private final ISaleService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<SaleDTO>> findAll() throws Exception {

        List<SaleDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, SaleDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Integer id) throws Exception {

        Sale obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SaleDTO dto) throws Exception {

        Sale obj = service.save(modelMapper.map(dto, Sale.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSale()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> update(@RequestBody SaleDTO dto, @PathVariable Integer id) throws Exception {

        Sale obj = service.update(modelMapper.map(dto, Sale.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, SaleDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}