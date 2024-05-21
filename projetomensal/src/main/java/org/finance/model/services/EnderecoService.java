package org.finance.model.services;

import org.finance.model.entities.EnderecoEntity;
import org.finance.model.repositories.EnderecoRepository;

import java.util.List;

public class EnderecoService implements ServiceInterface {

    EnderecoRepository enderecoRepository;

    public EnderecoService() {
        this.enderecoRepository = new EnderecoRepository();
    }

    @Override
    public EnderecoEntity create(Object obj) {
        return (EnderecoEntity) enderecoRepository.insertData(obj);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public EnderecoEntity update(Object obj) {
        return (EnderecoEntity) enderecoRepository.update(obj);
    }

    @Override
    public void delete(Object obj) {
    }
}
