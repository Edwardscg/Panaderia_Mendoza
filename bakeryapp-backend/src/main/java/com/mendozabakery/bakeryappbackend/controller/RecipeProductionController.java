package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.model.RecipeProduction;
import com.mendozabakery.bakeryappbackend.service.IRecipeProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productions")
@RequiredArgsConstructor
public class RecipeProductionController {

    private final IRecipeProductionService service;

    @GetMapping
    public List<RecipeProduction> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RecipeProduction findById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public RecipeProduction save(@RequestBody RecipeProduction production) throws Exception {
        return service.save(production);
    }

    @PutMapping("/{id}")
    public RecipeProduction update(@RequestBody RecipeProduction production, @PathVariable("id") Integer id) throws Exception {
        return service.update(production, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}