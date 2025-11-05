import java.util.Scanner;
import java.util.Random;

public class GameGuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var random = new Random();
        boolean Again;

        do {
            int number;
            int users_guess = 0;
            number = random.nextInt(1000) + 1;


            System.out.println("Guess the number between 1 and 1000.");

            while (users_guess != number) {
                System.out.print("Enter your guess: ");
                users_guess = scanner.nextInt();

                if (users_guess < number) {
                    System.out.println("Too small. Try again");
                } else if (users_guess > number) {
                    System.out.println("Too big. Try again.");
                } else {
                    System.out.println("Congratz! You've guessed the number");
                }
            }

            System.out.print("Wanna play again: ");
            String answer = scanner.next();
            Again = answer.equals("yes");
        } while (Again);

        System.out.println("Thx 4 da game!");
        scanner.close();
    }
}
