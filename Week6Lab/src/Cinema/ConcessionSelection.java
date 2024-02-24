package Cinema;

import java.util.Scanner;

public class ConcessionSelection {
    private final Scanner scanner;
    private SodaOptions selectedSoda;

    public enum SodaOptions { COKE, SPRITE, FANTA }

    public ConcessionSelection(Scanner scanner) {
        this.scanner = scanner;
    }

    public SodaOptions getSelectedSoda() {
        return selectedSoda;
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
                selectedSoda = SodaOptions.valueOf(sodaChoice);
                validSodaChoice = true;
            } catch (IllegalArgumentException err) {
                System.out.println("Invalid soda choice. Please try again.");
            }
        }
    }

    public boolean choosePopcorn() {
        System.out.println("Would you like to buy some popcorn? (yes/no)");

        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Please just tell me yes or no :/");
            }
        }
    }

    public boolean chooseSoda() {
        System.out.println("Would you like to purchase a soda? (yes/no)");

        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("yes")) {
                chooseSodaType();
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Please just tell me yes or no :/");
            }
        }
    }

}
