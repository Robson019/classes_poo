package list08Q1;

public class Teacher extends People {
    private double salary;

    public Teacher(String name, String cpf, String birthDate, double salary) {
        super(name, cpf, birthDate);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
