package org.finance.model.repositories;

import org.finance.model.entities.UsuarioEntity;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class UsuarioRepository implements CrudBasic{

    private DAO<UsuarioEntity> dao;

    public UsuarioRepository() {
        this.dao = new DAO<UsuarioEntity>(UsuarioEntity.class);
    }

    @Override
    public Object insertData(Object obj) {
        UsuarioEntity createUser = (UsuarioEntity)  obj;
        String hashedPassword = BCrypt.hashpw(createUser.getSenha(), BCrypt.gensalt());
        createUser.setSenha(hashedPassword);
        dao.insertData(createUser);
        return createUser;
    }

    @Override
    public void deleteData(Object obj) {
        UsuarioEntity usuario = (UsuarioEntity) obj;
        dao.removeData(usuario);
    }

    @Override
    public List<UsuarioEntity> findAll() {
        return dao.findAllData();
    }

    @Override
    public Object findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Object update(Object obj) {
        UsuarioEntity usuario = (UsuarioEntity) obj;
        DAO<UsuarioEntity> usuarioAtualizado = dao.update(usuario);
        return usuario;
    }

    public Object login(String email, String senha) {
        return dao.login(email, senha);
    }
}
