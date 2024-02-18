import java.util.Scanner;

// instructor notes:
// compiled in terminal with : ❯ javac -d target src/GuessingGame.java src/GuessingGameApp.java
// run app with: ❯ java -cp target GuessingGameApp
public class GuessingGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GuessingGame guessingGame = new GuessingGame();

        guessingGame.setGeneratedNumber();

        boolean correctGuess = false;
        final int maxAttempts = 3;

        System.out.println("Pick a random number between 1 and 10: ");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("Attempt " + attempt + " of " + maxAttempts);

            int userInput = scanner.nextInt();
            guessingGame.setUserGuess(userInput);

            guessingGame.checkResult();
            correctGuess = guessingGame.getResult();

            if (correctGuess) {
                System.out.println("Correct! You are the winner!");
                break;
            } else if (attempt < maxAttempts) {
                System.out.println("Incorrect, try again!");
            } else {
                System.out.println("Incorrect, you lose!");
            }
        }

        if (!correctGuess) {
            System.out.println("The correct number was: " + guessingGame.getGeneratedNumber());
        }
    }
}
