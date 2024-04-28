import static org.junit.jupiter.api.Assertions.*;

import org.example.Shipping;
import org.example.Status;
import org.junit.jupiter.api.Test;

public class ShippingTest {

    @Test
    public void testUpdateStatus() {
        Shipping shipping = new Shipping("SHIP1", "123 Main St", "$5.00", Status.SHIPPED);
        Status newStatus = Status.FULFILLED;

        shipping.updateStatus(newStatus);

        assertEquals(newStatus, shipping.getStatus(), "Shipping status should be updated");
    }
}
