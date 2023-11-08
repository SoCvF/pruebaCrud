package com.muestra.crud.service.impl;

import com.muestra.crud.model.Campus;
import com.muestra.crud.repository.ICampusRepository;
import com.muestra.crud.repository.IGenericRepository;
import com.muestra.crud.service.ICampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICampusServiceImpl extends ICrudImpl<Campus,Integer> implements ICampusService {

    @Autowired
    private ICampusRepository repo;
    @Override
    protected IGenericRepository<Campus, Integer> getRepo() {
        return repo;
    }
}
