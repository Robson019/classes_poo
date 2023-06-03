package Lista10Q06;

public class Hourly extends Worker {
    private double hoursToWork;
    private double salaryPerHour;

    public Hourly(String name, String register, int age, String address, double hoursToWork, double salaryPerHour) {
        super(name, register, age, address);
        setHoursToWork(hoursToWork);
        setSalaryPerHour(salaryPerHour);
        setSalary(0);
    }

    public double getHoursToWork() {
        return hoursToWork;
    }

    public void setHoursToWork(double hoursToWork) {
        this.hoursToWork = hoursToWork;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @Override
    public void setSalary(double salary) {
        super.setSalary(this.hoursToWork * this.salaryPerHour);
    }
}
