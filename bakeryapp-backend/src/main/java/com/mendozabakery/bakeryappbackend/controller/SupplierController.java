package com.mendozabakery.bakeryappbackend.controller;

import java.net.URI;
import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Supplier;
import com.mendozabakery.bakeryappbackend.service.ISupplierService;

import lombok.RequiredArgsConstructor;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SupplierController {

    private final ISupplierService service;

    @GetMapping
    public ResponseEntity<List<Supplier>> findAll() throws Exception {
        List<Supplier> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable("id") Integer id) throws Exception {
        Supplier obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Supplier supplier) throws Exception {
        Supplier obj = service.save(supplier);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdSupplier())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> update(@RequestBody Supplier supplier,
                                           @PathVariable("id") Integer id) throws Exception {

        Supplier obj = service.update(supplier, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<Supplier> findByIdHateoas(@PathVariable Integer id) throws Exception {

        Supplier obj = service.findById(id);

        EntityModel<Supplier> entityModel = EntityModel.of(obj);

        WebMvcLinkBuilder link1 = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SupplierController.class).findById(id)
        );

        WebMvcLinkBuilder link2 = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SupplierController.class).findAll()
        );

        entityModel.add(link1.withRel("supplier-self-info"));
        entityModel.add(link2.withRel("supplier-all-info"));

        return entityModel;
    }
}