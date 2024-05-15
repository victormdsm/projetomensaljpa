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


}
