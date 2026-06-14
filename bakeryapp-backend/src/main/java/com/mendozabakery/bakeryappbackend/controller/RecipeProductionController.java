package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.dto.RecipeProductionDTO;
import com.mendozabakery.bakeryappbackend.model.RecipeProduction;
import com.mendozabakery.bakeryappbackend.service.IRecipeProductionService;
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
@RequestMapping("/recipe-productions")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class RecipeProductionController {

    private final IRecipeProductionService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RecipeProductionDTO>> findAll() throws Exception {

        List<RecipeProductionDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, RecipeProductionDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeProduction> findById(@PathVariable Integer id) throws Exception {

        RecipeProduction obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody RecipeProductionDTO dto) throws Exception {

        RecipeProduction obj = service.save(modelMapper.map(dto, RecipeProduction.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProduction()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeProductionDTO> update(@RequestBody RecipeProductionDTO dto, @PathVariable Integer id) throws Exception {

        RecipeProduction obj = service.update(modelMapper.map(dto, RecipeProduction.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, RecipeProductionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}