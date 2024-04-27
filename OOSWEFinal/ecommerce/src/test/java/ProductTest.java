import static org.junit.jupiter.api.Assertions.*;

import org.example.Cart;
import org.example.CartItem;
import org.example.Product;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testBuyNow() {
        Product product = new Product("P1", "Product Name", "Description", 10.00f);
        Cart cart = new Cart();

        product.buyNow(cart, 2);

        assertEquals(1, cart.getItems().size(), "One item should be added to the cart");
        CartItem cartItem = cart.getItems().getFirst();

        assertEquals(product, cartItem.getProduct(), "Product should match");
        assertEquals(2, cartItem.getQuantity(), "Quantity should be 2");
    }
}
