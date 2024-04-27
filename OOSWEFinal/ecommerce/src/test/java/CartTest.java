import static org.junit.jupiter.api.Assertions.*;
import org.example.Cart;
import org.example.CartItem;
import org.example.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTest {
    private Cart cart;
    private CartItem item1;
    private CartItem item2;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        Product product1 = new Product("1", "Product1", "description 1", 10.00F);
        Product product2 = new Product("2", "Product2", "description 2", 15.00F);
        item1 = new CartItem("1", product1, 2);
        item2 = new CartItem("2", product2, 3);
    }

    @Test
    public void testAddItem() {
        cart.addItem(item1);
        assertEquals(1, cart.getItems().size(), "Items should match");
        assertEquals(20, cart.getTotal(), "Total should be 20");
    }

    @Test
    public void testRemoveItem() {
        cart.addItem(item1);
        cart.addItem(item2);
        cart.removeItem(item1.getId());
        assertEquals(1, cart.getItems().size(), "Should have 1 item left");
        assertEquals(45, cart.getTotal(), "Total should be 45 after removing item1");
    }

    @Test
    public void testGetTotalWithMultipleItems() {
        cart.addItem(item1);
        cart.addItem(item2);
        assertEquals(65, cart.getTotal(), "Total should sum to 65");
    }

    @Test
    public void testClearCart() {
        cart.addItem(item1);
        cart.addItem(item2);
        cart.clearCart();
        assertEquals(0, cart.getItems().size(), "Cart should be empty");
        assertEquals(0, cart.getTotal(), "Total should be 0 after clear");
    }
}
