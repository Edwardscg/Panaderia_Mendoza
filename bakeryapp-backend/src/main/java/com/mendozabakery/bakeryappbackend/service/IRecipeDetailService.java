package com.mendozabakery.bakeryappbackend.service;

import java.util.List;
import com.mendozabakery.bakeryappbackend.model.RecipeDetail;

public interface IRecipeDetailService {

    RecipeDetail save(RecipeDetail recipeDetail) throws Exception;

    RecipeDetail update(RecipeDetail recipeDetail, Integer id) throws Exception;

    List<RecipeDetail> findAll() throws Exception;

    RecipeDetail findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
