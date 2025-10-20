public class Pi {
    public static void main() {
        double pi = 0.0;
        int firstCorrectIndex = -1;
        double target = 3.14159;

        System.out.println("Шаг\tПриближенное π");

        for (int k = 1; k <= 5000000; k++) {
            double calc = 4.0 * Math.pow(-1, k + 1) / (2 * k - 1);
            pi += calc;

            if (k < 220000 && k % 20000 == 0) {
                System.out.println(k + "\t" + pi);
            }

            if (Math.abs(pi - target) < 0.0000005) {
                firstCorrectIndex = k;
                System.out.println("π сошлось на шаге: " + firstCorrectIndex);
                System.out.println("Приближённое значение: " + pi);
                break;
            }
        }

        if (firstCorrectIndex == -1) {
            System.out.println("π не сошёлся");
        }
    }
}
