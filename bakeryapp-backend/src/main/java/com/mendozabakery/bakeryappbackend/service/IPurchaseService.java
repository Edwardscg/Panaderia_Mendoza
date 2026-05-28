package com.mendozabakery.bakeryappbackend.service;

import com.mendozabakery.bakeryappbackend.model.Purchase;

import java.util.List;

public interface IPurchaseService {
    Purchase save(Purchase purchase) throws Exception;
    Purchase update(Purchase purchase, Integer id) throws Exception;
    List<Purchase> findAll() throws Exception;
    Purchase findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
