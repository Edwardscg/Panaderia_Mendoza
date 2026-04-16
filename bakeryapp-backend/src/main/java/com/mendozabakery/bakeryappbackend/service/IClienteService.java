package com.mendozabakery.bakeryappbackend.service;

import java.util.List;
import com.mendozabakery.bakeryappbackend.model.Cliente;

public interface IClienteService {

    Cliente save(Cliente cliente) throws Exception;

    Cliente update(Cliente cliente, Integer id) throws Exception;

    List<Cliente> findAll() throws Exception;

    Cliente findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}