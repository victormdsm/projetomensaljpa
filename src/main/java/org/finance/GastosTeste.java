package org.finance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GastosTeste {
    /*public static void main(String[] args) {

        Usuarios usuario1 = new Usuarios("João Silva", "123.456.789-00", LocalDate.of(1990, 5, 15), "joao.silva@example.com", "joaosilva", "senha123");
        Usuarios usuario2 = new Usuarios("Maria Oliveira", "987.654.321-00", LocalDate.of(1985, 8, 23), "maria.oliveira@example.com", "mariaoliveira", "senha456");
        Usuarios usuario3 = new Usuarios("Carlos Pereira", "456.123.789-00", LocalDate.of(2000, 11, 30), "carlos.pereira@example.com", "carlospereira", "senha789");

        Gastos gasto1 = new Gastos(new BigDecimal("150.00"), LocalDate.now(), usuario1);
        Gastos gasto2 = new Gastos(new BigDecimal("300.00"), LocalDate.now().minusDays(1), usuario1);
        Gastos gasto3 = new Gastos(new BigDecimal("250.00"), LocalDate.now(), usuario2);
        Gastos gasto4 = new Gastos(new BigDecimal("400.00"), LocalDate.now().minusDays(2), usuario2);
        Gastos gasto5 = new Gastos(new BigDecimal("350.00"), LocalDate.now(), usuario3);
        Gastos gasto6 = new Gastos(new BigDecimal("600.00"), LocalDate.now().minusDays(3), usuario3);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-config");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(gasto1);
        em.persist(gasto2);
        em.persist(gasto3);
        em.persist(gasto4);
        em.persist(gasto5);
        em.persist(gasto6);

        em.getTransaction().commit();

        Usuarios usuarios = em.find(Usuarios.class, 1L);
        System.out.println(usuarios.toString());
        for (Gastos gasto: usuarios.getGastos()) {
            System.out.println(gasto.toString());
        }
    } */
}
