package org.finance.model.repositories;

import org.finance.model.entities.UsuarioEntity;

import java.util.List;

public class UsuarioRepository implements CrudBasic{

    private DAO<UsuarioEntity> dao;

    public UsuarioRepository() {
        this.dao = new DAO<UsuarioEntity>(UsuarioEntity.class);
    }

    @Override
    public Object insertData(Object obj) {
        if (obj instanceof UsuarioEntity) {
            UsuarioEntity usuario = (UsuarioEntity) obj;
            dao.insertTransaction(usuario);
            return usuario;
        } else {
            throw new IllegalArgumentException("Invalid object type. Expected UsuarioEntity.");
        }
    }

    @Override
    public void deleteData(Object obj) {

    }

    @Override
    public List<UsuarioEntity> findAll() {
        return dao.getAllData();
    }

    @Override
    public Object findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Object update(Object obj) {
        return null;
    }
}
