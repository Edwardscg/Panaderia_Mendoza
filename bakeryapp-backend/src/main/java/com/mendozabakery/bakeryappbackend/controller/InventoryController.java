package com.mendozabakery.bakeryappbackend.controller;

import java.net.URI;
import java.util.List;

import com.mendozabakery.bakeryappbackend.dto.InventoryDTO;
import com.mendozabakery.bakeryappbackend.model.Inventory;
import com.mendozabakery.bakeryappbackend.service.IInventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/inventories")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class InventoryController {

    private final IInventoryService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<InventoryDTO>> findAll() throws Exception {
        List<InventoryDTO> list = service.findAll().stream()
                .map(i -> modelMapper.map(i, InventoryDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDTO> findById(@PathVariable Integer id) throws Exception {
        Inventory obj = service.findById(id);
        InventoryDTO dto = modelMapper.map(obj, InventoryDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody InventoryDTO dto) throws Exception {
        Inventory obj = service.save(modelMapper.map(dto, Inventory.class));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdInventory()) // Se usa getIdInventory() según tu modelo anterior
                .toUri();
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

    @GetMapping("/hateoas/{id}")
    public EntityModel<Inventory> findByIdHateoas(@PathVariable Integer id) throws Exception {
        Inventory obj = service.findById(id);


        EntityModel<Inventory> entityModel = EntityModel.of(obj);

        WebMvcLinkBuilder link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(InventoryController.class).findById(id));
        WebMvcLinkBuilder link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(InventoryController.class).findAll());
        WebMvcLinkBuilder link3 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).findAll()); // Cambiado a ProductController ya que Inventory se relaciona con Product

        entityModel.add(link1.withRel("inventory-self-info"));
        entityModel.add(link2.withRel("inventory-all-info"));
        entityModel.add(link3.withRel("product-all-info"));
        return entityModel;
    }
}