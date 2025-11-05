public class Lab1 {
    public static void main(String[] args) {
        Kvadrat();
        System.out.println();
        Oval();
        System.out.println();
        Strela();
        System.out.println();
        Romb();
    }

    public static void Kvadrat() {
        int size = 8;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print("*");

                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    public static void Oval() {
        int width = 7;
        int height = 8;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0 || i == height - 1) && j > 0 && j < width - 1) {
                    System.out.print("*");
                } else if ((j == 0 || j == width - 1) && i > 0 && i < height - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void Strela() {
        int size = 4;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }

    public static void Romb() {
        int size = 5;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = size - 1; i >= 1; i--) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }


    }
}

