package com.mendozabakery.bakeryappbackend.service;

import java.util.List;
import com.mendozabakery.bakeryappbackend.model.Recipe;

public interface IRecipeService {

    Recipe save(Recipe recipe) throws Exception;

    Recipe update(Recipe recipe, Integer id) throws Exception;

    List<Recipe> findAll() throws Exception;

    Recipe findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}