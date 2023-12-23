import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalSubjects = 5; // Assuming there are five subjects, modify as needed
        int subjectMarks[] = new int[totalSubjects];

        for (int i = 0; i < totalSubjects; i++) {
            int marks;
            do {
                System.out.println("Enter marks for Subject " + (i + 1) + ": ");
                marks = sc.nextInt();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid input! Marks should be between 0 and 100.");
                }
            } while (marks < 0 || marks > 100);

            subjectMarks[i] = marks;
        }

        boolean isFailed = false;
        for (int marks : subjectMarks) {

            if (marks < 35) {
                isFailed = true;
                break;
            }
        }

        if (isFailed) {
            System.out.println("Marks in one or more subject are less than 35. \n Grade: ");
        } else {
            // Calculate total marks
            int totalMarks = 0;
            for (int marks : subjectMarks) {
                totalMarks += marks;
            }

            // Calculate average percentage
            double averagePercentage = (double) totalMarks / totalSubjects;

            // Determine the grade based on the average percentage
            String grade;
            if (averagePercentage >= 90) {
                grade = "A+";
            } else if (averagePercentage >= 75) {
                grade = "A";
            } else if (averagePercentage >= 60) {
                grade = "B";
            } else if (averagePercentage >= 50) {
                grade = "C";
            } else if (averagePercentage >= 35) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Display the entered marks, total marks, average percentage, and the
            // corresponding grade
            System.out.println("Results:");
            System.out.println("Total Marks: " + totalMarks);
            System.out.printf("Average Percentage: %.2f \n", averagePercentage);
            System.out.println("Grade: " + grade);
        }

        sc.close();
    }
} 