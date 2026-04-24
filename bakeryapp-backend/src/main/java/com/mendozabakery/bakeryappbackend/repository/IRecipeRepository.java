package com.mendozabakery.bakeryappbackend.repository;

import com.mendozabakery.bakeryappbackend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {
}