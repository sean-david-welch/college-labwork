package Cinema;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketPriceApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hi! Welcome to the really old and expensive movie theater. Let's get your order started.");

            MovieSelection movieSelection = new MovieSelection(scanner);
            ConcessionSelection concessionSelection = new ConcessionSelection(scanner);

            OrderCalculator orderCalculator = new OrderCalculator(scanner, movieSelection, concessionSelection);
            double orderTotal = orderCalculator.calculateTotalPrice();

            System.out.println("Your order total comes to: $" + orderTotal);
        } catch (InputMismatchException err) {
            System.out.println("Please provide valid input.");
        }
    }
}