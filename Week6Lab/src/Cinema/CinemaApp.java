package cinema;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class CinemaApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(in)) {
            out.println("Hi! Welcome to the really old and expensive movie theater. Let's get your order started.");

            MovieSelection movieSelection = new MovieSelection(scanner);
            ConcessionSelection concessionSelection = new ConcessionSelection(scanner);

            OrderCalculator orderCalculator = new OrderCalculator(scanner, movieSelection, concessionSelection);
            double orderTotal = orderCalculator.calculateTotalPrice();

            out.println("Your order total comes to: €" + orderTotal);
        } catch (InputMismatchException err) {
            out.println("That's not how you order");
        }
    }
}