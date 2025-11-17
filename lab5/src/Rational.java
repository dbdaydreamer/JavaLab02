public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Делить на ноль нельзя");
        }

        int divider = divider(numerator, denominator);
        this.numerator = numerator / divider;
        this.denominator = denominator / divider;
    }


    public Rational() {
        this(0, 1);
    }

    private static int divider(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return divider(b, a % b);
    }

    public static Rational add(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator + r2.numerator * r1.denominator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

    public static Rational subtract(Rational r1, Rational r2) {
        int num = r1.numerator * r2.denominator - r2.numerator * r1.denominator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

    public static Rational multiply(Rational r1, Rational r2) {
        int num = r1.numerator * r2.numerator;
        int den = r1.denominator * r2.denominator;
        return new Rational(num, den);
    }

    public static Rational divide(Rational r1, Rational r2) {
        if (r2.numerator == 0) {
            System.out.println("Делить на ноль нельзя");
        }
        int num = r1.numerator * r2.denominator;
        int den = r1.denominator * r2.numerator;
        return new Rational(num, den);
    }

    public String toFractionString() {
        return numerator + "/" + denominator;
    }

    public String toDecimalString(int decimalPlaces) {
        double value = (double) numerator / denominator;
        String formatString = "%." + decimalPlaces + "f";
        return String.format(formatString, value);
    }

    @Override
    public String toString() {
        return toFractionString();
    }
}
//??
