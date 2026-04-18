package com.mendozabakery.bakeryappbackend.service;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Customer;
import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.repository.IClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final IClienteRepository repo = null;

    @Override
    public Customer save(Customer customer) throws Exception {
        return repo.save(customer);
    }

    @Override
    public Customer update(Customer customer, Integer id) throws Exception {
        customer.setIdCustomer(id);
        return repo.save(customer);
    }

    @Override
    public List<Customer> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Customer findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Customer());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}