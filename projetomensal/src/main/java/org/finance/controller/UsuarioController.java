package org.finance.controller;

import org.finance.model.entities.UsuarioEntity;
import org.finance.model.services.UsuarioService;

import java.util.List;

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public UsuarioEntity creatUser(UsuarioEntity usuario) {
        return usuarioService.create(usuario);
    }

    public UsuarioEntity login(String email, String senha) {
        return (UsuarioEntity) usuarioService.login(email, senha);
    }

    public UsuarioEntity updateUser(UsuarioEntity user) {
        return (UsuarioEntity) usuarioService.update(user);
    }

    public UsuarioEntity findById(Long id) {
        return usuarioService.findById(id);
    }
}
