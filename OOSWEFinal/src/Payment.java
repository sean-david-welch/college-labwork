public class Payment {
    String id;
    int amount;
    String customerId;
    boolean complete;

    public Payment(String id, int amount, String customerId, boolean complete) {
        this.id = id;
        this.amount = amount;
        this.customerId = customerId;
        this.complete = complete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    void declineOrder() {}
    void notifyCustomer() {}
    void process(String id, int amount) {}
}
