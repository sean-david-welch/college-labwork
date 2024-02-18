import java.util.Scanner;

public class LeapYearApp {
    public static void main(String[] args) {
        LeapYear leapYear = new LeapYear();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a year to check if it is a leap year: ");
        int userInput = scanner.nextInt();
        leapYear.setInputYear(userInput);

        if (leapYear.getLeapYear()) {
            System.out.println(userInput + " is a leap year!");
        } else {
            System.out.println(userInput + " is not a leap year!");
        }
    }
}