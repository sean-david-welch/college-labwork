package org.example;

public class Order {
    String id;
    Cart cart;
    Shipping shipping;
    Status status;

    public Order(String id, Cart cart, Shipping shipping, Status status) {
        this.id = id;
        this.cart = cart;
        this.shipping = shipping;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void updateStatus(Status newStatus) {
        this.status = newStatus;
        System.out.println("Order ID " + id + " status updated to: " + status);
    }

    public void cancelOrder() {
        if (status == Status.FULFILLED) {
            System.out.println("Order ID " + id + " cannot be cancelled as it is already fulfilled.");
        } else {
            this.status = Status.CANCELLED;
            System.out.println("Order ID " + id + " has been cancelled.");
        }
    }
}
