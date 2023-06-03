package list09Q03;

public class Hourly extends Worker {
    private double hours;
    private double salaryPerHour;

    public Hourly(String name, String register, int age, String address, double hours, double salaryPerHour) {
        super(name, register, age, address);
        setHours(hours);
        setSalaryPerHour(salaryPerHour);
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @Override
    public double getSalary() {
        return this.hours*this.salaryPerHour;
    }
}
