package com.mendozabakery.bakeryappbackend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mendozabakery.bakeryappbackend.dto.CustomerDTO;
import com.mendozabakery.bakeryappbackend.dto.EmployeeDTO;
import com.mendozabakery.bakeryappbackend.dto.ProductDTO;
import com.mendozabakery.bakeryappbackend.model.Customer;
import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.model.Product;

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
    public ModelMapper productMapper() {
        ModelMapper mapper = new ModelMapper();

        // Entity -> DTO
        mapper.createTypeMap(Product.class, ProductDTO.class)
                .addMapping(Product::getName, ProductDTO::setName)
                .addMapping(Product::getDescription, ProductDTO::setDescription)
                .addMapping(Product::getSalePrice, ProductDTO::setSalePrice)
                .addMapping(Product::getProductionCost, ProductDTO::setProductionCost)
                .addMapping(Product::getType, ProductDTO::setType)
                .addMapping(Product::getUnitMeasure, ProductDTO::setUnitMeasure)
                .addMapping(Product::getStatus, ProductDTO::setStatus)
                .addMappings(m -> m.map(
                        src -> src.getCategory().getIdCategory(),
                        ProductDTO::setIdCategory
                ));

        // DTO -> Entity
        mapper.createTypeMap(ProductDTO.class, Product.class)
                .addMapping(ProductDTO::getName, Product::setName)
                .addMapping(ProductDTO::getDescription, Product::setDescription)
                .addMapping(ProductDTO::getSalePrice, Product::setSalePrice)
                .addMapping(ProductDTO::getProductionCost, Product::setProductionCost)
                .addMapping(ProductDTO::getType, Product::setType)
                .addMapping(ProductDTO::getUnitMeasure, Product::setUnitMeasure)
                .addMapping(ProductDTO::getStatus, Product::setStatus);

        return mapper;
    }

}
