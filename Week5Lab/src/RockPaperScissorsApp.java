import java.util.InputMismatchException;
import java.util.Scanner;

public class RockPaperScissorsApp {
    public static void main(String[] args) {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();

        try (Scanner scanner = new Scanner(System.in)) {
            for (int attempt = 1; attempt <= 3; attempt++) {
                System.out.println("Enter your choice in number format: Rock(1), Paper(2), Scissors(3)");
                int userInput = scanner.nextInt();

                if (userInput < 1 || userInput > 3) {
                    System.out.println("Invalid choice. Please select from 1 (Rock), 2 (Paper), or 3 (Scissors).");
                    attempt--;
                    continue;
                }

                String result = rockPaperScissors.play(userInput);
                System.out.println(result);

                if (result.contains("You Win!")) {
                    System.out.println("Congratulations, you win!");
                    break;
                }
            }

        } catch (InputMismatchException err) {
            System.out.println("Please provide a valid integer from the options :{1, 2, 3}");
        }
    }
}