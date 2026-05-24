package com.mendozabakery.bakeryappbackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mendozabakery.bakeryappbackend.model.RecipeDetail;
import com.mendozabakery.bakeryappbackend.service.IRecipeDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/recipe-details")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RecipeDetailController {

    private final IRecipeDetailService service;

    @GetMapping
    public List<RecipeDetail> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RecipeDetail findById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public RecipeDetail save(@RequestBody RecipeDetail recipeDetail) throws Exception {
        return service.save(recipeDetail);
    }

    @PutMapping("/{id}")
    public RecipeDetail update(@RequestBody RecipeDetail recipeDetail, @PathVariable("id") Integer id) throws Exception {
        return service.update(recipeDetail, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
