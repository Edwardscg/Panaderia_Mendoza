package com.mendozabakery.bakeryappbackend.controller;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Recipe;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.mendozabakery.bakeryappbackend.service.IRecipeService;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final IRecipeService service;

    @GetMapping
    public List<Recipe> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Recipe findById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public Recipe save(@RequestBody Recipe recipe) throws Exception {
        return service.save(recipe);
    }

    @PutMapping("/{id}")
    public Recipe update(@RequestBody Recipe recipe, @PathVariable("id") Integer id) throws Exception {
        return service.update(recipe, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}