package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.dto.SupplierDTO;
import com.mendozabakery.bakeryappbackend.model.Supplier;
import com.mendozabakery.bakeryappbackend.service.ISupplierService;
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
@RequestMapping("/suppliers")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class SupplierController {

    private final ISupplierService service;

    @Qualifier("suppliertMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> findAll() throws Exception {

        List<SupplierDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, SupplierDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable Integer id) throws Exception {

        Supplier obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SupplierDTO dto) throws Exception {

        Supplier obj = service.save(modelMapper.map(dto, Supplier.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSupplier()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> update(@RequestBody SupplierDTO dto, @PathVariable Integer id) throws Exception {

        Supplier obj = service.update(modelMapper.map(dto, Supplier.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, SupplierDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}