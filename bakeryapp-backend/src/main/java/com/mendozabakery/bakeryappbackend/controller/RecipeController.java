package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.dto.RecipeDTO;
import com.mendozabakery.bakeryappbackend.model.Recipe;
import com.mendozabakery.bakeryappbackend.service.IRecipeService;
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
@RequestMapping("/recipes")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class RecipeController {

    private final IRecipeService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> findAll() throws Exception {

        List<RecipeDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, RecipeDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> findById(@PathVariable Integer id) throws Exception {

        Recipe obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody RecipeDTO dto) throws Exception {

        Recipe obj = service.save(modelMapper.map(dto, Recipe.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRecipe()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> update(@RequestBody RecipeDTO dto, @PathVariable Integer id) throws Exception {

        Recipe obj = service.update(modelMapper.map(dto, Recipe.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, RecipeDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}