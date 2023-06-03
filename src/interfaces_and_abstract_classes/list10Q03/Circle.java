package interfaces_and_abstract_classes.list10Q03;

import interfaces_and_abstract_classes.GeometricObject;

public class Circle implements GeometricObject {
    private double pi;
    private double radius;

    public Circle(double pi, double radius) {
        setPi(pi);
        setRadius(radius);
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return (this.pi * this.radius * this.radius);
    }

    @Override
    public double calculatePerimeter() {
        return (2 * this.pi * this.radius);
    }
}
