import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the total number of minutes spent on the computer:");
        int Minutes = scanner.nextInt();

        int days = Minutes / 1440;
        int hours = (Minutes % 1440) / 60;
        int minutes = Minutes % 60;

        System.out.println("You have spent on the computer:");

        double hoursDouble = Minutes / 60.0;
        double daysDouble = Minutes / 1440.0;
        System.out.println("Hours: " + String.format("%.2f", hoursDouble));
        System.out.println("Days: " + String.format("%.2f", daysDouble));

        System.out.println(Minutes + " minutes = " + days + " days " + hours + " hours " + minutes + " minutes");

        if (Minutes < 120) {
            System.out.println("Not bad! You can work a bit more.");
        } else if (Minutes <= 300) {
            System.out.println("Good workday!");
        } else {
            System.out.println("Take a break, that's enough coding!");
        }

        scanner.close();
    }
}
