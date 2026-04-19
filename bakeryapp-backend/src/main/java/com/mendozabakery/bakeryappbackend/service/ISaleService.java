package com.mendozabakery.bakeryappbackend.service;

import com.mendozabakery.bakeryappbackend.model.Sale;

import java.util.List;

public interface ISaleService {
    Sale save(Sale sale) throws Exception;

    Sale update(Sale sale, Integer id) throws Exception;

    List<Sale> findAll() throws Exception;

    Sale findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
