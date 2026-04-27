package com.mendozabakery.bakeryappbackend.repository;

import com.mendozabakery.bakeryappbackend.model.RecipeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeDetailRepository extends JpaRepository<RecipeDetail, Integer> {

}
