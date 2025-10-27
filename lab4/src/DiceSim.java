import java.util.Random;

public class DiceSim {
    public static void main(String[] args) {
        int[] counts = new int[13];

        var random = new Random();
        int total_rolls = 36000000;

        for (int i = 0; i < total_rolls; i++) {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int sum = dice1 + dice2;
            counts[sum]++;
        }

        System.out.println(" Summ | Ammount ");
        for (int sum = 2; sum <= 12; sum++) {
            System.out.printf("%5d | %10d%n",sum, counts[sum]);
        }
    }
}
