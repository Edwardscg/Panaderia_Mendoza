package com.mendozabakery.bakeryappbackend.repository;

import com.mendozabakery.bakeryappbackend.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale, Integer> {
}
