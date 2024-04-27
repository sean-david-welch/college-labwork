import static org.junit.jupiter.api.Assertions.*;

import org.example.Cart;
import org.example.Order;
import org.example.Shipping;
import org.example.Status;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void testUpdateStatus() {
        Order order = new Order("ORD1", new Cart(), new Shipping(), Status.SHIPPED);
        Status newStatus = Status.FULFILLED;

        order.updateStatus(newStatus);

        assertEquals(newStatus, order.getStatus(), "Order status should be updated");
    }

    @Test
    public void testCancelOrderFulfilled() {
        Order order = new Order("ORD2", new Cart(), new Shipping(), Status.FULFILLED);

        order.cancelOrder();

        assertEquals(Status.FULFILLED, order.getStatus(), "Order status should remain FULFILLED");
    }
}
