import java.util.List;
import java.util.Scanner;

public class EcommerceTUI {
    private final Scanner scanner;
    private final EcommerceService ecommerceService;

    public EcommerceTUI(Scanner scanner, EcommerceService ecommerceService) {
        this.scanner = scanner;
        this.ecommerceService = ecommerceService;
    }

    public void registerUser() {
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        ecommerceService.registerUser(email, password);
    }

    public void loginUser() {
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        ecommerceService.loginUser(email, password);
    }

    public void viewCart() {
        List<CartItem> items = ecommerceService.viewCart();


        if (!items.isEmpty()) {

            System.out.println("Items in your cart:");
            System.out.printf("%-30s %-10s %-10s%n", "Product Name", "Quantity", "Price");

            for (CartItem item : items) {
                Product product = item.getProduct();
                System.out.printf("%-30s %-10d €%.2f%n",
                        product.getName(),
                        item.getQuantity(),
                        product.getPrice() * item.getQuantity());
            }

            int subtotal = ecommerceService.getCartSubtotal();
            System.out.println("Total: €" + subtotal);
        }
    }

    public void viewProducts() {
        List<Product> products = ecommerceService.viewProducts();

        if (products.isEmpty()) {
            System.out.println("No products available");
            return;
        }

        System.out.println("Available Products:");
        int index = 1;
        for (Product product : products) {
            System.out.printf("%d. Name: %-30s Description: %-50s Price: €%.2f%n",
                    index++,
                    product.getName(),
                    product.getDescription(),
                    product.getPrice());
        }
        System.out.println("-------------------");
    }


    public void addProductToCart () {
        viewProducts();

        System.out.println("Enter the name of the product you want to add to the cart:");
        String productName = scanner.nextLine().trim();
        System.out.println("-------------------");


        System.out.println("Enter the quantity:");
        System.out.println("-------------------");
        int quantity;
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
        System.out.println("-------------------");
    }

    public void initiateCheckout() {
        ecommerceService.initiateCheckout();
    }

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
            String inputLine = scanner.nextLine().trim();
            int input = -1;
            try {
                input = Integer.parseInt(inputLine);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            System.out.println("-------------------");

            if (input == 0) {
                this.viewMainOptions();
                continue;
            } else if (input == 7) {
                break;
            }

            switch (input) {
                case 1:
                    this.registerUser();
                    break;
                case 2:
                    this.loginUser();
                    break;
                case 3:
                    this.viewCart();
                    break;
                case 4:
                    this.viewProducts();
                    break;
                case 5:
                    this.addProductToCart();
                    break;
                case 6:
                    this.initiateCheckout();
                    break;
                default:
                    System.out.println("Invalid option. Try Again or enter 0 to see the options! Press 7 to quit!");
                    System.out.println("-------------------");
            }
        }
    }

}
