package org.finance;


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


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-config");
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        em.persist(usuario1);
        em.persist(usuario2);
        em.persist(usuario3);

        em.getTransaction().commit();

    }
}