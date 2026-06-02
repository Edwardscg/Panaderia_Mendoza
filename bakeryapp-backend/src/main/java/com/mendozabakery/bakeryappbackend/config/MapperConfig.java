package com.mendozabakery.bakeryappbackend.config;

import com.mendozabakery.bakeryappbackend.dto.CustomerDTO;
import com.mendozabakery.bakeryappbackend.dto.EmployeeDTO;
import com.mendozabakery.bakeryappbackend.model.Customer;
import com.mendozabakery.bakeryappbackend.model.Employee;
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
                .addMapping(Customer::getNameCustomer, CustomerDTO::setNombreCliente)
                .addMapping(Customer::getDni, CustomerDTO::setDniCliente)
                .addMapping(Customer::getPhone, CustomerDTO::setTelefonoCliente)
                .addMapping(Customer::getEmail, CustomerDTO::setCorreoCliente)
                .addMapping(Customer::getStatus, CustomerDTO::setEstadoCliente);

        // ESCRITURA - POST, PUT
        mapper.createTypeMap(CustomerDTO.class, Customer.class)
                .addMapping(CustomerDTO::getNombreCliente, Customer::setNameCustomer)
                .addMapping(CustomerDTO::getDniCliente, Customer::setDni)
                .addMapping(CustomerDTO::getTelefonoCliente, Customer::setPhone)
                .addMapping(CustomerDTO::getCorreoCliente, Customer::setEmail)
                .addMapping(CustomerDTO::getEstadoCliente, Customer::setStatus);

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

}
