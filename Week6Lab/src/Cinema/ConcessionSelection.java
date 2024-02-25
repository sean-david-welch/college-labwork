package cinema;

import java.util.Scanner;

public class ConcessionSelection {
    private final Scanner scanner;

    public enum SodaOptions { COKE, SPRITE, PEPSI, FANTA }

    public ConcessionSelection(Scanner scanner) {
        this.scanner = scanner;
    }

    private void chooseSodaType() {
        System.out.println("Please choose a soda type:");
        for (SodaOptions option : SodaOptions.values()) {
            System.out.println(option.name());
        }

        boolean validSodaChoice = false;
        while (!validSodaChoice) {
            try {
                String sodaChoice = scanner.nextLine().toUpperCase();
                SodaOptions.valueOf(sodaChoice);
                validSodaChoice = true;
            } catch (IllegalArgumentException err) {
                System.out.println("We don't serve that here. We only have: coke, sprite, pepsi, fanta.");
            }
        }
    }

    public boolean choosePopcorn() {
        System.out.println("Would you like to buy some popcorn? (yes/no)");

        while (true) {
            try {
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("yes")) {
                    return true;
                } else if (input.equals("no")) {
                    return false;
                }
            } catch (IllegalArgumentException err) {
                System.out.println("Please just tell me yes or no :/");
            }
        }
    }

    public boolean chooseSoda() {
        System.out.println("Would you like to purchase a soda? (yes/no)");

        while (true) {
            try {
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("yes")) {
                    chooseSodaType();
                    return true;
                } else if (input.equals("no")) {
                    return false;
                }
            } catch (IllegalArgumentException err) {
                System.out.println("We dont sell that here. Please choose from: Coke, Sprite or Fanta!");
            }
        }
    }
}
