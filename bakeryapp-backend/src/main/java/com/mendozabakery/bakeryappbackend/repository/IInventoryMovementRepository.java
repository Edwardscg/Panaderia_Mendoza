package com.mendozabakery.bakeryappbackend.repository;

import com.mendozabakery.bakeryappbackend.model.InventoryMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventoryMovementRepository extends JpaRepository<InventoryMovement, Integer> {

}
