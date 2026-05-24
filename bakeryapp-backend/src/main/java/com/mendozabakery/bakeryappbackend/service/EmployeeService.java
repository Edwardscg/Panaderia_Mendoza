package com.mendozabakery.bakeryappbackend.service;

<<<<<<< HEAD

=======
import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.repository.IEmployeeRepositoryI;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
>>>>>>> 548ce5e59d8f02655bdaa7f4d5a5315cf75b3dd1
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.repository.IEmployeeRepository;

@Service
@RequiredArgsConstructor
<<<<<<< HEAD
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
=======
public class EmployeeService extends GenericService<Employee, Integer> implements IEmployeeService{
    private final IEmployeeRepositoryI repo;

    @Override
    protected IGenericRepository<Employee , Integer> getRepo(){
        return repo;
    }

//    @Override
//    public Employee update(Employee employee, Integer id) throws Exception{
//        employee.setIdEmployee(id);
//        return repo.save(employee);
//    }
//
//    @Override
//    public List<Employee> findAll() throws Exception{
//        return repo.findAll();
//    }
//
//    @Override
//    public Employee findById(Integer id) throws Exception{
//        return repo.findById(id).orElse(new Employee());
//    }
//
//    @Override
//    public void delete(Integer id) throws Exception{
//        repo.deleteById(id);
//    }
>>>>>>> 548ce5e59d8f02655bdaa7f4d5a5315cf75b3dd1
}
