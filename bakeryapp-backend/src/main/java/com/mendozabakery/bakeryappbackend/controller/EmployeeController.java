package com.mendozabakery.bakeryappbackend.controller;

<<<<<<< HEAD
import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.service.IEmployeeService;
=======
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
=======
import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.service.IEmployeeService;

>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
<<<<<<< HEAD
    private final IEmployeeService service;

    @GetMapping
    public List<Employee> findAll() throws Exception{
=======

    private final IEmployeeService service;

    @GetMapping
    public List<Employee> findAll() throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return service.findAll();
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public Employee findById(@PathVariable("id") Integer id) throws Exception{
=======
    public Employee findById(@PathVariable Integer id) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return service.findById(id);
    }

    @PostMapping
<<<<<<< HEAD
    public Employee save(@RequestBody Employee employee) throws Exception{
=======
    public Employee save(@RequestBody Employee employee) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return service.save(employee);
    }

    @PutMapping("/{id}")
<<<<<<< HEAD
    public Employee update(@RequestBody Employee employee, @PathVariable("id") Integer id) throws Exception{
=======
    public Employee update(@RequestBody Employee employee, @PathVariable Integer id) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return service.update(employee, id);
    }

    @DeleteMapping("/{id}")
<<<<<<< HEAD
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
=======
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
