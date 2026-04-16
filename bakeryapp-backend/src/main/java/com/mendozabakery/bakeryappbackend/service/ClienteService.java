package com.mendozabakery.bakeryappbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mendozabakery.bakeryappbackend.model.Cliente;
import com.mendozabakery.bakeryappbackend.repository.IClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private final IClienteRepository repo = null;

    @Override
    public Cliente save(Cliente cliente) throws Exception {
        return repo.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente, Integer id) throws Exception {
        Cliente existing = repo.findById(id).orElseThrow(() -> new Exception("Cliente no encontrado con id: " + id));

        // Actualizar campos
        existing.setNomCliente(cliente.getNomCliente());
        existing.setDni(cliente.getDni());
        existing.setTelefono(cliente.getTelefono());

        return repo.save(existing);
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Cliente findById(Integer id) throws Exception {
        return repo.findById(id)
                .orElseThrow(() -> new Exception("Cliente no encontrado con id: " + id));
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}