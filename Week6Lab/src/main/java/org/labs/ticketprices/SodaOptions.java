package org.labs.ticketprices;

public enum SodaOptions {
    COKE(1), SPRITE(2), FANTA(3);

    private final int choice;

    SodaOptions(int choice) {
        this.choice = choice;
    }

    public int getChoice(){
        return choice;
    }

    public static SodaOptions sodaOptions(int choice) {
        for(SodaOptions option: SodaOptions.values()) {
            if (option.getChoice() == choice) return option;
        }
        throw new IllegalArgumentException("We dont serve that here, please choose from: Coke(1), Sprite(2), Fanta(3)");
    }
}
