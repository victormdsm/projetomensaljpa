package org.finance.model.services;

import org.finance.model.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioServiceInterface {

    public UsuarioEntity adicionarUsuario(UsuarioEntity usuario);
    public List<UsuarioEntity> trazerTodosOsUsuarios();
    public Object findById(Long id);
    public Object login(String email, String senha);
    public Object updateUser(Object obj);
}
