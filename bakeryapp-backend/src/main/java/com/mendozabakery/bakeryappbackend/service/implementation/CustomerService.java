package com.mendozabakery.bakeryappbackend.service.implementation;

import com.mendozabakery.bakeryappbackend.model.Customer;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
import com.mendozabakery.bakeryappbackend.service.ICustomerService;
import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.repository.ICustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService extends GenericService<Customer, Integer> implements ICustomerService {

    private final ICustomerRepository repo;

    @Override
    protected IGenericRepository<Customer, Integer> getRepo() {
        return repo;
    }

//    @Override
//    public Customer save(Customer customer) throws Exception {
//        return repo.save(customer);
//    }
//
//    @Override
//    public Customer update(Customer customer, Integer id) throws Exception {
//        customer.setIdCustomer(id);
//        return repo.save(customer);
//    }
//
//    @Override
//    public List<Customer> findAll() throws Exception {
//        return repo.findAll();
//    }
//
//    @Override
//    public Customer findById(Integer id) throws Exception {
//        return repo.findById(id).orElse(new Customer());
//    }
//
//    @Override
//    public void delete(Integer id) throws Exception {
//        repo.deleteById(id);
//    }
}