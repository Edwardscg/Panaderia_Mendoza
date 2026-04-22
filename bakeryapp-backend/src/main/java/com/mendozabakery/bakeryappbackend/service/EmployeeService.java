package com.mendozabakery.bakeryappbackend.service;

<<<<<<< HEAD
import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.repository.IEmployeeRepository;
=======
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

<<<<<<< HEAD
@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{
    private final IEmployeeRepository repo;

    @Override
    public Employee save(Employee employee) throws Exception{
=======
import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.repository.IEmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository repo;

    @Override
    public Employee save(Employee employee) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return repo.save(employee);
    }

    @Override
<<<<<<< HEAD
    public Employee update(Employee employee, Integer id) throws Exception{
=======
    public Employee update(Employee employee, Integer id) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        employee.setIdEmployee(id);
        return repo.save(employee);
    }

    @Override
<<<<<<< HEAD
    public List<Employee> findAll() throws Exception{
=======
    public List<Employee> findAll() throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return repo.findAll();
    }

    @Override
<<<<<<< HEAD
    public Employee findById(Integer id) throws Exception{
=======
    public Employee findById(Integer id) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return repo.findById(id).orElse(new Employee());
    }

    @Override
<<<<<<< HEAD
    public void delete(Integer id) throws Exception{
        repo.deleteById(id);
    }
}
=======
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
