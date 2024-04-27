import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class EcommerceService {
    private final Cart cart = new Cart();
    private final Customer customer = new Customer();
	private final List<Product> products = new ArrayList<>();

    public EcommerceService() {
        products.add(new Product(UUID.randomUUID().toString(), "Whey Protein", "Premium whey protein for muscle growth, 2 lbs", 49.99f));
        products.add(new Product(UUID.randomUUID().toString(), "Multivitamins", "Complete daily multivitamins for overall health", 29.99f));
        products.add(new Product(UUID.randomUUID().toString(), "Omega-3 Capsules", "High-strength fish oil omega-3 capsules", 19.99f));
    }

    public void registerUser(String email, String password) {
        customer.register(email, password);
    }
    public void loginUser(String email, String password) {
        customer.login(email, password);
    }

    public List<CartItem> viewCart() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty.");
            return null;
        }

        return cart.getItems();
    }

    public int getCartSubtotal() {
        return cart.getTotal();
    }

    public List<Product> viewProducts() {
        return products;
    }

    public void addProductToCart (String productName, int quantity) {
        for (Product product: products) {
            if (Objects.equals(productName, product.name)) {
                String cartItemId = UUID.randomUUID().toString();
                CartItem cartItem = new CartItem(cartItemId, product, quantity);

                cart.addItem(cartItem);
                System.out.println("Added " + quantity + " of " + productName + " to the cart.");
                return;
            }
        }
    }

    public void initiateCheckout() {}
}
