package com.myapp.RepsoitoryImpl;

import com.myapp.Repository.UserTypeRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

public class UserTypeRepository implements UserTypeRepositoryInterface<com.myapp.Entity.UserType, Integer> {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private EntityManager em;

    @Override
    public void persist(com.myapp.Entity.UserType entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        emf.close();
    }

    @Override
    public void update(com.myapp.Entity.UserType entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public UserTypeRepository() {
        em = emf.createEntityManager();
    }

    @Override
    public com.myapp.Entity.UserType findById(Integer integer) {
        em.getTransaction().begin();

        com.myapp.Entity.UserType userType = em.find(com.myapp.Entity.UserType.class, integer);
        if (userType == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + integer);
        }
        return userType;
    }

    @Override
    public void delete(com.myapp.Entity.UserType entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();

    }

    @Override
    public List<com.myapp.Entity.UserType> findAll() {
        em.getTransaction().begin();

        return (List<com.myapp.Entity.UserType>) em.createQuery("FROM UserType").getResultList();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM UserType").executeUpdate();
        em.getTransaction().commit();

    }
}
