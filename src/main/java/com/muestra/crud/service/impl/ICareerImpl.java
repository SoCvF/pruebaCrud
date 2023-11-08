package com.muestra.crud.service.impl;

import com.muestra.crud.model.Career;
import com.muestra.crud.repository.ICareerRepository;
import com.muestra.crud.repository.IGenericRepository;
import com.muestra.crud.service.ICareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICareerImpl extends ICrudImpl<Career, Integer> implements ICareerService {
    @Autowired
    private ICareerRepository repo;
    @Override
    protected IGenericRepository<Career, Integer> getRepo() {
        return repo;
    }
}
