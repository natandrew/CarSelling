package com.myapp.Service;

import com.myapp.Entity.Car;
import com.myapp.RepsoitoryImpl.CarRepository;

public class CarService {
    private static CarRepository carRepository;

    public CarService() {
        carRepository =new CarRepository();
    }

    public void persist(Car entity) {
        carRepository.persist(entity);
    }
    public void delete(Car entity)
    {
        carRepository.delete(entity);
    }
    public Car findById(Integer integer) {
        Car test;
        test= carRepository.findById(integer);
        return test;
    }
    public void update(Car entity){
        carRepository.update(entity);

    }
    public void findAll() {
        carRepository.findAll();

    }
    public void deleteAll(){
        carRepository.deleteAll();

    }
    public void close()
    {
        carRepository.close();
    }

}

