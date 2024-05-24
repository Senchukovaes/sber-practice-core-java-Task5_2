public class PaintExample {
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Circle c = new Circle(p1, 5.5);
        System.out.println("Площадь круга: " + c.area());
        System.out.println("Периметр круга: " + c.perimeter());
        c.draw();
        c.draw(Color.YELLOW);
        System.out.println();

        Point p2 = new Point(-4, 3);
        Rectangle r = new Rectangle(p2, 4.0, 7.0);
        System.out.println("Площадь прямоугольника: " + FigureUtil.area(r));
        System.out.println("Периметр прямоугольника: " + FigureUtil.perimeter(r));
        FigureUtil.draw(r);
        FigureUtil.draw(r, Color.WHITE);
        System.out.println();

        Point p3 = new Point(8, 16);
        Triangle t = new Triangle(p3, 3, 7);
        System.out.println("Площадь треугольника: " + t.area());
        System.out.println("Периметр треугольника: " + t.perimeter());
        t.draw();
        t.draw(Color.GREEN);
        System.out.println();

        Point p4 = new Point(-9, -10);
        Square s = new Square(p2, 7.0);
        System.out.println("Площадь квадрата: " + FigureUtil.area(s));
        System.out.println("Периметр квадрата: " + FigureUtil.perimeter(s));
        FigureUtil.draw(s);
        FigureUtil.draw(s, Color.RED);
        System.out.println();

    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
abstract class Figure {
    Point point;
    public Figure(Point point) {
        this.point = point;
    }
    public abstract double area();
    public abstract double perimeter();
}
class Circle extends Figure implements Drawable{
    double radius;
    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI*radius*radius;
    }
    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }
    public void draw() {
        System.out.println("Нарисован круг с центром в точке (" + point.x + ";" + point.y + ")");
    }
    public void draw(Color color) {
        System.out.println("Нарисован круг с центром в точке (" + point.x + ";" + point.y + ") цвета: " + color);
    }
}
class Rectangle extends Figure implements Drawable{
    double width;
    double height;
    public Rectangle(Point point, double width, double height) {
        super(point);
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        return width*height;
    }
    @Override
    public double perimeter() {
        return (width+height)*2;
    }
    public void draw() {
        System.out.println("Нарисован прямоугольник с координатами (" + point.x + ";" + point.y + ")");
    }
    public void draw(Color color) {
        System.out.println("Нарисован прямоугольник с координатами (" + point.x + ";" + point.y + ") цвета: " + color);
    }
}
//предусматриваются только равносторонние треугольники
class Triangle extends Figure implements Drawable{
    double edge;
    double height;
    public Triangle(Point point, double edge, double height) {
        super(point);
        this.edge = edge;
        this.height = height;
    }
    @Override
    public double area() {
        return 0.5*height*edge;
    }
    @Override
    public double perimeter() {
        return edge*3;
    }
    public void draw() {
        System.out.println("Нарисован треугольник с координатами (" + point.x + ";" + point.y + ")");
    }
    public void draw(Color color) {
        System.out.println("Нарисован треугольник с координатами (" + point.x + ";" + point.y + ") цвета: " + color);
    }
}

class Square extends Rectangle implements Drawable{
    double side;
    public Square(Point point, double side) {
        super(point, side, side);
    }
    public double area() {
        return side*side;
    }
    public double perimeter() {
        return side*4;
    }
    public void draw() {
        System.out.println("Нарисован квадрат с координатами (" + point.x + ";" + point.y + ")");
    }
    public void draw(Color color) {
        System.out.println("Нарисован квадрат с координатами (" + point.x + ";" + point.y + ") цвета: " + color);
    }
}
enum Color {
    RED,
    WHITE,
    BLUE,
    GREEN,
    BLACK,
    YELLOW
}
interface Drawable {
    void draw();
    void draw(Color color);
}
class FigureUtil {
    Figure figure;
    protected FigureUtil(Figure figure) {
        this.figure = figure;
    }
    static double area(Figure figure) {
        return figure.area();
    }
    static double perimeter(Figure figure) {
        return figure.perimeter();
    }
    static void draw(Drawable figure) {
        figure.draw();
    }
    static void draw(Drawable figure, Color color) {
        figure.draw();
    }
}
