package com.myapp.RepsoitoryImpl;

import com.myapp.Entity.Category;
import com.myapp.Repository.CategoryRepositoryInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

public class CategoryRepository implements CategoryRepositoryInterface<Category, Integer> {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private EntityManager em;
    @Override
    public void persist(Category entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    @Override
    public void close() {
        emf.close();
    }
    @Override
    public void update(Category entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public CategoryRepository() {
        em = emf.createEntityManager();
    }

    @Override
    public Category findById(Integer integer) {
        em.getTransaction().begin();

        Category category = em.find(Category.class, integer);
        if (category == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + integer);
        }
        return category;
    }

    @Override
    public void delete(Category entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();

    }

    @Override
    public List<Category> findAll() {
        em.getTransaction().begin();

        return (List<Category>) em.createQuery("FROM Category").getResultList();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();

        em.createQuery("DELETE FROM Category").executeUpdate();
        em.getTransaction().commit();

    }
}
