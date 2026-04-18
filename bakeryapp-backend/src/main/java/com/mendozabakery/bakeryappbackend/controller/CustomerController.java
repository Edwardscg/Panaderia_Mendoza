package com.mendozabakery.bakeryappbackend.controller;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Customer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import com.mendozabakery.bakeryappbackend.service.ICustomerService;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService service;

    @GetMapping
    public List<Customer> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) throws Exception {
        return service.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable("id") Integer id) throws Exception {
        return service.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}