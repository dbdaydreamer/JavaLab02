import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your age:");
        int age = scanner.nextInt();

        String nickname;

        if (age < 18) {
            nickname = name + " Junior";

        } else if (age >= 18 && age <= 40) {
            nickname = name + " Pro";

        } else {
            nickname = name + " Boss";
        }

        System.out.println("New name: " + nickname);

        scanner.close();
    }
}
