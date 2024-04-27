import java.util.HashMap;

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

    public Customer() {}

    private final HashMap<String, String> registeredCustomers = new HashMap<>();
    private boolean isLoggedIn = false;

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

    public void register(String email, String password) {
        if (registeredCustomers.get(email) == null) {
            registeredCustomers.put(email, password);
            System.out.println("Registration successful for: " + email);
        } else {
            System.out.println("Email already registered!");
        }
    }

    public void login(String email, String password) {
        String storedPassword = registeredCustomers.get(email);
        if (storedPassword != null && storedPassword.equals(password)) {
            isLoggedIn = true;
            System.out.println("Logged in successfully as: " + email);
        } else {
            System.out.println("Login failed. Incorrect email or password.");
        }
    }

    public void placeOrder(Order order) {
        if (isLoggedIn) {
            order.updateStatus(Status.FULFILLED);
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("You need to login first.");
        }
    }

    public void initiateCheckout() {
        if (isLoggedIn) {
            if (!shoppingCart.items.isEmpty()) {
                System.out.println("Initiating checkout...");
                System.out.println("Checkout complete. Total:€ " + shoppingCart.getTotal());
            } else {
                System.out.println("Your shopping cart is empty.");
            }
        } else {
            System.out.println("You need to login first.");
        }
    }
}

