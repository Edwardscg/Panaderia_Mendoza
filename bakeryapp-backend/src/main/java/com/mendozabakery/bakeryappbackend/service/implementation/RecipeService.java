package com.mendozabakery.bakeryappbackend.service.implementation;

import com.mendozabakery.bakeryappbackend.service.IRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Recipe;
import com.mendozabakery.bakeryappbackend.repository.IRecipeRepository;

@Service
@RequiredArgsConstructor
public class RecipeService implements IRecipeService {

    private final IRecipeRepository repo;

    @Override
    public Recipe save(Recipe recipe) throws Exception {
        return repo.save(recipe);
    }

    @Override
    public Recipe update(Recipe recipe, Integer id) throws Exception {
        recipe.setIdRecipe(id);
        return repo.save(recipe);
    }

    @Override
    public List<Recipe> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Recipe findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Recipe());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}