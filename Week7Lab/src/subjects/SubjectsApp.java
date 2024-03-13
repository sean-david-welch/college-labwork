package subjects;

/*
 Question 1:
 Create an application that asks a user to enter how many subjects they have.
 The application should then ask the user to enter the results for each subject.
 Store these results in an array and print them back to the user
 along with their overall average and grade for each module.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubjectsApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Subjects subjects = new Subjects(scanner);

            int maxRetries = 3;
            boolean success = false;

            while (!success && maxRetries > 0) {
                try {
                    int averageGrade = subjects.collectSubjectsData();
                    System.out.println("-----------------------");
                    System.out.printf("Average Grade: %s%n", averageGrade);
                    success = true;
                } catch (Exception err) {
                    System.out.println("Error: " + err.getMessage());
                    System.out.println("Try again!");
                    maxRetries--;
                }
            }

        } catch (InputMismatchException err) {
            System.out.println("An error was made along the way, please try again: " + err);
        }
    }
}

