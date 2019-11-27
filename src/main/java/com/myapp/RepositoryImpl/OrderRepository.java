package com.myapp.RepsoitoryImpl;

import com.myapp.Entity.OrderEntity;
import com.myapp.Repository.OrderRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

public class OrderRepository implements OrderRepositoryInterface<OrderEntity, Integer> {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private EntityManager em;

    @Override
    public void persist(OrderEntity entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        emf.close();
    }

    @Override
    public void update(OrderEntity entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public OrderRepository() {
        em = emf.createEntityManager();
    }

    @Override
    public OrderEntity findById(Integer integer) {
        em.getTransaction().begin();

        OrderEntity order = em.find(OrderEntity.class, integer);
        if (order == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + integer);
        }
        return order;
    }

    @Override
    public void delete(OrderEntity entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();

    }

    @Override
    public List<OrderEntity> findAll() {
        em.getTransaction().begin();

        return (List<OrderEntity>) em.createQuery("FROM Order").getResultList();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();

        em.createQuery("DELETE FROM Order").executeUpdate();
        em.getTransaction().commit();

    }
}
