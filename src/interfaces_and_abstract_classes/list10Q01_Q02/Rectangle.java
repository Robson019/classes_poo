package interfaces_and_abstract_classes.list10Q01_Q02;

import interfaces_and_abstract_classes.GeometricObject;

public class Rectangle implements GeometricObject {
    private double base;
    private double height;

    public Rectangle(double base, double height) {
        setBase(base);
        setHeight(height);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return this.base * this.height;
    }

    @Override
    public double calculatePerimeter() {
        return (2 * this.base) + (2 * this.height);
    }
}
