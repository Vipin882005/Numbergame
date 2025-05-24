       /* Task 3 (......Number Game......)*/

import java.util.Random;
import java.util.*;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println(".......Welcome to the Number Guessing Game.......");

        while (playAgain) {
            int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                String input = scanner.nextLine();

                if (!input.matches("\\d+")) {
                    System.out.println(" Please enter a valid number.");
                    continue;
                }

                int guess = Integer.parseInt(input);

                if (guess < LOWER_BOUND || guess > UPPER_BOUND) {
                    System.out.println(" Guess must be between " + LOWER_BOUND + " and " + UPPER_BOUND);
                    continue;
                }

                attemptsLeft--;

                if (guess == targetNumber) {
                    System.out.println(" Congratulations! You guessed the number.");
                    totalScore += attemptsLeft + 1; 
                    guessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println(" Too low!");
                } else {
                    System.out.println(" Too high!");
                }

                System.out.println(" Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was : " + targetNumber);
            }

            roundsPlayed++;
            System.out.print("\nDo you want to play another round? (yes/no) : ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\n....Game Over....");
        System.out.println("Rounds played : " + roundsPlayed);
        System.out.println("Total score : " + totalScore);
        System.out.println("Thanks for playing... ");

        scanner.close();
    }
}
