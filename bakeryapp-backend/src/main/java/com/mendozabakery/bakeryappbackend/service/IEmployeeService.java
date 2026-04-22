package com.mendozabakery.bakeryappbackend.service;

import com.mendozabakery.bakeryappbackend.model.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee save(Employee employee) throws Exception;

    Employee update(Employee employee, Integer id) throws Exception;

    List<Employee> findAll() throws Exception;

    Employee findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}

