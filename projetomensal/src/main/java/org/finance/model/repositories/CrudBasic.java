package org.finance.model.repositories;

import java.util.List;

public interface CrudBasic<E> {

    public E insertData(E obj);
    public void deleteData(E obj);
    public List<E> findAll();
    public E findById(Long id);
    public E update(Object obj);

}
