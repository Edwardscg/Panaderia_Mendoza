package com.mendozabakery.bakeryappbackend.service.implementation;

import com.mendozabakery.bakeryappbackend.model.PurchaseDetail;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
import com.mendozabakery.bakeryappbackend.repository.IPurchaseDetailRepository;
import com.mendozabakery.bakeryappbackend.service.IPurchaseDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseDetailService extends GenericService<PurchaseDetail, Integer> implements IPurchaseDetailService {
    private final IPurchaseDetailRepository repo;

    @Override
    protected IGenericRepository<PurchaseDetail, Integer> getRepo(){return repo;}
}
