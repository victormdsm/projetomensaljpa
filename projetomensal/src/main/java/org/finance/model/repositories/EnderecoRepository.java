package org.finance.model.repositories;

import org.finance.model.entities.EnderecoEntity;

import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository implements CrudBasic{

    private DAO<EnderecoEntity> dao;

    public EnderecoRepository() {
        this.dao = new DAO<>(EnderecoEntity.class);
    }

    @Override
    public Object insertData(Object obj) {
        EnderecoEntity endereco = (EnderecoEntity) obj;
        dao.insertData(endereco);
        return endereco;
    }

    @Override
    public void deleteData(Object obj) {
        EnderecoEntity endereco = (EnderecoEntity) obj;
        dao.removeData(endereco);
    }

    @Override
    public List findAll() {
        return dao.findAllData();
    }

    @Override
    public Object findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Object update(Object obj) {
        EnderecoEntity endereco = (EnderecoEntity) obj;
        dao.updateData(endereco);
        return endereco;
    }
}
