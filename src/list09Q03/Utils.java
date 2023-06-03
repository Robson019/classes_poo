package list09Q03;

import java.util.List;
import java.util.Scanner;

public class Utils {
    public static void q3Menu(Scanner scan, List<FullTime> f, List<Hourly> h) {
        int opt, fRegisters = 0, hRegisters = 0;
        boolean fRegistered = false, hRegistered = false;

        do {
            opt = getOpt(scan);
            if (opt == 1) {
                f.add(getNewFullTime(scan));
                if (f.get(fRegisters).getRegister() != null) {
                    fRegistered = true;
                    fRegisters++;
                    System.out.println("Full-time registered");
                } else {
                    System.out.println("[ERROR] Full-time not registered");
                }
            } else if (opt == 2) {
                h.add(getNewHourly(scan));
                if (h.get(hRegisters).getRegister() != null) {
                    hRegistered = true;
                    hRegisters++;
                    System.out.println("Hourly registered");
                } else {
                    System.out.println("[ERROR] Hourly not registered");
                }
            } else if (opt == 3 & fRegistered) {
                FullTime fullTimer = getFullTimer(f, scan);
                if (fullTimer != null) {
                    getFullTimerSalary(fullTimer);
                }
            } else if (opt == 4 & hRegistered) {
                Hourly hourly = getHourly(h, scan);
                if (hourly != null) {
                    getHourlySalary(hourly);
                }
            } else if (opt == 5 & fRegistered) {
                FullTime fullTimer = getFullTimer(f, scan);
                if (fullTimer != null) {
                    getFullTimerSheet(fullTimer);
                }
            } else if (opt == 6 & hRegistered) {
                Hourly hourly = getHourly(h, scan);
                if (hourly != null) {
                    getHourlySheet(hourly);
                }
            } else if (opt == 7 & fRegistered) {
                getRichestInFullTime(f);
            } else if (opt == 8 & hRegistered) {
                getOldestInHourly(h);
            } else if ((opt > 1 && opt % 2 == 1 && opt <= 8) && !fRegistered) {
                System.out.println("[ERROR] No full-time worker registered");
            } else if ((opt > 2 && opt % 2 == 0 && opt <= 8) && !hRegistered) {
                System.out.println("[ERROR] No hourly worker registered");
            } else if ((opt <= -1 || opt > 8) && opt != 0) {
                System.out.println("[ERROR] Invalid option");
            }
        } while(opt != 0);
        System.out.println("bye");
    }

    public static void getOldestInHourly(List<Hourly> h) {
        Hourly old = h.get(0);
        for (Hourly check :h) {
            if (check.getAge() > old.getAge()) {
                old = check;
            }
        }

        System.out.println(old.getName()+" has "+old.getAge());
    }

    public static void getRichestInFullTime(List<FullTime> f) {
        FullTime rich = f.get(0);
        for (FullTime check :f) {
            if (check.getSalary() > rich.getSalary()) {
                rich = check;
            }
        }

        System.out.println(rich.getName()+": R$"+rich.getSalary());
    }

    public static void getHourlySheet(Hourly worker) {
        System.out.println("Name: "+worker.getName()+" | Register: "+worker.getRegister());
        System.out.println("Salary: R$"+worker.getSalary()+" | Age: "+worker.getAge());
        System.out.println("Address: '"+worker.getAddress()+"'");
    }

    public static void getFullTimerSheet(FullTime worker) {
        System.out.println("Name: "+worker.getName()+" | Register: "+worker.getRegister());
        System.out.println("Salary: R$"+worker.getSalary()+" | Age: "+worker.getAge());
        System.out.println("Address: '"+worker.getAddress()+"'");
    }

    public static void getHourlySalary(Hourly worker) {
        System.out.println(worker.getName()+" salary: R$"+worker.getSalary());
    }

    public static void getFullTimerSalary(FullTime worker) {
        System.out.println(worker.getName()+" salary: R$"+worker.getSalary());
    }

    public static Hourly getHourly(List<Hourly> h, Scanner scan) {
        System.out.print("Type hourly register: ");
        String searchRegister = scan.next();

        for (Hourly check :h) {
            if (check.getRegister().equals(searchRegister)) {
                return check;
            }
        }

        System.out.println("Worker not registered");
        return null;
    }

    public static FullTime getFullTimer(List<FullTime> f, Scanner scan) {
        System.out.print("Type full-time register: ");
        String searchRegister = scan.next();

        for (FullTime check :f) {
            if (check.getRegister().equals(searchRegister)) {
                return check;
            }
        }

        System.out.println("Worker not registered");
        return null;
    }

    public static Hourly getNewHourly(Scanner scan) {
        System.out.print("Worker name: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.print("Worker register: ");
        String register = scan.next();
        System.out.print("Worker age: ");
        int age = scan.nextInt();
        System.out.print("Worker address: ");
        scan.nextLine();
        String address = scan.nextLine();
        System.out.print("Hours worked: ");
        double hours = scan.nextDouble();
        System.out.print("Worker salary per hour: R$");
        double salaryPerHour = scan.nextDouble();

        Hourly h = new Hourly(name, register, age, address, hours, salaryPerHour);
        return h;
    }

    public static FullTime getNewFullTime(Scanner scan) {
        System.out.print("Worker name: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.print("Worker register: ");
        String register = scan.next();
        System.out.print("Worker salary: R$");
        double salary = scan.nextDouble();
        System.out.print("Worker age: ");
        int age = scan.nextInt();
        System.out.print("Worker address: ");
        scan.nextLine();
        String address = scan.nextLine();

        FullTime f = new FullTime(name, register, salary, age, address);
        return f;
    }

    public static int getOpt(Scanner scan) {
        int opt;
        System.out.print("Menu\n1. Register full-time worker\n2. Register hourly worker\n3. Get full-time salary\n4. Get hourly salary\n5. Show full-time worker\n6. Show hourly worker\n7. Show richest full-time worker\n8. Show oldest hourly worker\n0. EXIT\nSelect: ");
        opt = scan.nextInt();
        return opt;
    }
}

