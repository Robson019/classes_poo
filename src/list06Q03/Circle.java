package list06Q03;

public class Circle {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1;
        }
    }

    public double area() {
        return 3.14*this.radius*this.radius;
    }

    public double perimeter() {
        return 2*3.14*this.radius;
    }
}
