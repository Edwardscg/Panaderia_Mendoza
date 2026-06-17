package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.dto.RecipeDetailDTO;
import com.mendozabakery.bakeryappbackend.model.RecipeDetail;
import com.mendozabakery.bakeryappbackend.service.IRecipeDetailService;
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
@RequestMapping("/recipe-details")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class RecipeDetailController {

    private final IRecipeDetailService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RecipeDetailDTO>> findAll() throws Exception {

        List<RecipeDetailDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, RecipeDetailDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDetail> findById(@PathVariable Integer id) throws Exception {

        RecipeDetail obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody RecipeDetailDTO dto) throws Exception {

        RecipeDetail obj = service.save(modelMapper.map(dto, RecipeDetail.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRecipeDetail()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDetailDTO> update(@RequestBody RecipeDetailDTO dto, @PathVariable Integer id) throws Exception {

        RecipeDetail obj = service.update(modelMapper.map(dto, RecipeDetail.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, RecipeDetailDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}