package com.muestra.crud.service.impl;

import com.muestra.crud.repository.IGenericRepository;
import com.muestra.crud.service.ICrud;

import java.util.List;

public abstract class ICrudImpl<T, ID> implements ICrud <T, ID>{

    protected abstract IGenericRepository<T, ID> getRepo();
    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception {
            getRepo().deleteById(id);
    }
}
