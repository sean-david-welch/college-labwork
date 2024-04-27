public class Payment {
    String id;
    int amount;
    String customerId;
    boolean complete;

    void process(String id, int amount) {}
    void declineOrder() {}
    void notifyCustomer() {}
}
