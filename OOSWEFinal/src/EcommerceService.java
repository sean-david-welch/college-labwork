import java.util.Scanner;

public class EcommerceService {
    private final Scanner scanner;

    public EcommerceService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void registerUser() {}
    public void loginUser() {}
    public void viewCart() {}
    public void viewProducts() {}
    public void addProductToCart () {}
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
                System.out.println("Invalid option. Try Again or enter 0 to see the options! Press 6 to quit!");
                System.out.println("-------------------");
            }
        }
    }
}
