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

    void updateStatus(Status status) {}
    void cancelOrder() {}
}
