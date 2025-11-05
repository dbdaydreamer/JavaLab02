import java.util.Scanner;

public class FlyApp {
    public static void main() {
        boolean[] seats = new boolean[10];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Type 1 for business, 2 for economy class:");
            int choice = scanner.nextInt();

            if (choice == 1) {
                if (bookPlace(seats, 0, 4)) {
                    System.out.println("Business class is full. Would you like economy class? (1 - yes, 0 - no)");
                    if (scanner.nextInt() == 1) {
                        if (bookPlace(seats, 5, 9))
                            break;
                    } else break;
                }
            } else {
                if (bookPlace(seats, 5, 9)) {
                    System.out.println("Economy class is full. Would you like a seat in business class? (1 - yes, 0 - no)");
                    if (scanner.nextInt() == 1) {
                        if (bookPlace(seats, 0, 4))
                            break;
                    } else break;
                }
            }
        }

        System.out.println("The next flight is in 3 hours.");
        scanner.close();
    }

    static boolean bookPlace(boolean[] seats, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                System.out.println("Place " + (i + 1) + " reserved.");
                return false;
            }
        }
        return true;
    }
}