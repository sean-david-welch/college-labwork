public class Order {
    String id;
    Cart cart;
    Shipping shipping;
    Status status;

    void updateStatus(Status status) {}
    void cancelOrder() {}
}
