package list09Q01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<Employee> e = new ArrayList();
        List<Manager> m = new ArrayList();

        Scanner scan = new Scanner(System.in);

        q1Menu(scan, e, m);
    }

    public static void q1Menu(Scanner scan, List<Employee> e, List<Manager> m) {
        int opt, eRegisters = 0, mRegisters = 0;
        boolean eRegistered = false, mRegistered = false;

        do {
            opt = getOpt(scan);
            if (opt == 1) {
                e.add(eRegisters, getNewEmployee(scan));
                if (e.get(eRegisters).getCpf() != null) {
                    eRegistered = true;
                    eRegisters++;
                    System.out.println("Employee registered");
                } else {
                    System.out.println("[Error] Employee not registered");
                }
            } else if (opt == 2) {
                Employee promotedEmployee = promoteEmployee(scan, e);
                if (promotedEmployee != null) {
                    m.add(mRegisters, getNewManager(scan, promotedEmployee));
                    mRegistered = true;
                    mRegisters++;
                    eRegisters--;
                    if (eRegisters == 0) {
                        eRegistered = false;
                    }
                    System.out.println("Manager registered");
                } else {
                    System.out.println("[Error] Manager not registered");
                }
            } else if (opt == 3 & eRegistered) {
                showEmployeeSalary(scan, e);
            } else if (opt == 4 & mRegistered) {
                showManagerSalary(scan, m);
            } else if (opt == 3 && !eRegistered) {
                System.out.println("[Error] No Employees registered");
            } else if (opt == 4 && !mRegistered) {
                System.out.println("[Error] No Managers registered");
            } else if ((opt <= -1 || opt > 4) && opt != 0) {
                System.out.println("[ERROR] Invalid option");
            }
        } while(opt != 0);
        System.out.println("bye");
    }

    public static void showManagerSalary(Scanner scan, List<Manager> m) {
        Manager myManager = findManager(scan, m);

        if (myManager != null) {
            System.out.println(myManager.getName()+"'s salary: R$"+myManager.getSalary());
        } else {
            System.out.println("[Error] Manager doesn't found");
        }
    }

    public static void showEmployeeSalary(Scanner scan, List<Employee> e) {
        Employee myEmployee = findEmployee(scan, e);

        if (myEmployee != null) {
            System.out.println(myEmployee.getName()+"'s salary: R$"+myEmployee.getSalary());
        } else {
            System.out.println("[Error] Employee doesn't found");
        }
    }

    public static Manager findManager(Scanner scan, List<Manager> m) {
        System.out.print("Manager CPF: ");
        String cpfSearch = scan.next();

        for (Manager myManager :m) {
            if (myManager.getCpf().equals(cpfSearch)) {
                return myManager;
            }
        }

        return null;
    }

    public static Employee findEmployee(Scanner scan, List<Employee> e) {
        System.out.print("Employee CPF: ");
        String cpfSearch = scan.next();

        for (Employee myEmployee :e) {
            if (myEmployee.getCpf().equals(cpfSearch)) {
                return myEmployee;
            }
        }

        return null;
    }

    public static Employee promoteEmployee(Scanner scan, List<Employee> e) {
        System.out.print("Employee CPF: ");
        String cpfSearch = scan.next();

        int positionAux = 0;
        for (Employee myEmployee :e) {
            if (myEmployee.getCpf().equals(cpfSearch)) {
                e.remove(positionAux);
                return myEmployee;
            }
            positionAux++;
        }

        return null;
    }

    public static Manager getNewManager(Scanner scan, Employee e) {
        System.out.print("Manager Department: ");
        String department = scan.next();
        Manager m = new Manager(e.getName(), e.getCpf(), e.getBirthdate(), e.getSalary(), department);

        return m;
    }

    public static Employee getNewEmployee(Scanner scan) {
        Employee e;

        System.out.print("Employee name: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.print("Employee CPF: ");
        String cpf = scan.next();
        System.out.print("Employee birthdate: ");
        String birthdate = scan.next();
        System.out.print("Employee salary: R$");
        double salary = scan.nextDouble();

        e = new Employee(name, cpf, birthdate, salary);
        return e;
    }

    public static int getOpt(Scanner scan) {
        int opt;
        System.out.print("Menu\n1. Register Employee\n2. Register Manager\n3. Show employee salary\n4. Show manager salary\n0. EXIT\nSelect: ");
        opt = scan.nextInt();
        return opt;
    }
}

