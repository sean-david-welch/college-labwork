public class Customer {
    String id;
    String name;
    String email;
    Shipping shipping;
    Cart shoppingCart;

    void register(String email, String password) {}
    void login(String email, String password) {}
    void placeOrder(Order order) {}
    void initiateCheckout() {}
}

