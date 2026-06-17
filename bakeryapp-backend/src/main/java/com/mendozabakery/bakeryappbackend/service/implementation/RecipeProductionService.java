package com.mendozabakery.bakeryappbackend.service.implementation;

import com.mendozabakery.bakeryappbackend.model.RecipeProduction;
import com.mendozabakery.bakeryappbackend.repository.IRecipeProductionRepository;
import com.mendozabakery.bakeryappbackend.service.IRecipeProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeProductionService implements IRecipeProductionService {

    private final IRecipeProductionRepository repo;

    @Override
    public RecipeProduction save(RecipeProduction production) throws Exception {
        return repo.save(production);
    }

    @Override
    public RecipeProduction update(RecipeProduction production, Integer id) throws Exception {
        production.setIdProduction(id);
        return repo.save(production);
    }

    @Override
    public List<RecipeProduction> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public RecipeProduction findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new RecipeProduction());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}