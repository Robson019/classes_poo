package list08Q3;

public class Employee {
    private String name;
    private String cpf;
    private double salary;
    private String birthdate;

    public Employee(String name, String cpf, double salary, String birthdate) {
        setName(name);
        setCpf(cpf);
        setSalary(salary);
        setBirthdate(birthdate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() != 14) {
            System.out.println("[ERROR] Invalid CPF");
            this.cpf = null;
        } else {
            this.cpf = cpf;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthDate) {
        if (birthDate.length() != 10) {
            System.out.println("[ERROR] Invalid birthdate");
        } else {
            this.birthdate = birthDate;
        }
    }
}
