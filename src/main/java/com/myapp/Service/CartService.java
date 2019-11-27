package com.myapp.Service;

import com.myapp.Entity.Cart;
import com.myapp.RepsoitoryImpl.CartRepository;

public class CartService {
    private static CartRepository cartRepository;

    public CartService() {
        cartRepository = new CartRepository();
    }

    public void persist(Cart entity) {
        cartRepository.persist(entity);
    }

    public void delete(Cart entity) {
        cartRepository.delete(entity);
    }

    public Cart findById(Integer integer) {
        Cart test;
        test = cartRepository.findById(integer);
        return test;
    }

    public void update(Cart entity) {
        cartRepository.update(entity);

    }

    public void findAll() {
        cartRepository.findAll();

    }
    public void close()
    {
        cartRepository.close();
    }
    public void deleteAll() {
        cartRepository.deleteAll();

    }

}