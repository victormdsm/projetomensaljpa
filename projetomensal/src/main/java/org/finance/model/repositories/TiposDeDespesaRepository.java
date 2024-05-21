package org.finance.model.repositories;

import org.finance.model.entities.EnderecoEntity;
import org.finance.model.entities.TiposDeDespesaEntity;

import java.util.List;

public class TiposDeDespesaRepository implements CrudBasic{

    private DAO<TiposDeDespesaEntity> dao;

    public TiposDeDespesaRepository() {
        this.dao = new DAO<>(TiposDeDespesaEntity.class);
    }

    @Override
    public Object insertData(Object obj) {
        TiposDeDespesaEntity tiposDeDespesa = (TiposDeDespesaEntity) obj;
        dao.insertData(tiposDeDespesa);
        return tiposDeDespesa;
    }

    @Override
    public void deleteData(Object obj) {
        TiposDeDespesaEntity tiposDeDespesa = (TiposDeDespesaEntity) obj;
        dao.removeData(tiposDeDespesa);
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
        TiposDeDespesaEntity tiposDeDespesa = (TiposDeDespesaEntity) obj;
        dao.updateData(tiposDeDespesa);
        return tiposDeDespesa;
    }

    public List getAllTipos(Long id) {
        return dao.getAllTipos(id);
    }
}
