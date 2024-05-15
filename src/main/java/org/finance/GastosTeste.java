package org.finance;

import org.finance.model.entities.GastoEntity;
import org.finance.model.entities.UsuarioEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GastosTeste {
    public static void main(String[] args) {

        UsuarioEntity usuario1 = new UsuarioEntity("João Silva", "123.456.789-00", LocalDate.of(1990, 5, 15), "joao.silva@example.com", "joaosilva", "senha123");
        UsuarioEntity usuario2 = new UsuarioEntity("Maria Oliveira", "987.654.321-00", LocalDate.of(1985, 8, 23), "maria.oliveira@example.com", "mariaoliveira", "senha456");
        UsuarioEntity usuario3 = new UsuarioEntity("Carlos Pereira", "456.123.789-00", LocalDate.of(2000, 11, 30), "carlos.pereira@example.com", "carlospereira", "senha789");

        GastoEntity gasto1 = new GastoEntity(new BigDecimal("150.00"), LocalDate.now(), usuario1);
        GastoEntity gasto2 = new GastoEntity(new BigDecimal("300.00"), LocalDate.now().minusDays(1), usuario1);
        GastoEntity gasto3 = new GastoEntity(new BigDecimal("250.00"), LocalDate.now(), usuario2);
        GastoEntity gasto4 = new GastoEntity(new BigDecimal("400.00"), LocalDate.now().minusDays(2), usuario2);
        GastoEntity gasto5 = new GastoEntity(new BigDecimal("350.00"), LocalDate.now(), usuario3);
        GastoEntity gasto6 = new GastoEntity(new BigDecimal("600.00"), LocalDate.now().minusDays(3), usuario3);

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

        UsuarioEntity usuarios = em.find(UsuarioEntity.class, 1L);
        System.out.println(usuarios.toString());
        for (GastoEntity gasto: usuarios.getGastos()) {
            System.out.println(gasto.toString());
        }
    }
}
