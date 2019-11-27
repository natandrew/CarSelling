package com.myapp.RepsoitoryImpl;

import com.myapp.Entity.User;
import com.myapp.Repository.UserRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

public class UserRepository implements UserRepositoryInterface<User, Integer> {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private EntityManager em;
    @Override
    public void persist(User entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    @Override
    public void close() {
        emf.close();
    }
    @Override
    public void update(User entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public UserRepository() {
        em = emf.createEntityManager();    }

    @Override
    public User findById(Integer integer) {
        em.getTransaction().begin();

        User user = em.find(User.class, integer);
        if (user == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + integer);
        }
        return user;
    }

    @Override
    public void delete(User entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();

    }

    @Override
    public List<User> findAll() {
        em.getTransaction().begin();

        return (List<User>) em.createQuery("FROM User").getResultList();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();

        em.createQuery("DELETE FROM User").executeUpdate();
        em.getTransaction().commit();

    }
}
