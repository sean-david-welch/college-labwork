package org.example;

import java.util.UUID;

public class Product {
    String id;
    String name;
    String description;
    float price;

    public Product(String id, String name, String description, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void buyNow(Cart cart, int quantity) {
        CartItem cartItem = new CartItem(UUID.randomUUID().toString(), this, quantity);
        cart.addItem(cartItem);
    }
}
