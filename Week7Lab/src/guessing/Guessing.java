package guessing;

import java.util.Scanner;

public class Guessing {
    private final Scanner scanner;

    public Guessing(Scanner scanner) {
        this.scanner = scanner;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private int generateUserGuess() {
        int userGuess;

        while (true) {
            System.out.println("Try guess the same number as the computer... " +
                    "Pick a random number between 1 and 10: ");
            userGuess = scanner.nextInt();

            if (userGuess > 0 && userGuess < 11) {
                break;
            } else {
                System.out.println("Invalid Guess, must be greater than 0 and less than 10.");
            }
        }

        return userGuess;
    }

    private boolean checkResult(int userGuess, int generatedNumber) {
        if (userGuess == generatedNumber) {
            System.out.println("Correct, You Win");
        } else {
            System.out.println("Incorrect, try again!");
        }

        return userGuess == generatedNumber;
    }

    // public constructor method for private fields
    public void initGuessingGame() {
        int maxAttempt = 5;

        int randomNumber = generateRandomNumber();

        for (int attempt = 0; attempt <= maxAttempt; attempt++) {
            System.out.println("Attempt " + attempt + " of " + 5);

            int userGuess = generateUserGuess();
            boolean result = checkResult(userGuess, randomNumber);
        }
    }
}