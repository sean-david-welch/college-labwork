public class TicketPrices {
    private int userAge;
    private int ticketPrice;
    private int numberTickets;
    private int totalPrice;

    // getters
    public int getUserAge(){
        return userAge;
    }

    public int getNumberTickets(){
        return numberTickets;
    }

    public int getTotalPrice(){
        computeTicketPrice();
        return totalPrice;
    }

    // setters
    public void setUserAge(int userAge){
        if (userAge >= 0) {
            this.userAge = userAge;
        } else {
            System.out.println("Invalid age input. Age cannot be negative.");
        }
    }

    public void setNumberTickets(int numberTickets){
        if (numberTickets > 0) {
            this.numberTickets = numberTickets;
        } else {
            System.out.println("Invalid number of tickets. Must be positive.");
        }
    }

    // computations
    public void computeTicketPrice() {
        ticketPrice = (userAge < 18) ? 10 : 15;
    }

    public void computeTotalPrice() {
        computeTicketPrice();
        totalPrice = ticketPrice * numberTickets;
    }
}
