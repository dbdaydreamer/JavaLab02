import java.util.Scanner;
public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the price of book:");
        float bookPrice = scanner.nextFloat();

        System.out.println("Enter the number of books you want to buy:");
        int bookCount = scanner.nextInt();

        System.out.println("Enter the discount percentage:");
        float discountPerc = scanner.nextFloat();

        float totalPrice = bookPrice * bookCount;
        float discount = totalPrice * (discountPerc / 100);
        float finalPrice = totalPrice - discount;

        System.out.println("Final price:" + finalPrice);

        if (finalPrice > 100) {
            System.out.println("You got sale!");
        }

        scanner.close();
    }
}
