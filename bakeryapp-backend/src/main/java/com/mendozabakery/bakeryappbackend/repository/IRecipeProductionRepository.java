package com.mendozabakery.bakeryappbackend.repository;

import com.mendozabakery.bakeryappbackend.model.RecipeProduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeProductionRepository extends JpaRepository<RecipeProduction, Integer> {
}