package org.finance;


import org.finance.controller.UsuarioController;
import org.finance.model.entities.EnderecoEntity;
import org.finance.model.entities.UsuarioEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        UsuarioController usuarioController = new UsuarioController();


        EnderecoEntity endereco1 = new EnderecoEntity("Av. Paulista", "1578", "01310-200", "São Paulo", "SP", "Brasil", "Apt 101");
        EnderecoEntity endereco2 = new EnderecoEntity("Rua das Flores", "300", "01001-000", "Curitiba", "PR", "Brasil", "Bloco B, Casa 4");
        EnderecoEntity endereco3 = new EnderecoEntity("Av. Atlântica", "456", "22010-000", "Rio de Janeiro", "RJ", "Brasil", "Cobertura");

        UsuarioEntity usuario1 = new UsuarioEntity("João Silva", "123.456.789-00", LocalDate.of(1990, 5, 15), "joao.silva@example.com", "joaosilva", "senha123", endereco1);
        UsuarioEntity usuario2 = new UsuarioEntity("Maria Oliveira", "987.654.321-00", LocalDate.of(1985, 8, 23), "maria.oliveira@example.com", "mariaoliveira", "senha456", endereco2);
        UsuarioEntity usuario3 = new UsuarioEntity("Carlos Pereira", "456.123.789-00", LocalDate.of(2000, 11, 30), "carlos.pereira@example.com", "carlospereira", "senha789", endereco3);

        System.out.println("Usuario adicionado: " + usuarioController.creatUser(usuario1).toString());
        System.out.println("Usuario adicionado: " + usuarioController.creatUser(usuario2).toString());
        System.out.println("Usuario adicionado: " + usuarioController.creatUser(usuario3).toString());

//        for (UsuarioEntity users: usuarioController.resgatarUsuarios()
//                 ) {
//            System.out.println("Usuarios do sistema: ");
//            System.out.println(users.toString());
//            }
//
//        System.out.println("Buscando por id");
//        System.out.println(usuarioController.findById(2L));
//
//        System.out.println("Fazendo login");
//
//        UsuarioEntity usuario = usuarioController.login("joao.silva@example.com", "senha123");
//
//        if(usuario == null) {
//            System.out.println("Deu ruim!");
//        } else {
//            System.out.println(usuario.toString());
//            System.out.println("Endereco do login");
//            System.out.println(usuario.getEndereco().toString());
//        }
//
//        //System.out.println("Removendo usuario");
//        //UsuarioEntity userRemove = usuarioController.findById(1L);
//        //usuarioController.removerUsuario(userRemove);
//
//        UsuarioEntity userUpdate = usuarioController.findById(2L);
//        userUpdate.setNome("Maria Oliveira");
//        userUpdate = usuarioController.updateUser(userUpdate);
//        System.out.println(userUpdate.toString());
//        System.out.println(userUpdate.getEndereco().toString());
//        System.out.println("Atualizando usuario");

    }
}