package org.finance.model.services;

import org.finance.model.entities.UsuarioEntity;
import org.finance.model.repositories.UsuarioRepository;

import java.util.List;

public class UsuarioService implements UsuarioServiceInterface {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    @Override
    public UsuarioEntity adicionarUsuario(UsuarioEntity usuario) {
        return (UsuarioEntity) usuarioRepository.insertData(usuario);
    }

    @Override
    public List<UsuarioEntity> trazerTodosOsUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity findById(Long id) {
        return (UsuarioEntity) usuarioRepository.findById(id);
    }

    @Override
    public Object login(String email, String senha) {
        return usuarioRepository.login(email, senha);
    }

    @Override
    public Object updateUser(Object obj) {
        return usuarioRepository.update(obj);
    }

    public void removerUsuario(Object obj) {
        usuarioRepository.deleteData(obj);
    }
}
