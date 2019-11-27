package com.myapp.Service;

import com.myapp.Entity.Category;
import com.myapp.RepsoitoryImpl.CategoryRepository;

public class CategoryService {
    private static CategoryRepository categoryRepository;

    public CategoryService() {
        categoryRepository = new CategoryRepository();
    }

    public void persist(Category entity) {
        categoryRepository.persist(entity);
    }

    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }

    public Category findById(Integer integer) {
        Category test;
        test = categoryRepository.findById(integer);
        return test;
    }

    public void update(Category entity) {
        categoryRepository.update(entity);

    }

    public void findAll() {
        categoryRepository.findAll();

    }
    public void close()
    {
        categoryRepository.close();
    }
    public void deleteAll() {
        categoryRepository.deleteAll();

    }

}

