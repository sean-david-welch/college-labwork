package Cinema;

import java.util.Scanner;

public class OrderCalculator {
    private final Scanner scanner;
    private final MovieSelection movieSelection;
    private final ConcessionSelection concessionSelection;

    private int numberTickets;

    public OrderCalculator(Scanner scanner, MovieSelection movieSelection, ConcessionSelection concessionSelection) {
        this.scanner = scanner;
        this.movieSelection = movieSelection;
        this.concessionSelection = concessionSelection;
    }

    public double calculateTotalPrice() {
        double totalPrice = 9.99;

        movieSelection.chooseMovieOption();
        try {
            int input = scanner.nextInt();
            totalPrice *= input;
        } catch (IllegalArgumentException err) {
            System.out.println("Give me a valid number please");
        }

        double popcornPrice = 4.99;
        if (concessionSelection.choosePopcorn()) totalPrice += popcornPrice;
        
        double sodaPrice = 3.99;
        if (concessionSelection.chooseSoda()) totalPrice += sodaPrice;

        return totalPrice;
    }
}
