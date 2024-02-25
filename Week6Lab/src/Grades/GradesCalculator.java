package grades;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class GradesCalculator {
    private final Scanner scanner;
    private final SubjectList subjectList;

    public GradesCalculator(Scanner scanner, SubjectList subjectList) {
        this.scanner = scanner;
        this.subjectList = subjectList;
    }

    public int getAverageGrades() {
        int totalGrades = 0;
        List<String> chosenSubjects = subjectList.chooseSubjectOptions();

        for (String subject: chosenSubjects) {
            while (true) {
                out.println("What grade did you get in " + subject + "? (0-100):");
                int grade = scanner.nextInt();
                scanner.nextLine();

                if (grade >= 0 && grade <= 100) {
                    totalGrades += grade;
                    break;
                } else {
                    out.println("Please enter a valid grade between 0 and 100.");
                }
            }
        }

        return totalGrades / chosenSubjects.size();
    }
}
