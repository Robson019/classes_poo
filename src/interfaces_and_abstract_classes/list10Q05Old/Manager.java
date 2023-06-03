package interfaces_and_abstract_classes.list10Q05Old;

public class Manager extends Employee {
    private String department;

    public Manager(String name, String cpf, String birthdate, double salary, String department) {
        super(name, cpf, birthdate, salary);
        setDepartment(department);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void setSalary(double salary) {
        super.setSalary(salary + 1500);
    }
}
