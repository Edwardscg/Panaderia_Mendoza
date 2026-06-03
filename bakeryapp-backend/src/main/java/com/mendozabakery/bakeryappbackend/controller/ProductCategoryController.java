package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.dto.ProductCategoryDTO;
import com.mendozabakery.bakeryappbackend.model.Customer;
import com.mendozabakery.bakeryappbackend.model.ProductCategory;
import com.mendozabakery.bakeryappbackend.service.IProductCategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product-categories")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class ProductCategoryController {

    private final IProductCategoryService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProductCategoryDTO>> findAll() throws Exception {

        List<ProductCategoryDTO> list = service.findAll()
                .stream()
                .map(e -> modelMapper.map(e, ProductCategoryDTO.class))
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> findById(@PathVariable Integer id) throws Exception {

        ProductCategory obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ProductCategoryDTO dto) throws Exception {

        ProductCategory obj = service.save(modelMapper.map(dto, ProductCategory.class));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdCategory())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> update(
            @Valid @RequestBody ProductCategoryDTO dto,
            @PathVariable Integer id) throws Exception {

        ProductCategory obj = service.update(
                modelMapper.map(dto, ProductCategory.class), id);

        return ResponseEntity.ok(
                modelMapper.map(obj, ProductCategoryDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<ProductCategory> findByHateoas(@PathVariable Integer id) throws Exception{
        ProductCategory obj = service.findById(id);
        EntityModel<ProductCategory> entityModel = EntityModel.of(obj);

        WebMvcLinkBuilder link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductCategoryController.class).findById(id));
        WebMvcLinkBuilder link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductCategoryController.class).findAll());
        WebMvcLinkBuilder link3 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).findAll());

        entityModel.add(link1.withRel("productcategory-self-info"));
        entityModel.add(link2.withRel("productcategory-all-info"));
        entityModel.add(link3.withRel("product-all-info"));

        return entityModel;
    }
}