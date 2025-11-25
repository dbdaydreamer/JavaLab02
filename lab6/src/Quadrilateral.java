package src;

class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getCoordX() {
        return x;
    }

    public double getCoordY() {
        return y;
    }

    @Override
    public String toString(){
        return String.format("(%.3f, %.3f)", x, y);
    }
}

class Quadrilateral {
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final Point pointD;

    public Quadrilateral(Point n1, Point n2, Point n3, Point n4) {
        this.pointA = n1;
        this.pointB = n2;
        this.pointC = n3;
        this.pointD = n4;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    @Override
    public String toString() {
        return String.format("Quadrilateral: \n Points: %s, %s, %s, %s",
                pointA, pointB, pointC, pointD);
    }
}

class Trapezoid extends Quadrilateral{

    public Trapezoid(Point n1, Point n2, Point n3, Point n4){
        super(n1, n2, n3, n4);
    }

    public double getArea(){
        double baseBot = Math.abs(getPointB().getCoordX() - getPointA().getCoordX());
        double baseTop = Math.abs(getPointC().getCoordX() - getPointD().getCoordX());
        double height = Math.abs(getPointA().getCoordY() - getPointD().getCoordY());
        return (baseBot + baseTop) * height / 2.0;
    }

    @Override
    public String toString() {
        return String.format("Trapezoid: %s %s %s %s | Area: %.2f",
                getPointA(), getPointB(), getPointC(), getPointD(), getArea());
    }
}

class Parallelogram extends Trapezoid {

    public Parallelogram(Point n1, Point n2, Point n3, Point n4) {
        super(n1, n2, n3, n4);
    }

    @Override
    public double getArea() {
        double base = Math.abs(getPointB().getCoordX() - getPointA().getCoordX());
        double height = Math.abs(getPointD().getCoordY() - getPointA().getCoordY());
        return base * height;
    }

    @Override
    public String toString() {
        return String.format("Parallelogram: %s %s %s %s | Area: %.2f",
                getPointA(), getPointB(), getPointC(), getPointD(), getArea());
    }
}

class Rectangle extends Parallelogram {

    public Rectangle(Point n1, Point n2, Point n3, Point n4) {
        super(n1, n2, n3, n4);
    }

    @Override
    public String toString() {
        return String.format("Rectangle: %s %s %s %s | Area: %.2f",
                getPointA(), getPointB(), getPointC(), getPointD(), getArea());
    }
}

class Square extends Rectangle {

    public Square(Point n1, Point n2, Point n3, Point n4) {
        super(n1, n2, n3, n4);
    }

    @Override
    public String toString() {
        return String.format("Square: %s %s %s %s | Area: %.2f",
                getPointA(), getPointB(), getPointC(), getPointD(), getArea());
    }
}

class Main {
   public static void main() {

       Quadrilateral quad = new Quadrilateral(
               new Point(0, 0), new Point(4, 1),
               new Point(5, 4), new Point(1, 3)
       );
       System.out.println(quad);
       System.out.println();

       Trapezoid trapezoid = new Trapezoid(
               new Point(0, 0), new Point(13, 5),
               new Point(9, 7), new Point(7, 5)
       );
       System.out.println(trapezoid);
       System.out.println();

       Parallelogram parallelogram = new Parallelogram(
               new Point(0, 0), new Point(6, 0),
               new Point(8, 4), new Point(2, 4)
       );
       System.out.println(parallelogram);
       System.out.println();

       Rectangle rectangle = new Rectangle(
               new Point(0, 0), new Point(8, 0),
               new Point(8, 5), new Point(0, 5)
       );
       System.out.println(rectangle);
       System.out.println();

       Square square = new Square(
               new Point(0, 0), new Point(5, 0),
               new Point(5, 5), new Point(0, 5)
       );
       System.out.println(square);
   }
//}
