package list08Q3;

public class Manager extends Employee {
    public Manager(String name, String cpf, double salary, String birthdate) {
        super(name, cpf, salary + 2000, birthdate);
    }
}
