package org.finance.model.services;

import org.finance.model.entities.UsuarioEntity;
import org.finance.model.repositories.UsuarioRepository;

import java.util.List;

public class UsuarioService implements ServiceInterface {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }


    @Override
    public UsuarioEntity create(Object obj) {
        return (UsuarioEntity) usuarioRepository.insertData(obj);
    }

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }


    @Override
    public UsuarioEntity findById(Long id) {
        return (UsuarioEntity) usuarioRepository.findById(id);
    }


    public Object login(String email, String senha) {
        return usuarioRepository.login(email, senha);
    }

    @Override
    public Object update(Object obj) {
        return usuarioRepository.update(obj);
    }

    @Override
    public void delete(Object obj) {
        usuarioRepository.deleteData(obj);
    }
}
