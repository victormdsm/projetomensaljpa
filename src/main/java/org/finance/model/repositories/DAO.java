package org.finance.model.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("jpa-config");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DAO(Class<E> classe) {
        if (emf == null) {
            throw new IllegalStateException("EntityManagerFactory is not initialized.");
        }
        this.em = emf.createEntityManager();
        this.classe = classe;
    }

    public DAO<E> openTransaction() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> closeTransaction() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> insertData(E entity) {
        em.persist(entity);
        return this;
    }

    public DAO<E> insertTransaction(E entity) {
        return this.openTransaction().insertData(entity).closeTransaction();
    }

    public List<E> getAllData() {
        return this.getAllData(10, 0);
    }

    public List<E> getAllData(int quantity, int limit) {
        if (classe == null) {
            throw new UnsupportedOperationException("class null");
        }
        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(quantity);
        query.setFirstResult(limit);
        return query.getResultList();
    }

    public void close() {
        em.close();
    }


}
