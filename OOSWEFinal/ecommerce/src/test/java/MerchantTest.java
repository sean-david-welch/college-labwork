import static org.junit.jupiter.api.Assertions.*;

import org.example.Merchant;
import org.example.Order;
import org.example.Status;
import org.junit.jupiter.api.Test;

public class MerchantTest {

    @Test
    public void testManageOrderCancelled() {
        Merchant merchant = new Merchant("1", "Merchant 1");
        Order cancelledOrder = new Order();
        cancelledOrder.setStatus(Status.CANCELLED);

        merchant.manageOrder(cancelledOrder);

        assertEquals(Status.CANCELLED, cancelledOrder.getStatus(), "Order status should be CANCELLED");
    }

    @Test
    public void testManageOrderActive() {
        Merchant merchant = new Merchant("M1", "Merchant 1");
        Order activeOrder = new Order();
        activeOrder.setStatus(Status.SHIPPED);

        merchant.manageOrder(activeOrder);

        assertEquals(Status.SHIPPED, activeOrder.getStatus(), "Order status should be SHIPPED");
    }

    @Test
    public void testShipOrderFulfilled() {
        Merchant merchant = new Merchant("M1", "Merchant 1");
        Order fulfilledOrder = new Order();

        merchant.shipOrder(fulfilledOrder);

        assertEquals(Status.FULFILLED, fulfilledOrder.getStatus(), "Order status should be FULFILLED");
    }
}
