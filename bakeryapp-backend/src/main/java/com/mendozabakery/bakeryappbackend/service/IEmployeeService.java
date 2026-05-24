package com.mendozabakery.bakeryappbackend.service;

import com.mendozabakery.bakeryappbackend.model.Employee;

import java.util.List;

<<<<<<< HEAD
public interface IEmployeeService {

    Employee save(Employee employee) throws Exception;

    Employee update(Employee employee, Integer id) throws Exception;

    List<Employee> findAll() throws Exception;

    Employee findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
=======
public interface IEmployeeService extends  IGenericService<Employee, Integer>{
//    Employee save(Employee employee) throws Exception;
//    Employee update(Employee employee, Integer id) throws Exception;
//    List<Employee> findAll() throws Exception;
//    Employee findById(Integer id) throws Exception;
//    void delete(Integer id) throws Exception;
>>>>>>> 548ce5e59d8f02655bdaa7f4d5a5315cf75b3dd1
}

