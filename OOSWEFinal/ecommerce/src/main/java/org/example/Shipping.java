package org.example;

public class Shipping {
    String id;
    String address;
    String deliveryCost;
    Status status;

    public Shipping(String id, String address, String deliveryCost, Status status) {
        this.id = id;
        this.address = address;
        this.deliveryCost = deliveryCost;
        this.status = status;
    }

    public Shipping() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(String deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void updateStatus(Status newStatus) {
        this.status = newStatus;
    }
}
