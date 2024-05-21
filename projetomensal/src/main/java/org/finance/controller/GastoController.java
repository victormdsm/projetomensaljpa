package org.finance.controller;

import org.finance.model.entities.GastoEntity;
import org.finance.model.services.GastoService;
import org.hibernate.type.descriptor.java.ObjectJavaType;

import java.math.BigDecimal;
import java.util.List;

public class GastoController {

    private GastoService gastoService;

    public GastoController() {
        this.gastoService = new GastoService();
    }

    public BigDecimal valorTotal(Long id) {
        return gastoService.total(id);
    }

    public BigDecimal valorTotalCategoria(Long id) {
        return gastoService.totalCategory(id);
    }

    public GastoEntity creat(GastoEntity gasto) {
        return gastoService.create(gasto);
    }

    public GastoEntity update(Object obj) {
        return gastoService.update(obj);
    }

    public GastoEntity findById(Long id) {
        return gastoService.findById(id);
    }

    public List findAll() {
        return gastoService.findAll();
    }

    public void delete(Object obj) {
        gastoService.delete(obj);
    }

    public List getGastos(Long id) {

        return gastoService.getGastos(id);
    }
}
