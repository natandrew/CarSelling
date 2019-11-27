package com.myapp.Service;

import com.myapp.Entity.UserType;
import com.myapp.RepsoitoryImpl.UserTypeRepository;

public class UserTypeService {
    private static UserTypeRepository userTypeRepository;

    public UserTypeService() {
        userTypeRepository = new UserTypeRepository();
    }

    public void persist(UserType entity) {
        userTypeRepository.persist(entity);
    }

    public void delete(UserType entity) {
        userTypeRepository.delete(entity);
    }

    public UserType findById(Integer integer) {
        UserType test;
        test = userTypeRepository.findById(integer);
        return test;
    }
    public void close()
    {
        userTypeRepository.close();
    }
    public void update(UserType entity) {
        userTypeRepository.update(entity);

    }

    public void findAll() {
        userTypeRepository.findAll();

    }

    public void deleteAll() {
        userTypeRepository.deleteAll();

    }

}