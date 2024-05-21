package org.finance.controller;

import org.finance.model.entities.TiposDeDespesaEntity;
import org.finance.model.services.TiposDeDespesaService;

import java.util.List;

public class TiposDeDespesaController {

    private TiposDeDespesaService tiposDeDespesa;

    public TiposDeDespesaController() {
        this.tiposDeDespesa = new TiposDeDespesaService();
    }

    public TiposDeDespesaEntity creatTipo(TiposDeDespesaEntity tiposDeDespesaObj) {
        return tiposDeDespesa.create(tiposDeDespesaObj);
    }

    public TiposDeDespesaEntity findById(Long id) {
        return tiposDeDespesa.findById(id);
    }

    public List findAll() {
        return tiposDeDespesa.findAll();
    }

    public void delete(Object obj) {
        tiposDeDespesa.delete(obj);
    }

    public List getAllTipos(Long id) {
       return tiposDeDespesa.getAllTipos(id);
    }
}
