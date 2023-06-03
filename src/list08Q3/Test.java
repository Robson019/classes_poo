package list08Q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<Employee> e = new ArrayList();
        List<Manager> m = new ArrayList();

        Scanner scan = new Scanner(System.in);

        q3Menu(scan, e, m);
    }

    public static void q3Menu(Scanner scan, List<Employee> e, List<Manager> m) {
        int opt, eRegisters = 0, mRegisters = 0;
        boolean eRegistered = false, mRegistered = false;
        do {
            opt = getOpt(scan);
            if (opt == 1) {
                e.add(eRegisters, getNewEmployee(scan));
                if (e.get(eRegisters).getCpf() != null) {
                    eRegistered = true;
                    System.out.println("Employee registered");
                    eRegisters++;
                }
            } else if (opt == 2 && eRegistered) {
                Employee promotedEmployee = employeeSearchToTurnManager(scan, e);
                if (promotedEmployee != null) {
                    m.add(mRegisters, getNewManager(promotedEmployee));
                    mRegistered = true;
                    System.out.println("Manager registered");
                    mRegisters++;
                    eRegisters--;
                    if (eRegisters == 0) {
                        eRegistered = false;
                    }
                } else {
                    System.out.println("Employee not registered");
                }
            } else if (opt == 3 && eRegistered) {
                showEmployeeList(e);
            } else if (opt == 4 && mRegistered) {
                showManagerSalary(scan, m);
            } else if ((opt > 1 && opt < 4) && !eRegistered) {
                System.out.println("[ERROR] No employee registered");
            } else if (opt == 4 && !mRegistered) {
                System.out.println("[ERROR] No manager registered");
            } else if ((opt <= -1 || opt > 4) && opt != 0) {
                System.out.println("[ERROR] Invalid option");
            }
        } while (opt != 0);
        System.out.println("bye!");
    }

    public static void showManagerSalary(Scanner scan, List<Manager> m) {
        Manager searchedManager = managerSearch(scan, m);
        if (searchedManager != null) {
            System.out.println(searchedManager.getName()+" salary: R$"+searchedManager.getSalary());
        } else {
            System.out.println("Manager not registered");
        }
    }

    public static void showEmployeeList(List<Employee> e) {
        for(Employee actualE : e) {
            System.out.println("===============================");
            System.out.println("Name: "+actualE.getName()+" | CPF: "+actualE.getCpf()+"\nSalary: R$"+actualE.getSalary()+" | Birthdate: "+actualE.getBirthdate());
        }
    }

    public static Manager managerSearch(Scanner scan, List<Manager> m) {
        System.out.print("Manager CPF: ");
        String cpfSearch = scan.next();

        for (Manager myManager :m) {
            if (cpfSearch.equals(myManager.getCpf())) {
                return myManager;
            }
        }
        return null;
    }

    public static Employee employeeSearchToTurnManager(Scanner scan, List<Employee> e) {
        System.out.print("Employee CPF: ");
        String cpfSearch = scan.next();

        int removeIndex = 0;
        for (Employee myEmployee :e) {
            if (cpfSearch.equals(myEmployee.getCpf())) {
                e.remove(removeIndex);
                return myEmployee;
            }
            removeIndex++;
        }
        return null;
    }

    public static Manager getNewManager(Employee e) {
        Manager m = new Manager(e.getName(), e.getCpf(), e.getSalary(), e.getBirthdate());

        return m;
    }

    public static Employee getNewEmployee(Scanner scan) {
        Employee e;

        System.out.print("Employee name: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.print("Employee CPF: ");
        String cpf = scan.next();
        System.out.print("Employee salary: R$");
        double salary = scan.nextDouble();
        System.out.print("Employee birthdate: ");
        String birthdate = scan.next();


        e = new Employee(name, cpf, salary, birthdate);
        return e;
    }

    public static int getOpt(Scanner scan) {
        int opt;
        System.out.print("Menu\n1. Register employee\n2. Promote to manager\n3. Show employee list\n4. Show Manager salary\n0. EXIT\nSelect: ");
        opt = scan.nextInt();
        return opt;
    }
}
