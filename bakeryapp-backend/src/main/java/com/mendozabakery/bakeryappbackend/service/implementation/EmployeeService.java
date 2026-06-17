package com.mendozabakery.bakeryappbackend.service.implementation;

import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.repository.IEmployeeRepository;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
import com.mendozabakery.bakeryappbackend.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService extends GenericService<Employee, Integer> implements IEmployeeService {
    private final IEmployeeRepository repo;

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
}
