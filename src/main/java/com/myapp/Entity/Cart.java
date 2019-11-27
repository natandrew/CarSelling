package com.myapp.Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int cartId;
    @Min(value = 1,message = "Number of products shouldn't be less than 1")
    @Max(value=100,message = "Number of products shouldn't be greater than 100")
    @Column
    private int numberOfProducts;

    @Column
    @Positive(message = "Total price must be positive")
    private double totalPrice;

    @OneToOne(mappedBy = "cart",cascade=CascadeType.ALL)
    private User user;

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    @OneToOne(mappedBy = "cart",cascade = CascadeType.ALL)
    private OrderEntity orderEntity;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCartId() {
        return cartId;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
