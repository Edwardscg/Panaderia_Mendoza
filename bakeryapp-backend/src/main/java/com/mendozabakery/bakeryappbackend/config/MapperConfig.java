package com.mendozabakery.bakeryappbackend.config;

import com.mendozabakery.bakeryappbackend.dto.CustomerDTO;
import com.mendozabakery.bakeryappbackend.dto.EmployeeDTO;
import com.mendozabakery.bakeryappbackend.dto.SupplierDTO;
import com.mendozabakery.bakeryappbackend.model.Customer;
import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.model.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }

    @Bean
    public ModelMapper customerMapper(){
        ModelMapper mapper = new ModelMapper();
        // LECTURA - GET
        mapper.createTypeMap(Customer.class, CustomerDTO.class)
                .addMapping(Customer::getNameCustomer, CustomerDTO::setNameCustomer)
                .addMapping(Customer::getDni, CustomerDTO::setDni)
                .addMapping(Customer::getPhone, CustomerDTO::setPhone)
                .addMapping(Customer::getEmail, CustomerDTO::setEmail)
                .addMapping(Customer::getStatus, CustomerDTO::setStatus);

        // ESCRITURA - POST, PUT
        mapper.createTypeMap(CustomerDTO.class, Customer.class)
                .addMapping(CustomerDTO::getNameCustomer, Customer::setNameCustomer)
                .addMapping(CustomerDTO::getDni, Customer::setDni)
                .addMapping(CustomerDTO::getPhone, Customer::setPhone)
                .addMapping(CustomerDTO::getEmail, Customer::setEmail)
                .addMapping(CustomerDTO::getStatus, Customer::setStatus);

        return mapper;
    }
    @Bean
    public ModelMapper employeeMapper(){
        ModelMapper mapper = new ModelMapper();

        // Employee mappings
        mapper.createTypeMap(Employee.class, EmployeeDTO.class)
                .addMapping(Employee::getFirstName, EmployeeDTO::setFirstName)
                .addMapping(Employee::getLastName, EmployeeDTO::setLastName)
                .addMapping(Employee::getDni, EmployeeDTO::setDni)
                .addMapping(Employee::getPhone, EmployeeDTO::setPhone)
                .addMapping(Employee::getEmail, EmployeeDTO::setEmail)
                .addMapping(Employee::getPosition, EmployeeDTO::setPosition)
                .addMapping(Employee::getStatus, EmployeeDTO::setStatus);

        mapper.createTypeMap(EmployeeDTO.class, Employee.class)
                .addMapping(EmployeeDTO::getFirstName, Employee::setFirstName)
                .addMapping(EmployeeDTO::getLastName, Employee::setLastName)
                .addMapping(EmployeeDTO::getDni, Employee::setDni)
                .addMapping(EmployeeDTO::getPhone, Employee::setPhone)
                .addMapping(EmployeeDTO::getEmail, Employee::setEmail)
                .addMapping(EmployeeDTO::getPosition, Employee::setPosition)
                .addMapping(EmployeeDTO::getStatus, Employee::setStatus);

        return mapper;
    }
    @Bean
    public ModelMapper supplierMapper(){

        ModelMapper mapper = new ModelMapper();

        // LECTURA - GET
        mapper.createTypeMap(Supplier.class, SupplierDTO.class)
                .addMapping(Supplier::getBusinessName, SupplierDTO::setBusinessName)
                .addMapping(Supplier::getRuc, SupplierDTO::setRuc)
                .addMapping(Supplier::getPhone, SupplierDTO::setPhone)
                .addMapping(Supplier::getEmail, SupplierDTO::setEmail)
                .addMapping(Supplier::getAddress, SupplierDTO::setAddress)
                .addMapping(Supplier::isStatus, SupplierDTO::setStatus);


        // ESCRITURA - POST, PUT
        mapper.createTypeMap(SupplierDTO.class, Supplier.class)
                .addMapping(SupplierDTO::getBusinessName, Supplier::setBusinessName)
                .addMapping(SupplierDTO::getRuc, Supplier::setRuc)
                .addMapping(SupplierDTO::getPhone, Supplier::setPhone)
                .addMapping(SupplierDTO::getEmail, Supplier::setEmail)
                .addMapping(SupplierDTO::getAddress, Supplier::setAddress)
                .addMapping(SupplierDTO::getStatus, Supplier::setStatus);

        return mapper;
    }

}
