import java.util.Scanner;

public class Retailer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        int productNumber;
        int quantity;

        System.out.println("Введите № товара 1-5. Введите 0 для завершения:");
        productNumber = scanner.nextInt();

        while (productNumber != 0) {
            System.out.println("Введите кол-во проданных единиц:");
            quantity = scanner.nextInt();

            double price = 0.0;
            switch (productNumber) {
                case 1:
                    price = 2.98;
                    break;
                case 2:
                    price = 4.50;
                    break;
                case 3:
                    price = 9.98;
                    break;
                case 4:
                    price = 4.49;
                    break;
                case 5:
                    price = 6.87;
                    break;
            }
            total += price * quantity;

            System.out.println("Введите № товара 1-5. Введите 0 для завершения:");
            productNumber = scanner.nextInt();
        }

        System.out.println("$" + total);
        scanner.close();
    }
}
