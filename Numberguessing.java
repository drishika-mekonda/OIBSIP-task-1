import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {

    public static void main(String[] args) {
        System.out.println("Hey pals, Let's play the guessing game.");
        System.out.println("Let me pick a number between 1 and 100, and you try to guess it.");

        Scanner sc= new Scanner(System.in);
        Random random = new Random();

        boolean playAgain;
        do {
            int score = playGame(random, sc);
            System.out.println("Your score for this round: " + score);

            System.out.println("Would you like to guess again? Yes/No");
            String playAgainStr = sc.next();
            playAgain = playAgainStr.equalsIgnoreCase("Yes");
        } while (playAgain);

        System.out.println("Thanks for playing. Goodbye.");
        
        sc.close();
    }

    static int playGame(Random random, Scanner scanner) {
        int compNum = random.nextInt(100) + 1;
        int personGuess;
        int guessingCount = 0;
        int score = 100;

        System.out.println();
        System.out.println("What is your first guess?");

        while (true) {
            personGuess = getUserInput(scanner);

            guessingCount++;

            if (personGuess == compNum) {
                System.out.println("You got it in " + guessingCount + " guesses! My number was " + compNum);
                break;
            }

            if (personGuess < compNum) {
                System.out.println("Your number is too low. Guess again:");
            } else {
                System.out.println("Your number is too high. Guess again:");
            }

            score -= 5;
        }

        System.out.println();
        return score;
    }

    static int getUserInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer:");
            scanner.next();
        }
        return scanner.nextInt();
    }
}