package grades;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class GradesApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(in)) {
            out.println("Welcome to the principals office. " +
                    "Let's look at your graded to see whether or not you're suspended!");

            SubjectList subjectList = new SubjectList(scanner);
            GradesCalculator gradesCalculator = new GradesCalculator(scanner, subjectList);

            int averageGrade = gradesCalculator.getAverageGrades();

            if (averageGrade < 40) {
                out.println("Unfortunately, your average grade is below 40. " + averageGrade + " is an F. " +
                        " This means you're expelled.");
            } else if (averageGrade < 60) {
                out.println("Your average grade is below 60. " + averageGrade + " is a D. " +
                        "Improve it soon or you're dust.");
            } else if (averageGrade < 80) {
                out.println("Your average grade is satisfactory, " + averageGrade + "is a B. " +
                        "but there's room for improvement.");
            } else {
                out.println("Congratulations! Your average grade is excellent. " + averageGrade + " is an A." +
                        "I'm making you the class representative!");
            }
        } catch (InputMismatchException err) {
            out.println("An input error was made along the way. Try again!");
        }
    }
}
