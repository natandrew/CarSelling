package com.myapp.Service;

import com.myapp.Entity.User;
import com.myapp.RepsoitoryImpl.UserRepository;

public class UserService {
    private static UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public void persist(User entity) {
        userRepository.persist(entity);
    }

    public void delete(User entity) {
        userRepository.delete(entity);
    }

    public User findById(Integer integer) {
        User test;
        test = userRepository.findById(integer);
        return test;
    }

    public void update(User entity) {
        userRepository.update(entity);

    }

    public void findAll() {
        userRepository.findAll();

    }
    public void close()
    {
        userRepository.close();
    }
    public void deleteAll() {
        userRepository.deleteAll();

    }

}