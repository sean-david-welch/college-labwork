import java.util.Scanner;
import java.util.InputMismatchException;

public class LeapYearApp {
    public static void main(String[] args) {
        LeapYear leapYear = new LeapYear();

        // Instructor note: used try catch block to avoid input errors
        // also this syntax avoids the need to close scanner in finally block
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a year to check if it is a leap year: ");
            int userInput = scanner.nextInt();

            leapYear.setInputYear(userInput);

            if (leapYear.getLeapYear()) {
                System.out.println(userInput + " is a leap year!");
            } else {
                System.out.println(userInput + " is not a leap year!");
            }
        } catch (InputMismatchException err) {
            System.out.println("Please enter a valid integer.");
        }
    }
}