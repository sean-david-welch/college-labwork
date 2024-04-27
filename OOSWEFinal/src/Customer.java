public class Customer {
    String id;
    String name;
    String email;
    Shipping shipping;
    Cart shoppingCart;

    public Customer(String id, String name, String email, Shipping shipping, Cart shoppingCart) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.shipping = shipping;
        this.shoppingCart = shoppingCart;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Cart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    void register(String email, String password) {}
    void login(String email, String password) {}
    void placeOrder(Order order) {}
    void initiateCheckout() {}
}

