package com.myapp.Service;

import com.myapp.Entity.OrderEntity;
import com.myapp.RepsoitoryImpl.OrderRepository;

public class OrderService {
    private static OrderRepository orderRepository;

    public OrderService() {
        orderRepository = new OrderRepository();
    }

    public void persist(OrderEntity entity) {
        orderRepository.persist(entity);
    }

    public void delete(OrderEntity entity) {
        orderRepository.delete(entity);
    }

    public OrderEntity findById(Integer integer) {
        OrderEntity test;
        test = orderRepository.findById(integer);
        return test;
    }

    public void update(OrderEntity entity) {
        orderRepository.update(entity);

    }

    public void findAll() {
        orderRepository.findAll();

    }
    public void close()
    {
        orderRepository.close();
    }
    public void deleteAll() {
        orderRepository.deleteAll();

    }

}