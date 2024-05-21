package org.finance.model.services;

import org.finance.model.entities.EnderecoEntity;
import org.finance.model.entities.TiposDeDespesaEntity;
import org.finance.model.repositories.EnderecoRepository;
import org.finance.model.repositories.TiposDeDespesaRepository;

import java.util.List;

public class TiposDeDespesaService implements ServiceInterface{

    TiposDeDespesaRepository tiposDeDespesa;

    public TiposDeDespesaService() {
        this.tiposDeDespesa = new TiposDeDespesaRepository();
    }

    @Override
    public TiposDeDespesaEntity create(Object obj) {
        return (TiposDeDespesaEntity) tiposDeDespesa.insertData(obj);
    }

    @Override
    public List findAll() {
        return tiposDeDespesa.findAll();
    }

    @Override
    public TiposDeDespesaEntity findById(Long id) {
        return(TiposDeDespesaEntity) tiposDeDespesa.findById(id);
    }

    @Override
    public TiposDeDespesaEntity update(Object obj) {
        return (TiposDeDespesaEntity) tiposDeDespesa.update(obj);
    }

    @Override
    public void delete(Object obj) {
        tiposDeDespesa.deleteData(obj);
    }

    public List getAllTipos(Long id) {
        return tiposDeDespesa.getAllTipos(id);
    }
}
