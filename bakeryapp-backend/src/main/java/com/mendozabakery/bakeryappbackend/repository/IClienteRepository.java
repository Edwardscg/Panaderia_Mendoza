package com.mendozabakery.bakeryappbackend.repository;

import com.mendozabakery.bakeryappbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Customer, Integer> {
}
