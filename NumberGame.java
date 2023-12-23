import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        // Create an instance of the Scanner class for user input
        Scanner scanner = new Scanner(System.in);

        // Initialize a variable to store the user's score (rounds won)
        int score = 0;

        // Initialize variables to track score
        int totalRounds = 0;
        int totalAttempts = 0;

        // Outer loop for multiple rounds
        while (true) {
            // Specify the range
            int min = 1;
            int max = 100;

            // Create an instance of the Random class
            Random random = new Random();

            // Generate a random number within the specified range
            int randomNumber = random.nextInt(max - min + 1) + min;

            // Specify the maximum number of attempts
            int maxAttempts = 5;
            int attempts = 0;

            // Inner loop for the current round
            while (attempts < maxAttempts) {
                // Increment the number of attempts
                attempts++;

                // Prompt the user to enter their guess
                System.out.print("Guess the number between " + min + " and " + max + ": ");
                int userGuess = scanner.nextInt();

                // Display the user's guess
                System.out.println("Your guess: " + userGuess);

                // Compare the user's guess with the generated number and provide feedback
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    System.out.println("Number of attempts: " + attempts);
                    score++; // Increment the score for each round won
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
            }

            // Update total attempts and break out of the inner loop
            totalAttempts += attempts;

            // Check if the user reached the maximum attempts without guessing correctly
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: "
                        + randomNumber);
            }

            // Increment the total number of rounds
            totalRounds++;

            // Ask the user if they want to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            // Exit the outer loop if the user chooses not to play again
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        // Display the user's score
        System.out.println("Game Over! Your Score:" + score);
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Attempts: " + totalAttempts);

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
