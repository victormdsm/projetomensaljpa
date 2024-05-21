package org.finance.model.services;

import org.finance.model.entities.UsuarioEntity;

import java.util.List;

public interface ServiceInterface<E> {

    public E create(E obj);
    public List<E> findAll();
    public E findById(Long id);
    public E update(E obj);
    public void delete(E obj);
}
