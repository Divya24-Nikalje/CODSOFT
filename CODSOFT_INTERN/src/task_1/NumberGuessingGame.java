package task_1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_ATTEMPTS = 10;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        int totalRounds = 0;
        int totalWins = 0;

        boolean playAgain;
        do {
            playRound();
            totalRounds++;

            if (askIfWon()) {
                totalWins++;
            }
            playAgain = askToPlayAgain();
        } while (playAgain);

        displayFinalScore(totalRounds, totalWins);
    }

    private static void playRound() {
        int numberToGuess = generateRandomNumber();
        int attemptsLeft = MAX_ATTEMPTS;
        boolean guessedCorrectly = false;

        System.out.printf("Guess the number between %d to %d. You have %d attempts.\n", LOWER_BOUND, UPPER_BOUND, MAX_ATTEMPTS);

        while (attemptsLeft > 0 && !guessedCorrectly) {
            System.out.printf("You have %d attempts left. Enter your guess: ", attemptsLeft);
            int userGuess = getUserGuess();

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number correctly!");
                guessedCorrectly = true;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            attemptsLeft--;
        }

        if (!guessedCorrectly) {
            System.out.printf("Sorry, you've run out of attempts. The correct number was %d.\n", numberToGuess);
        }
    }

    private static int generateRandomNumber() {
        return random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
    }

    private static int getUserGuess() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt();
    }

    private static boolean askToPlayAgain() {
        System.out.print("Do you want to play another round? (yes/no): ");
        String response = scanner.next().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
    
    private static boolean askIfWon() {
        System.out.print("Did you win this round? (yes/no): ");
        String response = scanner.next().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    private static void displayFinalScore(int totalRounds, int totalWins) {
        System.out.println(".....Game Over!.....");
        System.out.printf("Total Rounds Played: %d\n", totalRounds);
        System.out.printf("Total Rounds Won: %d\n", totalWins);
    }    
}
