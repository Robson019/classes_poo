package Lista10Q06;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static void q6Menu(Scanner scan, List<FullTimer> f, List<Hourly> h) {
        boolean fRegistered = false, hRegistered = false;
        int opt;

        do {
            opt = getOpt(scan, fRegistered, hRegistered);

            if (opt == 1) {
                FullTimer newFullTimer = appendFullTimer(scan);
                if (newFullTimer != null) {
                    f.add(newFullTimer);
                    System.out.println("Trabalhador integral cadastrado!");
                    fRegistered = true;
                }
            } else if (opt == 2) {
                Hourly newHourly = appendHourly(scan);
                if (newHourly != null) {
                    h.add(newHourly);
                    System.out.println("Trabalhador horista cadastrado!");
                    hRegistered = true;
                }
            } else if (opt == 3 && fRegistered) {
                fullTimerSalary(scan, f);
            } else if (opt == 4 && hRegistered) {
                hourlySalary(scan, h);
            } else if (opt == 5 && fRegistered) {
                fullTimerSheet(scan, f);
            } else if (opt == 6 && hRegistered) {
                hourlySheet(scan, h);
            } else if (opt == 7 && fRegistered) {
                fullTimerBiggestSalary(f);
            } else if (opt == 8 && hRegistered) {
                hourlyBiggestSalary(h);
            }
        } while (opt != 0);
        System.out.println("Adeus");
    }

    public static void hourlyBiggestSalary(List<Hourly> h) {
        String bName = h.get(0).getName();
        double bSalary = h.get(0).getSalary();

        for (Hourly myHourly :h) {
            if (myHourly.getSalary() > bSalary) {
                bSalary = myHourly.getSalary();
                bName = myHourly.getName();
            }
        }

        System.out.println("O maior salário é de "+bName+" que recebe R$"+bSalary);
    }

    public static void fullTimerBiggestSalary(List<FullTimer> f) {
        String bName = f.get(0).getName();
        double bSalary = f.get(0).getSalary();

        for (FullTimer myFullTimer :f) {
            if (myFullTimer.getSalary() > bSalary) {
                bSalary = myFullTimer.getSalary();
                bName = myFullTimer.getName();
            }
        }

        System.out.println("O maior salário é de "+bName+" que recebe R$"+bSalary);
    }

    public static void hourlySheet(Scanner scan, List<Hourly> h) {
        boolean found = false, checked = false;
        System.out.print("Procure por registro: ");
        String findRegister = "";
        try {
            findRegister = scan.next();
        } catch (Exception e) {
            System.out.println("[Erro] Campo inválido");
            scan.nextLine();
            checked = true;
        }

        if (!checked) {
            for (Hourly myHourly :h) {
                if (myHourly.getRegister().equals(findRegister)) {
                    System.out.println("Nome: "+myHourly.getName()+" | Registro: "+myHourly.getRegister());
                    System.out.println("Idade: "+myHourly.getAge()+" | Address: '"+myHourly.getAddress()+"'");
                    System.out.println("Horas trabalhadas/Salário por hora: "+myHourly.getHoursToWork()+"h/R$"+myHourly.getSalaryPerHour()+" | Salário: R$"+myHourly.getSalary());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("[ERRO] Trabalhador não encontrado");
            }
        }
    }

    public static void fullTimerSheet(Scanner scan, List<FullTimer> f) {
        boolean found = false, checked = false;
        System.out.print("Procure por registro: ");
        String findRegister = "";
        try {
            findRegister = scan.next();
        } catch (Exception e) {
            System.out.println("[Erro] Campo inválido");
            scan.nextLine();
            checked = true;
        }

        if (!checked) {
            for (FullTimer myFullTimer :f) {
                if (myFullTimer.getRegister().equals(findRegister)) {
                    System.out.println("Nome: "+myFullTimer.getName()+" | Registro: "+myFullTimer.getRegister());
                    System.out.println("Idade: "+myFullTimer.getAge()+" | Address: '"+myFullTimer.getAddress()+"'");
                    System.out.println("Salário: R$"+myFullTimer.getSalary());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("[ERRO] Trabalhador não encontrado");
            }
        }
    }

    public static void hourlySalary(Scanner scan, List<Hourly> h) {
        boolean found = false, checked = false;
        System.out.print("Procure por registro: ");
        String findRegister = "";
        try {
            findRegister = scan.next();
        } catch (Exception e) {
            System.out.println("[Erro] Campo inválido");
            scan.nextLine();
            checked = true;
        }

        if (!checked) {
            for (Hourly myHourly :h) {
                if (myHourly.getRegister().equals(findRegister)) {
                    System.out.println(myHourly.getName()+" salary: R$"+myHourly.getSalary());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("[ERRO] Trabalhador não encontrado");
            }
        }
    }

    public static void fullTimerSalary(Scanner scan, List<FullTimer> f) {
        boolean found = false, checked = false;
        System.out.print("Procure por registro: ");
        String findRegister = "";
        try {
            findRegister = scan.next();
        } catch (Exception e) {
            System.out.println("[Erro] Campo inválido");
            scan.nextLine();
            checked = true;
        }

        if (!checked) {
            for (FullTimer myFullTimer :f) {
                if (myFullTimer.getRegister().equals(findRegister)) {
                    System.out.println(myFullTimer.getName()+" salary: R$"+myFullTimer.getSalary());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("[ERRO] Trabalhador não encontrado");
            }
        }
    }

    public static Hourly appendHourly(Scanner scan) {
        boolean checked = false;
        String name = "", register = "", address = "";
        double hoursToWork = 0, salaryPerHour = 0;
        int age = 0;
        try {
            System.out.print("Digite o nome: ");
            scan.nextLine();
            name = scan.nextLine();
            System.out.print("Digite o registro: ");
            register = scan.next();
            System.out.print("Digite a idade: ");
            age = scan.nextInt();
            System.out.print("Digite o endereço: ");
            scan.nextLine();
            address = scan.nextLine();
            System.out.print("Digite as horas trabalhadas: ");
            hoursToWork = scan.nextDouble();
            System.out.print("Digite o salário por hora: R$");
            salaryPerHour = scan.nextDouble();
        } catch (Exception e) {
            System.out.println("[Erro] Campo inválido");
            scan.nextLine();
            checked = true;
        }

        if (!checked) {
            Hourly h = new Hourly(name, register, age, address, hoursToWork, salaryPerHour);

            return h;
        }

        return null;
    }

    public static FullTimer appendFullTimer(Scanner scan) {
        boolean checked = false;
        String name = "", register = "", address = "";
        double salary = 0;
        int age = 0;
        try {
            System.out.print("Digite o nome: ");
            scan.nextLine();
            name = scan.nextLine();
            System.out.print("Digite o registro: ");
            register = scan.next();
            System.out.print("Digite o salário: R$");
            salary = scan.nextDouble();
            System.out.print("Digite a idade: ");
            age = scan.nextInt();
            System.out.print("Digite o endereço: ");
            scan.nextLine();
            address = scan.nextLine();
        } catch (Exception e) {
            System.out.println("[Erro] Campo inválido");
            scan.nextLine();
            checked = true;
        }

        if (!checked) {
            FullTimer f = new FullTimer(name, register, salary, age, address);

            return f;
        }

        return null;
    }

    public static int getOpt(Scanner scan, boolean fRegistered, boolean hRegistered) {
        System.out.print("Menu\n1. Cadastrar trabalhador integral\n2. Cadastrar trabalhador horista\n3. Obter salário trabalhador integral\n4. Obter salário trabalhador horista\n5. Obter ficha trabalhador integral\n6. Obter ficha trabalhador horista\n7. Obter maior salário trabalhador integral\n8. Obter maior salário trabalhador horista\n0. SAIR\nOpção: ");
        int opt = -1;

        try {
            opt = scan.nextInt();
            if (opt < 0 || opt > 8) {
                throw new InputMismatchException();
            }
            if ((opt >= 3 && opt < 8 && opt % 2 != 0) && !fRegistered) {
                throw new ImpossivelVerificar();
            }
            if ((opt >= 4 && opt <= 8 && opt % 2 == 0) && !hRegistered) {
                throw new ImpossivelVerificar();
            }
        } catch (InputMismatchException e) {
            System.out.println("[Erro] Você digitou algo inválido");
            scan.nextLine();
        } catch (ImpossivelVerificar e) {
            System.out.println("[Erro] Lista vazia.");
        }

        return opt;
    }
}
