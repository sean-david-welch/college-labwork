package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    String id;
    List<CartItem> items;
    int total;

    public Cart() {
        this.id = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public int getTotal() {
        this.total = 0;
        for (CartItem item : this.items) {
            this.total += (int) (item.getProduct().getPrice() * item.getQuantity());
        }
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void addItem(CartItem cartItem) {
        this.items.add(cartItem);
        this.total += (int) (cartItem.getProduct().getPrice() * cartItem.getQuantity());
    }

    public void removeItem(String itemId) {
        items.removeIf(item -> item.getId().equals(itemId));
    }

    public void clearCart() {
        this.items.clear();
        this.total = 0;
    }
}

