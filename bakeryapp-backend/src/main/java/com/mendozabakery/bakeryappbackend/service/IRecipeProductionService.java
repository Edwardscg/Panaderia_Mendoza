package com.mendozabakery.bakeryappbackend.service;

import com.mendozabakery.bakeryappbackend.model.RecipeProduction;

import java.util.List;

public interface IRecipeProductionService {

    RecipeProduction save(RecipeProduction production) throws Exception;

    RecipeProduction update(RecipeProduction production, Integer id) throws Exception;

    List<RecipeProduction> findAll() throws Exception;

    RecipeProduction findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}