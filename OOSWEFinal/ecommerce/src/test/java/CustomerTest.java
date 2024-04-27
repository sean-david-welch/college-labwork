import static org.junit.jupiter.api.Assertions.*;

import org.example.Cart;
import org.example.Customer;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testCustomerRegistration() {
        Customer customer = new Customer();
        String email = "test@example.com";
        String password = "password123";

        customer.register(email, password);

        assertTrue(customer.registeredCustomers.containsKey(email), "Email should be registered");
        assertEquals(password, customer.registeredCustomers.get(email), "Password should match");
    }

    @Test
    public void testCustomerLoginSuccess() {
        Customer customer = new Customer();
        String email = "test@example.com";
        String password = "password123";

        customer.register(email, password);
        customer.login(email, password);

        assertTrue(customer.isLoggedIn, "Customer should be logged in");
    }

    @Test
    public void testCustomerLoginFailIncorrectPassword() {
        Customer customer = new Customer();
        String email = "test@example.com";
        String password = "password123";
        String wrongPassword = "wrongpassword";

        customer.register(email, password);
        customer.login(email, wrongPassword);

        assertFalse(customer.isLoggedIn, "Customer should not be logged in");
    }


    @Test
    public void testInitiateCheckoutLoggedInEmptyCart() {
        Customer customer = new Customer();
        String email = "test@example.com";
        String password = "password123";
        Cart emptyCart = new Cart();

        customer.register(email, password);
        customer.login(email, password);
        customer.setShoppingCart(emptyCart);
        customer.initiateCheckout();

        assertEquals(0, emptyCart.getItems().size(), "Shopping cart should be empty");
    }
}
