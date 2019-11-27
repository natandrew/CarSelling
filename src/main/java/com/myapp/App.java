package com.myapp;

import com.myapp.Entity.*;
import com.myapp.RepsoitoryImpl.CarRepository;
import com.myapp.Service.*;

import java.sql.SQLException;
import java.util.Date;

public class App {
    public static Car addCarToDB(String description, String name, double price) {
        Car car = new Car();
        car.setDescription(description);
        car.setName(name);
        car.setPrice(price);
        //car.addCategories(category);
        // car.addOrders(order);
        CarService carService = new CarService();
        carService.persist(car);
        carService.close();
        return car;
    }

    public static Cart addCartToDB( double totalPrice, int noOfProducts) {
        Cart cart = new Cart();
        //cart.setUser(user);
        cart.setTotalPrice(totalPrice);
        cart.setNumberOfProducts(noOfProducts);
        //cart.setOrderEntity(order);
        CartService cartService=new CartService();
        cartService.persist(cart);
        cartService.close();
        return cart;
    }

    public static Category addCategoryToDB(String name) {
        Category category = new Category();
        category.setCategoryName(name);
        //category.addCars(car);
        CategoryService categoryService = new CategoryService();
        categoryService.persist(category);
        categoryService.close();
        return category;
    }

    public static OrderEntity addOrderToDB(double amount, Date date) {
        OrderEntity order = new OrderEntity();
        order.setAmount(amount);
        order.setDate(date);
        //order.addCars(car);
        //order.setUser(user);
        //order.setCart(cart);
        OrderService orderService = new OrderService();
        orderService.persist(order);
        orderService.close();
        return order;
    }

    public static User addUserToDB(String name, String email, String phone, String address, String cityRegion, String cCNumber) {
        User user = new User();
        user.setUserName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setCityRegion(cityRegion);
        user.setcCNumber(cCNumber);
        //user.setCart(cart);
        //user.addOrders(order);
        //user.addUserTypes(userType);
        UserService userService = new UserService();
        userService.persist(user);
        userService.close();
        return user;
    }

    public static UserType addUserTypeToDB(String type) {
        UserType userType = new UserType();
        userType.setType(type);
        //userType.addUsers(user);
        UserTypeService userTypeService = new UserTypeService();
        userTypeService.persist(userType);
        userTypeService.close();
        return userType;
    }

    public static void main(String[] args) {
        Car car = addCarToDB("sfsfg", "Honda", 10000);
//        Cart cart=addCartToDB(10000,1);
//        Cart cart1=addCartToDB(20000,1);

    }
}
