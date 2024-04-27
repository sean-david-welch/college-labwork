package org.example;

public class Merchant {
    String id;
    String name;

    public Merchant(String id, String name) {
        this.id = id;
        this.name = name;
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

    public void manageOrder(Order order) {
        if (order.getStatus() == Status.CANCELLED) {
            System.out.println("Order ID " + order.getId() + " has been cancelled. No further actions are possible.");
        } else {
            System.out.println("Managing order ID " + order.getId() + ".");
        }
    }

    public void shipOrder(Order order) {
        if (order.getStatus() == Status.FULFILLED) {
            order.updateStatus(Status.SHIPPED);
            System.out.println("Order ID " + order.getId() + " has been shipped.");
        } else {
            System.out.println("Order ID " + order.getId() + " is not ready for shipping.");
        }
    }
}
