package com.mendozabakery.bakeryappbackend.repository;

import com.mendozabakery.bakeryappbackend.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {
}
