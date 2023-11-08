package com.muestra.crud.service.impl;

import com.muestra.crud.model.Students;
import com.muestra.crud.repository.IGenericRepository;
import com.muestra.crud.repository.IStudentsRepository;
import com.muestra.crud.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IStudentsImpl extends ICrudImpl<Students, Integer> implements IStudentsService {
    @Autowired
    private IStudentsRepository repo;
    @Override
    protected IGenericRepository<Students, Integer> getRepo() {
        return repo;
    }
}
