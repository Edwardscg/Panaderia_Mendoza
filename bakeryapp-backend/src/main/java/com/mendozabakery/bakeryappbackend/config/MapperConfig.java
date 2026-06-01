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
                .addMapping(Customer::getNameCustomer, CustomerDTO::setNameCustomer)
                .addMapping(Customer::getStatus, CustomerDTO::setStatus);

        // ESCRITURA - POST, PUT
        mapper.createTypeMap(CustomerDTO.class, Customer.class)
                .addMapping(CustomerDTO::getNameCustomer, Customer::setNameCustomer)
                .addMapping(CustomerDTO::getStatus, Customer::setStatus);
        return mapper;
    }
}
