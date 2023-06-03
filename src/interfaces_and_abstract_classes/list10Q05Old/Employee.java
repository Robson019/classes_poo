package interfaces_and_abstract_classes.list10Q05Old;

public class Employee extends People {
    private double salary;

    public Employee(String name, String cpf, String birthdate, double salary) {
        super(name, cpf, birthdate);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
