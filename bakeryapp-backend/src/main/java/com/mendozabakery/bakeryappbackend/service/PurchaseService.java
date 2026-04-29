package com.mendozabakery.bakeryappbackend.service;

import com.mendozabakery.bakeryappbackend.model.Purchase;
import com.mendozabakery.bakeryappbackend.repository.IPurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService implements IPurchaseService{
    private final IPurchaseRepository repo;

    @Override
    public Purchase save(Purchase purchase) throws Exception {
        return repo.save(purchase);
    }

    @Override
    public Purchase update(Purchase purchase, Integer id) throws Exception {
        purchase.setIdPurchase(id);
        return repo.save(purchase);
    }

    @Override
    public List<Purchase> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Purchase findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Purchase());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
