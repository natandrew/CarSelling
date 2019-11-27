package com.myapp.RepsoitoryImpl;

import com.myapp.Entity.Car;
import com.myapp.Repository.CarRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

public class CarRepository implements CarRepositoryInterface<Car, Integer> {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private EntityManager em;

    @Override
    public void persist(Car entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public CarRepository() {
        em = emf.createEntityManager();
    }

    @Override
    public void close() {
        emf.close();
    }

    @Override
    public void update(Car entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();

    }

    @Override
    public Car findById(Integer integer) {
        em.getTransaction().begin();
        Car car = em.find(Car.class, integer);
        if (car == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + integer);
        }
        return car;
    }

    @Override
    public void delete(Car entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();

    }

    @Override
    public List<Car> findAll() {
        em.getTransaction().begin();
        return (List<Car>) em.createQuery("FROM Car").getResultList();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Car").executeUpdate();
        em.getTransaction().commit();

    }
}
