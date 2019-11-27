package com.myapp.RepsoitoryImpl;

import com.myapp.Entity.Cart;
import com.myapp.Repository.CartRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

public class CartRepository implements CartRepositoryInterface<Cart, Integer> {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private EntityManager em;

    @Override
    public void persist(Cart entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public CartRepository() {
        em = emf.createEntityManager();
    }

    @Override
    public void close() {
        emf.close();
    }

    @Override
    public void update(Cart entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public Cart findById(Integer integer) {
        em.getTransaction().begin();
        Cart cart = em.find(Cart.class, integer);
        if (cart == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + integer);
        }
        return cart;
    }

    @Override
    public void delete(Cart entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();

    }

    @Override
    public List<Cart> findAll() {
        em.getTransaction().begin();

        return (List<Cart>) em.createQuery("FROM Cart").getResultList();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();

        em.createQuery("DELETE FROM Cart").executeUpdate();
        em.getTransaction().commit();

    }
}
