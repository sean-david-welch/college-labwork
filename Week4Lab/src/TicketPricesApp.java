import java.util.Scanner;

// instructor notes:
// compiled in terminal with: ❯ javac -d target src/TicketPrices.java src/TicketPricesApp.java
// run app with: ❯ java -cp target TicketPricesApp
public class TicketPricesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketPrices ticketPrices = new TicketPrices();

        System.out.println("Enter your age: ");
        int userAge = scanner.nextInt();
        ticketPrices.setUserAge(userAge);

        System.out.println("Enter number of ticket desired: ");
        int numberTickets = scanner.nextInt();
        ticketPrices.setNumberTickets(numberTickets);

        ticketPrices.computeTotalPrice();
        int totalPrice = ticketPrices.getTotalPrice();
        System.out.println("Total Price Due: €" + totalPrice);
    }
}