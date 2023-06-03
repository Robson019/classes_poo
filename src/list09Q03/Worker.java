package list09Q03;

public class Worker {
    private String name;
    private String register;
    private double salary;
    private int age;
    private String address;

    public Worker(String name, String register, double salary, int age, String address) {
        setName(name);
        setRegister(register);
        setSalary(salary);
        setAge(age);
        setAddress(address);
    }

    public Worker(String name, String register, int age, String address) {
        setName(name);
        setRegister(register);
        setAge(age);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        if (register.length() != 4) {
            System.out.println("[ERROR] Register length error");
            this.register = null;
        } else {
            this.register = register;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            this.salary = 600;
        } else {
            this.salary = salary;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 17) {
            this.age = 18;
        } else {
            this.age = age;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
