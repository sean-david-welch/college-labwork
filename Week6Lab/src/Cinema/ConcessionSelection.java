package cinema;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class ConcessionSelection {
    private final Scanner scanner;

    public enum SodaOptions { COKE, SPRITE, PEPSI, FANTA }

    public ConcessionSelection(Scanner scanner) {
        this.scanner = scanner;
    }

    private List<String> chooseSodaType() {
        out.println("Please choose which soda(s) you would like");
        for (SodaOptions option : SodaOptions.values()) {
            out.println(option.name());
        }

        List<String> chosenSodas = new ArrayList<>();

        while (true) {
            try {
                String inputLine = scanner.nextLine();
                String[] sodas = inputLine.split("[,\\s]+");

                boolean validChoice = true;
                for (String soda: sodas) {
                    try {
                        SodaOptions.valueOf(soda.toUpperCase());
                        chosenSodas.add(soda);
                    } catch (IllegalArgumentException err) {
                        out.println(soda + " is not served here!");
                        validChoice = false;
                    }
                }

                if (validChoice) {
                    return chosenSodas;
                } else {
                    out.println("Please choose from the available options:");
                    for (SodaOptions option : SodaOptions.values()) {
                        out.println(option.name());
                    }
                }
            } catch (IllegalArgumentException err) {
                out.println("We don't serve that here. We only have: coke, sprite, pepsi, fanta.");
            }
        }
    }

    public int choosePopcorn() {
        out.println("Would you like to buy some popcorn? (y/n)");

        while (true) {
            try {
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("y") || input.equals("yes")) {
                    out.println("How many portions of popcorn would you like?: ");
                    if (scanner.hasNextInt()) {
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        return quantity;
                    } else {
                        out.println("Excuse me, can you tell me that again");
                        scanner.nextLine();
                    }
                } else if (input.equals("n") || input.equals("no")) {
                    return 0;
                } else {
                    out.println("Please just tell me y or n :/");
                }
            } catch (IllegalArgumentException err) {
                out.println("Please just tell me y or n :/");
            }
        }
    }

    public int chooseSodaQuantity() {
        out.println("Would you like to purchase a soda? (y/n)");

        int totalQuantity = 0;
        while (true) {
            try {
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("y") || input.equals("yes")) {
                    List<String> sodas = this.chooseSodaType();

                    for (String soda: sodas) {
                        out.println("How many " + soda + "s" + " would you like?");
                        int quantity = scanner.nextInt();
                        totalQuantity += quantity;
                    }

                    return totalQuantity;
                } else if (input.equals("n") || input.equals("no")) {
                    return 0;
                } else {
                    out.println("Please just tell me y or n :/");
                }
            } catch (IllegalArgumentException err) {
                out.println("That's not okay, try again!");
            }
        }
    }
}
