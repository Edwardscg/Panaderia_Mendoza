package com.mendozabakery.bakeryappbackend.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.repository.IEmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository repo;

    @Override
    public Employee save(Employee employee) throws Exception {
        return repo.save(employee);
    }

    @Override
    public Employee update(Employee employee, Integer id) throws Exception{

        employee.setIdEmployee(id);
        return repo.save(employee);
    }

    @Override
    public List<Employee> findAll() throws Exception {
        return repo.findAll();
    }

    @Override

    public Employee findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Employee());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
