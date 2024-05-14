package org.finance;


import org.finance.model.Enderecos;
import org.finance.model.Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Usuarios usuario1 = new Usuarios("João Silva", "123.456.789-00", LocalDate.of(1990, 5, 15), "joao.silva@example.com", "joaosilva", "senha123");
        Usuarios usuario2 = new Usuarios("Maria Oliveira", "987.654.321-00", LocalDate.of(1985, 8, 23), "maria.oliveira@example.com", "mariaoliveira", "senha456");
        Usuarios usuario3 = new Usuarios("Carlos Pereira", "456.123.789-00", LocalDate.of(2000, 11, 30), "carlos.pereira@example.com", "carlospereira", "senha789");

        Enderecos endereco1 = new Enderecos("Av. Paulista", "1578", "01310-200", "São Paulo", "SP", "Brasil", "Apt 101", usuario1);
        Enderecos endereco2 = new Enderecos("Rua das Flores", "300", "01001-000", "Curitiba", "PR", "Brasil", "Bloco B, Casa 4", usuario2);
        Enderecos endereco3 = new Enderecos("Av. Atlântica", "456", "22010-000", "Rio de Janeiro", "RJ", "Brasil", "Cobertura", usuario3);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-config");
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        em.persist(endereco1);
        em.persist(endereco2);
        em.persist(endereco3);
        em.getTransaction().commit();

    }
}