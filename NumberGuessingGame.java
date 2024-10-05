import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int roundNumber = 1;
        int totalScore = 0;

        while (playAgain) {
            System.out.println("\n--- Round " + roundNumber + " ---");
            int numberToGuess = new Random().nextInt(100) + 1;
            int attemptsLeft = 10;
            int roundScore = 0;
            boolean guessedCorrectly = false;

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess (1-100). Attempts left: " + attemptsLeft + ": ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                    if (guess < 1 || guess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    roundScore = attemptsLeft;
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }

            totalScore += roundScore;
            System.out.println("Your score for this round: " + roundScore);
            System.out.println("Total score: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainInput = scanner.nextLine().trim().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            } else {
                roundNumber++;
            }
        }

        System.out.println("\nThank you for playing! Final score: " + totalScore);
        scanner.close();
    }
}
 
