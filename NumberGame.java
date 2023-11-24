import java.util.Scanner;
import java.util.Random;

public class Guessinggame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 10;
        int rounds = 3;
        int score = 0;

        System.out.println("Welcome to Number Game!");
        System.out.println("I will generate a random number between " + min + " and " + max + ".");
        System.out.println("You have to guess the number in " + maxAttempts + " attempts or less.");
        System.out.println("You will get one point for each correct guess.");
        System.out.println("We will play " + rounds + " rounds. Let's start!");

        for (int round = 1; round <= rounds; round++) {

            int number = random.nextInt(max - min + 1) + min;

            int guess = 0;

            int attempts = 0;

            System.out.println("\nRound " + round + ":");

            do {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("You got it! The number was " + number + ".");
                    score++;
                } else if (guess > number) {
                    System.out.println("Your guess is too high.");
                    if (attempts < maxAttempts) {
                        System.out.println("You have " + (maxAttempts - attempts) + " more attempts left.");
                    } else {
                        System.out.println("You ran out of attempts. The number was " + number + ".");
                    }
                } else {
                    System.out.println("Your guess is too low.");
                    if (attempts < maxAttempts) {
                        System.out.println("You have " + (maxAttempts - attempts) + " more attempts left.");
                    } else {
                        System.out.println("You ran out of attempts. The number was " + number + ".");
                    }
                }
            } while (guess != number && attempts < maxAttempts);
        }

        System.out.println("\nYour final score is " + score + "/" + rounds + ".");
        System.out.println("Thank you for playing the Number Game!");
    }
}
