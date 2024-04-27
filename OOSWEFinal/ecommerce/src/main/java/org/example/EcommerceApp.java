package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EcommerceApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            EcommerceService ecommerceService = new EcommerceService();
            EcommerceTUI ecommerceTUI = new EcommerceTUI(scanner, ecommerceService);

            while (true) {
                try {
                    ecommerceTUI.ecommerceController();

                    System.out.println("Enter 'quit'/'q' to exit or press Enter to continue.");
                    String input = scanner.nextLine();

                    if ("quit".equalsIgnoreCase(input) || "q".equalsIgnoreCase(input)) {
                        break;
                    }
                } catch (InputMismatchException err) {
                    System.out.println("Input is invalid, try again. Error: " + err.getMessage());
                    scanner.nextLine();
                } catch (Exception err) {
                    System.out.println("An error occurred, try again: " + err.getMessage());

                }
            }
        } catch (Exception err) {
            System.out.println("A critical error occurred, exiting the application: " + err.getMessage());
        }
    }
}
