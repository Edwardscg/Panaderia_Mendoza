package com.mendozabakery.bakeryappbackend.service.implementation;

import com.mendozabakery.bakeryappbackend.model.SaleDetail;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
import com.mendozabakery.bakeryappbackend.repository.ISaleDetailRepository;
import com.mendozabakery.bakeryappbackend.service.ISaleDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleDetailService extends GenericService<SaleDetail, Integer> implements ISaleDetailService {
    private final ISaleDetailRepository repo;

    @Override
    protected IGenericRepository<SaleDetail, Integer> getRepo(){return repo;}
}
