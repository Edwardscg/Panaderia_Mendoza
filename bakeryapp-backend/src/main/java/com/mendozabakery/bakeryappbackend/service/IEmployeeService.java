package com.mendozabakery.bakeryappbackend.service;

<<<<<<< HEAD
import com.mendozabakery.bakeryappbackend.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee save(Employee employee) throws Exception;
    Employee update(Employee employee, Integer id) throws Exception;
    List<Employee> findAll() throws Exception;
    Employee findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
=======
import java.util.List;
import com.mendozabakery.bakeryappbackend.model.Employee;

public interface IEmployeeService {

    Employee save(Employee employee) throws Exception;

    Employee update(Employee employee, Integer id) throws Exception;

    List<Employee> findAll() throws Exception;

    Employee findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
