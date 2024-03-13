package guessing;

/*
 Question 2
 Alter the guessing game application so that every time it plays the user is asked do they want to play again.
 Depending on what the user enters the application should keep going until they wish to stop.
 Bonus: store the user guesses and return them to the user when they finish or win.
 Note this may necessitate the creation of a large blank array
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public  class GuessingApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Guessing guessing = new Guessing(scanner);

            boolean playAgain = true;
            System.out.println("Try guess the same number as the computer... " +
                    "Pick a random number between 1 and 10: ");

            while (playAgain) {
                guessing.initGuessingGame();

                System.out.println("Would you like to play again? (y/n): ");
                String userInput = scanner.nextLine().toLowerCase();

                if (userInput.equals("n") || userInput.equals("no")) {
                    System.out.println("Okay, bye!");
                    playAgain = false;
                } else if (!userInput.equals("y") && !userInput.equals("yes")) {
                    System.out.println("Input is not valid. Please confirm with (y/n)!");
                }
            }
        } catch (InputMismatchException err) {
            System.out.println("An error was made along the way, please try again: " + err);
        }
    }
}