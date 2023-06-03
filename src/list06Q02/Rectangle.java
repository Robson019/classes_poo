package list06Q02;

public class Rectangle {
    private double base;
    private double height;

    public Rectangle (double base, double height) {
        setBase(base);
        setHeight(height);
    }

    public void setBase(double base) {
        if (base > 0) {
            this.base = base;
        } else {
            this.base = 1;
        }
    }

    public double getBase() {
        return base;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            this.height = 1;
        }
    }

    public double getHeight() {
        return height;
    }

    public double area(double base, double height) {
        return base * height;
    }

    public double perimeter(double base, double height) {
        return 2*(base + height);
    }
}
