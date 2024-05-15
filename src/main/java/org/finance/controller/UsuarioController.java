package org.finance.controller;

import org.finance.model.entities.UsuarioEntity;
import org.finance.model.services.UsuarioService;

import java.util.List;

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public UsuarioEntity adicionarUsuario(UsuarioEntity usuario) {
        return usuarioService.adicionarUsuario(usuario);
    }

    public List<UsuarioEntity> resgatarUsuarios() {
        return usuarioService.trazerTodosOsUsuarios();
    }
}
