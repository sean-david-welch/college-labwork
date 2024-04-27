package org.example;

public class CartItem {
    String id;
    Product product;
    int quantity;

    public CartItem(String id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void updateQuantity(int input) {
        int newQuantity = this.quantity + input;
        if (newQuantity >= 0) {
            this.quantity = newQuantity;
        } else {
            System.out.println("Cannot reduce quantity below zero.");
            this.quantity = 0;
        }
    }
}


