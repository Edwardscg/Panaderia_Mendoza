package com.mendozabakery.bakeryappbackend.config;

import com.mendozabakery.bakeryappbackend.dto.CustomerDTO;
import com.mendozabakery.bakeryappbackend.model.Customer;
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
}
