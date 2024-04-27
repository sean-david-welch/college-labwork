import java.util.ArrayList;
import java.util.List;

public class Cart {
    String id;
    List<CartIem> items;
    int total;

    public Cart(String id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CartIem> getItems() {
        return items;
    }

    public void setItems(List<CartIem> items) {
        this.items = items;
    }

    public int getTotal() {
        this.total = 0;
        for (CartIem item : this.items) {
            this.total += (int) (item.getProduct().getPrice() * item.getQuantity());
        }
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void addItem(CartIem cartItem) {
        this.items.add(cartItem);
        this.total += (int) (cartItem.getProduct().getPrice() * cartItem.getQuantity());
    }

    public void removeItem(String itemId) {
        items.removeIf(item -> item.getId().equals(itemId));
    }

    public void clearCart() {
        this.items.clear();
        this.total = 0;
    }
}

