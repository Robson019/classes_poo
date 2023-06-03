package list06Q04;

public class Imc {
    private String name;
    private double height;
    private double weight;

    public Imc(String name, double height, double weight) {
        setName(name);
        setHeight(height);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            this.height = 1;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = 1;
        }
    }

    public double calculateImc() {
        return this.weight/(this.height * this.height);
    }
}
