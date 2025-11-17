public class RationalTest {
    public static void main(String[] args) {
        Rational r1 = new Rational(2, -4);
        Rational r2 = new Rational(3, 11);
        Rational r3 = new Rational(0, 1);
        Rational r4 = new Rational();

        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("r3: " + r3);
        System.out.println("r4: " + r4);

        Rational sum = Rational.add(r1, r2);
        Rational diff = Rational.subtract(r1, r2);
        Rational prod = Rational.multiply(r1, r2);
        Rational quot = Rational.divide(r1, r2);

        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + diff);
        System.out.println("Произведение: " + prod);
        System.out.println("Частное: " + quot);
        System.out.println("Дробь в виде a/b: " + sum.toFractionString());
        System.out.println("Дробь в виде с плавающей точкой: " + sum.toDecimalString(5));
    }
}
