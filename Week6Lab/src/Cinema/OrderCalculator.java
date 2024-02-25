package cinema;

import java.util.Scanner;

public class OrderCalculator {
    private final Scanner scanner;
    private final MovieSelection movieSelection;
    private final ConcessionSelection concessionSelection;

    public OrderCalculator(Scanner scanner, MovieSelection movieSelection, ConcessionSelection concessionSelection) {
        this.scanner = scanner;
        this.movieSelection = movieSelection;
        this.concessionSelection = concessionSelection;
    }

    public double calculateTotalPrice() {
        double totalPrice = 9.99;

        movieSelection.chooseMovieOption();
        try {
            System.out.println("How many tickets would you like?:");
            int input = scanner.nextInt();
            totalPrice *= input;
            scanner.nextLine();
        } catch (IllegalArgumentException err) {
            System.out.println("Give me a valid number please");
        }

        double popcornPrice = 4.99;
        int popcornQuantity = concessionSelection.choosePopcorn();
        totalPrice += (popcornPrice * popcornQuantity);
        
        double sodaPrice = 3.99;
        int sodaQuantity = concessionSelection.chooseSodaQuantity();
        totalPrice += (sodaPrice * sodaQuantity);

        return totalPrice;
    }
}
