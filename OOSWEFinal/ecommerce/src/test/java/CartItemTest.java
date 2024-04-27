import static org.junit.jupiter.api.Assertions.*;

import org.example.CartItem;
import org.example.Product;
import org.junit.jupiter.api.Test;

public class CartItemTest {

    @Test
    public void testUpdateQuantityPositive() {
        Product product = new Product("1", "Product", "Description", 10.00f);
        CartItem item = new CartItem("1", product, 2);

        item.updateQuantity(3);
        assertEquals(5, item.getQuantity(), "Quantity should be updated to 5");
    }

    @Test
    public void testUpdateQuantityZero() {
        Product product = new Product("1", "Product", "Description", 10.00f);
        CartItem item = new CartItem("1", product, 2);

        item.updateQuantity(0);
        assertEquals(2, item.getQuantity(), "Quantity should remain 2");
    }

    @Test
    public void testUpdateQuantityNegative() {
        Product product = new Product("1", "Product", "Description", 10.00f);
        CartItem item = new CartItem("1", product, 2);

        item.updateQuantity(-3);

        assertEquals(0, item.getQuantity(), "Quantity should be set to zero");
    }
}
