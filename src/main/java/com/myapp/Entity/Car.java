package com.myapp.Entity;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    @NotNull(message = "Name can't be null")
    private String name;
    @Column
    private double price;
    @Column
    @Size(min = 3, max = 100, message = "Description must be between 3 and 100 characters")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Category> categories;

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public void addOrders(OrderEntity o) {
        this.orders.add(o);
    }

    @ManyToMany(mappedBy = "cars", cascade = CascadeType.ALL)
    private Set<OrderEntity> orders;

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void addCategories(Category c) {
        this.categories.add(c);
        //return this.categories;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
