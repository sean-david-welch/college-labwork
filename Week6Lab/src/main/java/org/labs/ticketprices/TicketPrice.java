package org.labs.ticketprices;

public class TicketPrice {
    // Properties
    private int subTotal;
    private int ticketPrice;
    private boolean wantsPopcorn;
    private boolean withButter;
    private boolean wantsSoda;

    // Getters
    public int getSubTotal() {
        return subTotal;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public boolean isWantsPopcorn() {
        return wantsPopcorn;
    }

    public boolean isWithButter() {
        return withButter;
    }

    public boolean isWantsSoda() {
        return wantsSoda;
    }

    // Setters
    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setWantsPopcorn(boolean wantsPopcorn) {
        this.wantsPopcorn = wantsPopcorn;
    }

    public void setWithButter(boolean withButter) {
        this.withButter = withButter;
    }

    public void setWantsSoda(boolean wantsSoda) {
        this.wantsSoda = wantsSoda;
    }
}
