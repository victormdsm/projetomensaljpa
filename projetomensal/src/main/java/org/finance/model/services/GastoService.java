package org.finance.model.services;

import org.finance.model.entities.GastoEntity;
import org.finance.model.repositories.GastoRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public class GastoService implements ServiceInterface{

    GastoRepository gastoRepository;

    public GastoService() {
        this.gastoRepository = new GastoRepository();
    }

    @Override
    public GastoEntity create(Object obj) {
        GastoEntity gasto = (GastoEntity) obj;
        if(gasto.getValor().compareTo(BigDecimal.ZERO) > 0 && !gasto.getDiaDoGasto().isAfter(LocalDate.now()) ) {
            return (GastoEntity) gastoRepository.insertData(obj);
        } else {
            System.out.println("Os dados não estao corretos impossivel criar um objeto verifique o valor e a data!");
        }
        return null;
    }

    @Override
    public List findAll() {
        return gastoRepository.findAll();
    }

    @Override
    public GastoEntity findById(Long id) {
        return (GastoEntity) gastoRepository.findById(id);
    }

    @Override
    public GastoEntity update(Object obj) {
        return (GastoEntity) gastoRepository.update(obj);
    }

    @Override
    public void delete(Object obj) {
        gastoRepository.deleteData(obj);
    }

//    1

    public BigDecimal total(Long id){
        return gastoRepository.total(id);
    }

    public BigDecimal totalCategory(Long id){
        return gastoRepository.totalCategory(id);
    }

    public List getGastos(Long id) {
        List<GastoEntity> gastos = gastoRepository.getGastos(id);
        return gastos;
    }
}
