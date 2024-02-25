package grades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class SubjectList {
    private final Scanner scanner;

    public enum SubjectOptions{
        MATH, PHYSICS, BIOLOGY, HISTORY, RELIGION, PROGRAMMING, ACCOUNTING, FINANCE
    }

    public SubjectList(Scanner scanner) { this.scanner = scanner; }

    public List<String> chooseSubjectOptions(){
        out.println("What Subjects do you take? Please give them to me in a list :)");
        for (SubjectOptions subjectOptions : SubjectOptions.values()) {
            out.println(subjectOptions.name());
        }

        List<String> chosenSubjects = new ArrayList<>();

        while (true) {
            try {
                String inputLine = scanner.nextLine();
                String[] subjects = inputLine.split("[,\\s]+");


                for (String subject : subjects) {
                    try {
                        SubjectOptions.valueOf(subject.toUpperCase());
                        chosenSubjects.add(subject);
                    } catch (IllegalArgumentException err) {
                        out.println(subject + " is not a valid subject, try again!");
                    }
                }

                if (this.confirmSubjectChoice(chosenSubjects)) {
                    out.println("Subject choices confirmed!");
                    break;
                } else {
                    out.println("Subjects not confirmed. Please try again.");
                }
            } catch (IllegalArgumentException err) {
                out.println("Some of those subjects are unavailable! Please try again :)");
                for (SubjectOptions subjectOptions : SubjectOptions.values()) {
                    out.println(subjectOptions.name());
                }
            }
        }

        return chosenSubjects;
    }

    private boolean confirmSubjectChoice(List<String> chosenSubjects) {
        out.println("Chosen subjects: " + chosenSubjects + "." + "Is this list correct? (y/n)");

        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                out.println("Input is not valid. Please confirm (y/n)!");
            }
        }
    }
}
