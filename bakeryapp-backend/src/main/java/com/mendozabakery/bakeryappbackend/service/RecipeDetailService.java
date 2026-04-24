package com.mendozabakery.bakeryappbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.model.RecipeDetail;
import com.mendozabakery.bakeryappbackend.repository.IRecipeDetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeDetailService implements IRecipeDetailService {

    private final IRecipeDetailRepository repo;

    @Override
    public RecipeDetail save(RecipeDetail recipeDetail) throws Exception {
        return repo.save(recipeDetail);
    }

    @Override
    public RecipeDetail update(RecipeDetail recipeDetail, Integer id) throws Exception {
        recipeDetail.setIdRecipeDetail(id);
        return repo.save(recipeDetail);
    }

    @Override
    public List<RecipeDetail> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public RecipeDetail findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new RecipeDetail());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
