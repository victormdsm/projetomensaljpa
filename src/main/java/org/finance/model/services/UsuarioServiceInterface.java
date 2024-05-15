package org.finance.model.services;

import org.finance.model.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioServiceInterface {

    public UsuarioEntity adicionarUsuario(UsuarioEntity usuario);
    public List<UsuarioEntity> trazerTodosOsUsuarios();
}
