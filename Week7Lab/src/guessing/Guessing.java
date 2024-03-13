package guessing;

import java.util.Arrays;
import java.util.Scanner;

public class Guessing {
    private final Scanner scanner;

    public Guessing(Scanner scanner) {
        this.scanner = scanner;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10) + 1;
    }

    private int generateUserGuess() {
        int userGuess;

        while (true) {
            userGuess = scanner.nextInt();
            scanner.nextLine();

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
            if (userGuess > generatedNumber) {
                System.out.println("Hint: Your guess was too high.");
            } else {
                System.out.println("Hint: Your guess was too low.");
            }
        }

        return userGuess == generatedNumber;
    }

    private int[] checkFinalResults(int[] userGuesses) {
        int length = userGuesses.length;

        for (int guess: userGuesses) {
            if (guess == 0) length--;
        }

        int[] finalResults = new int[length];

        System.arraycopy(userGuesses, 0, finalResults, 0, finalResults.length);

        return finalResults;
    }


    // public constructor method for private fields
    public void initGuessingGame() {
        int maxAttempt = 5;
        int currAttempt = 1;

        int randomNumber = generateRandomNumber();

        boolean guessCorrect = false;
        int[] userGuesses = new int[maxAttempt];

        while (currAttempt <= maxAttempt) {
            System.out.println("Attempt " + currAttempt + " of " + 5);
            System.out.println("-----------------------");

            int userGuess = generateUserGuess();
            userGuesses[currAttempt - 1] = userGuess;

            boolean result = checkResult(userGuess, randomNumber);

            if (result) {
                guessCorrect = true;
                break;
            } else {
                currAttempt++;
            }
        }

        if (!guessCorrect) {
            System.out.println("-----------------------");
            System.out.printf("You ran out of attempts! The number was: %s%n", randomNumber);
            System.out.println("-----------------------");
        }

        int[] finalResults = checkFinalResults(userGuesses);

        System.out.println("-----------------------");
        System.out.printf("User Guesses: %s%n", Arrays.toString(finalResults));
        System.out.println("-----------------------");
    }
}