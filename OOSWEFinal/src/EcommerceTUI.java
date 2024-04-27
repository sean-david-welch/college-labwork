import java.util.List;
import java.util.Scanner;

public class EcommerceTUI {
    private final Scanner scanner;
    private final EcommerceService ecommerceService;

    public EcommerceTUI(Scanner scanner, EcommerceService ecommerceService) {
        this.scanner = scanner;
        this.ecommerceService = ecommerceService;
    }

    public void registerUser() {}

    public void loginUser() {}

    public void viewCart() {
        List<CartItem> items = ecommerceService.viewCart();

        System.out.println("Items in your cart:");
        System.out.printf("%-30s %-10s %-10s%n", "Product Name", "Quantity", "Price");

        for (CartItem item : items) {
            Product product = item.getProduct();
            System.out.printf("%-30s %-10d $%.2f%n",
                    product.getName(),
                    item.getQuantity(),
                    product.getPrice() * item.getQuantity());
        }

        int subtotal = ecommerceService.getCartSubtotal();
        System.out.println("Total: $" + subtotal);

        scanner.nextInt();
    }

    public void viewProducts() {
        List<Product> products = ecommerceService.viewProducts();

        if (products.isEmpty()) {
            System.out.println("No products available");
            return;
        }

        System.out.println("Available Products:");
        System.out.printf("%-10s %-30s %-50s %s%n", "ID", "Name", "Description", "Price");

        for (Product product : products) {
            System.out.printf("%-10s %-30s %-50s $%.2f%n",
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice());
        }
    }

    public void addProductToCart () {
        viewProducts();

        System.out.println("Enter the name of the product you want to add to the cart:");
        String productName = scanner.nextLine().trim();

        System.out.println("Enter the quantity:");
        int quantity = 0;
        try {
            quantity = Integer.parseInt(scanner.nextLine().trim());
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for quantity. Please enter a number.");
            return;
        }

        ecommerceService.addProductToCart(productName, quantity);
    }

    public void initiateCheckout() {}

    private void viewMainOptions() {
        String[] mainOptions = new String[] {
                "Register User", "Login User",
                "View Cart", "View Products",
                "Add Product To Cart", "Initiate Checkout"
        };

        System.out.println("-------------------");
        System.out.println("Please choose from the options... Enter 0 to view them again.... Press 7 to quit");
        System.out.println("-------------------");
        for (int i = 0; i < mainOptions.length; i++) {
            System.out.printf("%s. %s%n", (i + 1), mainOptions[i]);
        }
        System.out.println("-------------------");
    }

    public void ecommerceController() {
        this.viewMainOptions();

        while (true) {
            int input = scanner.nextInt();
            scanner.nextLine();
            System.out.println("-------------------");

            if (input == 0) {
                this.viewMainOptions();
                continue;
            } else if (input == 7) {
                break;
            }

            if (input == 1) {
                this.registerUser();
            } else if (input == 2) {
                this.loginUser();
            } else if (input == 3) {
                this.viewCart();
            } else if (input == 4) {
                this.viewProducts();
            } else if (input == 5) {
                this.addProductToCart();
            } else if (input == 6) {
                this.initiateCheckout();
            } else {
                System.out.println("Invalid option. Try Again or enter 0 to see the options! Press 7 to quit!");
                System.out.println("-------------------");
            }
        }
    }
}
