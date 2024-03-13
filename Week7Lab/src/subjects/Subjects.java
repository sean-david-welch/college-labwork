package subjects;

import java.util.Arrays;
import java.util.Scanner;

public class Subjects {
    private final Scanner scanner;

    public Subjects(Scanner scanner) {
        this.scanner = scanner;
    }

    public enum SubjectOptions{
        MATH, PHYSICS, BIOLOGY, HISTORY, RELIGION, PROGRAMMING, ACCOUNTING, FINANCE
    }

    private int chooseSubjectsNumber() {
        int chosenSubjects;

        while (true) {
            System.out.println("How many subjects do you take?");
            chosenSubjects = scanner.nextInt();

            if (chosenSubjects > 0 && chosenSubjects < 9) {
                scanner.nextLine();
                break;
            } else {
                System.out.println("Error: please choose from 1-8 subjects, try again!");
            }
        }
        return chosenSubjects;
    }

    private boolean validateSubjectOptions(String input) {
        for (SubjectOptions option: SubjectOptions.values()) {
            if (option.name().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

    private String[] chooseSubjectOptions(int numberSubjects) {
        System.out.printf("You're currently enrolled in %s subjects. Please list them below: %n", numberSubjects);

        for (SubjectOptions subjectOptions: SubjectOptions.values()) {
            System.out.println(subjectOptions.name());
        }

        String[] chosenSubjects = new String[numberSubjects];

        for(int i = 0; i < numberSubjects; i++) {
            System.out.println("Enter Subject " + (i + 1) + ": ");
            String input = scanner.nextLine();

            while (!validateSubjectOptions(input)) {
                System.out.println("Invalid Subject, please choose from an option in the aforementioned list");
                System.out.println("Enter Subject" + (i + 1) + ": ");
                input = scanner.nextLine();
            }

            chosenSubjects[i] = input;
        }

        return chosenSubjects;
    }

    private boolean confirmSubjectChoices(String[] chosenSubjects) {
        System.out.println("Chose Subjects: " + Arrays.toString(chosenSubjects) + " Is this correct: (y/n)");

        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else System.out.println("Input is not valid. Please confirm with (y/n)!");
        }
    }

    private int[] getSubjectResults(String[] chosenSubjects) {
        System.out.println("Enter your results for each subject...");
        int[] subjectResults = new int[chosenSubjects.length];

        for (int i = 0; i < chosenSubjects.length; i++) {
            System.out.println("What Grade did you get in: " + chosenSubjects[i]);
            while (true) {
                int grade = scanner.nextInt();
                scanner.nextLine();

                if (grade >= 0 && grade <= 100) {
                    subjectResults[i] = grade;
                    break;
                } else {
                    System.out.println("Please enter a valid grade between 0-100!");
                }
            }
        }

        return subjectResults;
    }

    private void displaySubjectsAndGrades(String[] chosenSubjects, int[] subjectResults) {
        if (chosenSubjects.length != subjectResults.length) {
            System.out.println("Mismatch in results and subjects data: length is not equal!");
            return;
        }

        System.out.printf("Here are your final results: %n");

        for (int i = 0; i < chosenSubjects.length; i++)
            System.out.printf("(Subject: %s, Result: %s) %n", chosenSubjects[i], subjectResults[i]);
    }

    private int getSubjectAverage(int[] subjectResults) {
        int sum = 0;

        for (int result: subjectResults) {
            sum += result;
        }

        return sum / subjectResults.length;
    }

    public int collectSubjectsData() {
        int averageGrade;

        while (true) {
            int numSubjects = chooseSubjectsNumber();
            String[] chosenSubjects = chooseSubjectOptions(numSubjects);

            if (confirmSubjectChoices(chosenSubjects)) {
                int[] subjectResults = getSubjectResults(chosenSubjects);
                displaySubjectsAndGrades(chosenSubjects, subjectResults);

                averageGrade = getSubjectAverage(subjectResults);
                break;
            } else {
                System.out.println("Let's restart the subject selection process.");
            }
        }

        return averageGrade;
    }
}