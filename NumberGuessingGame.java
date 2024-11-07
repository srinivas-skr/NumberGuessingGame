import javax.swing.JOptionPane;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int totalScore = 0;
        int round = 1;
        int maxAttempts = 5;

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            boolean hasWon = false;

            JOptionPane.showMessageDialog(null, "Round " + round + ": Guess the number between 1 and 100.\nYou have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog("Attempt " + (attempts + 1) + ": Enter your guess:");

                // Check if the user pressed "Cancel" or closed the dialog
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game exited by user.");
                    System.exit(0);
                }

                int guess = 0;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number between 1 and 100.");
                    continue;
                }

                if (guess < 1 || guess > 100) {
                    JOptionPane.showMessageDialog(null, "Your guess must be between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                    int points = (maxAttempts - attempts + 1) * 10; // Points decrease with more attempts
                    totalScore += points;
                    JOptionPane.showMessageDialog(null, "You earned " + points + " points. Total score: " + totalScore);
                    hasWon = true;
                    break;
                } else if (guess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low.");
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is too high.");
                }
            }

            if (!hasWon) {
                JOptionPane.showMessageDialog(null, "You've used all attempts. The correct number was: " + numberToGuess);
            }

            int response = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Play Again", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.NO_OPTION) {
                playAgain = false;
            } else {
                round++;
            }
        }

        JOptionPane.showMessageDialog(null, "Game over. Your total score is: " + totalScore);
    }
}
