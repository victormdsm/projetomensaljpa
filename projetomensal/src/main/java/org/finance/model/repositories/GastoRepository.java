package org.finance.model.repositories;

import org.finance.model.entities.GastoEntity;
import org.finance.model.entities.TiposDeDespesaEntity;

import java.math.BigDecimal;
import java.util.List;

public class GastoRepository implements CrudBasic {

    private DAO<GastoEntity> dao;

    public GastoRepository() {
        this.dao = new DAO<>(GastoEntity.class);
    }

    @Override
    public Object insertData(Object obj) {
        GastoEntity gastoEntity = (GastoEntity) obj;
        dao.insertData(gastoEntity);
        return gastoEntity;
    }

    @Override
    public void deleteData(Object obj) {
        GastoEntity gastoEntity = (GastoEntity) obj;
        dao.removeData(gastoEntity);
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
        GastoEntity gastoEntity = (GastoEntity) obj;
        dao.updateData(gastoEntity);
        return gastoEntity;
    }

//    public List findByCategory(Long id) {
//        List<GastoEntity> gastosCategoria = dao.getTotalCatego(id);
//        return gastosCategoria;
//    }

    public List getGastos(Long id) {
        return dao.getGastos(id);
    }

    public BigDecimal total(Long id) {
        return dao.getValueTotal(id);
    }

    public BigDecimal totalCategory(Long id) {
        return dao.getTotalCategory(id);
    }
}
