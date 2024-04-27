import java.util.List;

public class Cart {
    String id;
    List<CartIem> items;
    int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart(String id, List<CartIem> items, int quantity) {
        this.id = id;
        this.items = items;
        this.quantity = quantity;
    }

    void buyNow(float price, int quantity) {}
}

