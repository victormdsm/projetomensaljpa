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

        UsuarioEntity usuario1 = new UsuarioEntity("João Silva", "123.456.789-00", LocalDate.of(1990, 5, 15), "joao.silva@example.com", "joaosilva", "senha123");
        UsuarioEntity usuario2 = new UsuarioEntity("Maria Oliveira", "987.654.321-00", LocalDate.of(1985, 8, 23), "maria.oliveira@example.com", "mariaoliveira", "senha456");
        UsuarioEntity usuario3 = new UsuarioEntity("Carlos Pereira", "456.123.789-00", LocalDate.of(2000, 11, 30), "carlos.pereira@example.com", "carlospereira", "senha789");

        EnderecoEntity endereco1 = new EnderecoEntity("Av. Paulista", "1578", "01310-200", "São Paulo", "SP", "Brasil", "Apt 101", usuario1);
        EnderecoEntity endereco2 = new EnderecoEntity("Rua das Flores", "300", "01001-000", "Curitiba", "PR", "Brasil", "Bloco B, Casa 4", usuario2);
        EnderecoEntity endereco3 = new EnderecoEntity("Av. Atlântica", "456", "22010-000", "Rio de Janeiro", "RJ", "Brasil", "Cobertura", usuario3);

        System.out.println("Usuario adicionado: " + usuarioController.adicionarUsuario(usuario1).toString());
        System.out.println("Usuario adicionado: " + usuarioController.adicionarUsuario(usuario2).toString());
        System.out.println("Usuario adicionado: " + usuarioController.adicionarUsuario(usuario3).toString());

        for (UsuarioEntity users: usuarioController.resgatarUsuarios()
                 ) {
            System.out.println("Usuarios do sistema: ");
            System.out.println(users.toString());
            }

    }
}