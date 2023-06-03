package interfaces_and_abstract_classes.list10Q05Old;

import java.util.List;
import java.util.Scanner;

public class Utils {
    public static void q5Menu(Scanner scan, List<Employee> e, List<Manager> m) {
        boolean eRegistered = false, mRegistered = false;
        int opt;

        do {
            opt = getOpt(scan);

            if (opt == 1) {
                e.add(appendEmployee(scan));
                System.out.println("Funcionário cadastrado!");
                eRegistered = true;
            } else if (opt == 2) {
                Manager newManager = appendManager(scan, e);
                if (newManager != null) {
                    m.add(newManager);
                    System.out.println("Gerente cadastrado!");
                    mRegistered = true;
                    if (e.size() == 0) {
                        eRegistered = false;
                    }
                } else {
                    System.out.println("[ERRO] Funcionário não encontrado");
                }
            } else if (opt == 3 && eRegistered) {
                salaryEmployee(scan, e);
            } else if (opt == 4 && mRegistered) {
                salaryManager(scan, m);
            } else if (opt == 3 && !eRegistered) {
                System.out.println("[ERRO] Não há registros!");
            } else if (opt == 4 && !mRegistered) {
                System.out.println("[ERRO] Não há registros!");
            } else if (opt < 0 || opt > 4) {
                System.out.println("[ERRO] Opção inválida");
            }
        } while (opt != 0);
        System.out.println("Adeus");
    }

    public static void salaryManager(Scanner scan, List<Manager> m) {
        boolean found = false;
        System.out.print("Procure por CPF: ");
        String findCpf = scan.next();

        for (Manager myManager :m) {
            if (myManager.getCpf().equals(findCpf)) {
                System.out.println(myManager.getName()+" salary: R$"+myManager.getSalary());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("[ERRO] Gerente não encontrado");
        }
    }

    public static void salaryEmployee(Scanner scan, List<Employee> e) {
        boolean found = false;
        System.out.print("Procure por CPF: ");
        String findCpf = scan.next();

        for (Employee myEmployee :e) {
            if (myEmployee.getCpf().equals(findCpf)) {
                System.out.println(myEmployee.getName()+" salary: R$"+myEmployee.getSalary());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("[ERRO] Funcionário não encontrado");
        }
    }

    public static Employee promoteEmployee(Scanner scan, List<Employee> e) {
        System.out.print("Procure por CPF: ");
        String findCpf = scan.next();

        for (Employee myEmployee :e) {
            if (myEmployee.getCpf().equals(findCpf)) {
                e.remove(myEmployee);
                return myEmployee;
            }
        }

        return null;
    }

    public static Manager appendManager(Scanner scan, List<Employee> e) {
        Employee myEmployee = promoteEmployee(scan, e);
        if (myEmployee != null) {
            System.out.print("Digite o departamento: ");
            scan.nextLine();
            String department = scan.nextLine();

            Manager m = new Manager(myEmployee.getName(), myEmployee.getCpf(), myEmployee.getBirthdate(), myEmployee.getSalary(), department);

            return m;
        }
        return null;
    }

    public static Employee appendEmployee(Scanner scan) {
        System.out.print("Digite nome: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.print("Digite o cpf: ");
        String cpf = scan.next();
        System.out.print("Digite o nascimento: ");
        String birthdate = scan.next();
        System.out.print("Digite o salário: R$");
        double salary = scan.nextDouble();

        Employee e = new Employee(name, cpf, birthdate, salary);

        return e;
    }

    public static int getOpt(Scanner scan) {
        int opt;
        System.out.print("Menu\n1. Adicionar funcionário\n2. Adicionar gerente\n3. Obter salário de funcionário\n4. Obter salário de gerente\n0. SAIR\nOpção: ");
        opt = scan.nextInt();
        return opt;
    }
}
