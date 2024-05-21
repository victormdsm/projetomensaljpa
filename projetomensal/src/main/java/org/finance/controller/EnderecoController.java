package org.finance.controller;

import org.finance.model.entities.EnderecoEntity;
import org.finance.model.services.EnderecoService;

public class EnderecoController {

    private EnderecoService endereco;

    public EnderecoController() {
        this.endereco = new EnderecoService();
    }

    public EnderecoEntity updateEndereco(Object obj) {
        return endereco.update(obj);
    }

}
