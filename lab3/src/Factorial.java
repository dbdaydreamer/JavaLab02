public class Factorial {
    static void main(String[] args) {
        System.out.println("n\tn!");
        System.out.println("------------------------------");

        for (int n = 1; n <= 20; n++) {
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.println(n + "\t" + factorial);
        }
    }
}

// Факториал числа 100 является очень длинным числом, которое не поместится в формат int или long из-за их ограничений в 32 и 64 бита,
// то есть проблемы могут возникнуть из-за переполнения обычных типов данных.