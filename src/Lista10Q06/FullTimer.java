package Lista10Q06;

public class FullTimer extends Worker {
    public FullTimer(String name, String register, double salary, int age, String address) {
        super(name, register, salary, age, address);
    }

    @Override
    public void setSalary(double salary) {
        if (super.getAge() <= 30) {
            super.setSalary(salary * 116/100);
        } else {
            super.setSalary(salary * 125/100);
        }
    }
}
