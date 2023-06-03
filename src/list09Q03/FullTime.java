package list09Q03;

public class FullTime extends Worker {
    public FullTime(String name, String register, double salary, int age, String address) {
        super(name, register, salary, age, address);
    }

    @Override
    public double getSalary() {
        if (super.getAge() <= 30) {
            return super.getSalary() * 116/100;
        }
        return super.getSalary() * 125/100;
    }
}
