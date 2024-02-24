package org.labs.ticketprices;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketPriceApp {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hi Welcome to the really old and expensive movie theater, what film would you like to see:");
        } catch (InputMismatchException err) {
            System.out.println("Please provide valid input");
        }
    }
}