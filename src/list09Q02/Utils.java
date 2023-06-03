package list09Q02;

import java.util.Scanner;

public class Utils {
    public static void q2Menu(Scanner scan, Checking c, Savings s) {
        int opt;
        boolean cRegistered = false, sRegistered = false;

        do {
            opt = getOpt(scan);
            if (opt == 1 && !cRegistered) {
                c = getNewChecking(scan);
                if (c.getClientCpf() != null && c.getNumber() != null) {
                    cRegistered = true;
                    System.out.println("Checking registered");
                } else {
                    System.out.println("[ERROR] Checking not registered");
                }
            } else if (opt == 2 && !sRegistered) {
                s = getNewSavings(scan);
                if (s.getClientCpf() != null && s.getNumber() != null) {
                    sRegistered = true;
                    System.out.println("Savings registered");
                } else {
                    System.out.println("[ERROR] Savings not registered");
                }
            } else if (opt == 3 & cRegistered) {
                updateChecking(scan, c);
                System.out.println("Checking updated");
            } else if (opt == 4 & sRegistered) {
                updateSavings(scan, s);
                System.out.println("Savings updated");
            } else if (opt == 5 & cRegistered) {
                withdrawChecking(scan, c);
            } else if (opt == 6 & sRegistered) {
                withdrawSavings(scan, s);
            } else if (opt == 7 & cRegistered) {
                balanceChecking(c);
            } else if (opt == 8 & sRegistered) {
                balanceSavings(s);
            } else if (opt == 1 && cRegistered) {
                System.out.println("[ERROR] Checking already registered");
            } else if (opt == 2 && sRegistered) {
                System.out.println("[ERROR] Savings already registered");
            } else if ((opt > 1 && opt % 2 == 1 && opt <= 8) && !cRegistered) {
                System.out.println("[ERROR] Checking not registered");
            } else if ((opt > 2 && opt % 2 == 0 && opt <= 8) && !sRegistered) {
                System.out.println("[ERROR] Savings not registered");
            } else if ((opt <= -1 || opt > 8) && opt != 0) {
                System.out.println("[ERROR] Invalid option");
            }
        } while(opt != 0);
        System.out.println("bye");
    }

    public static void balanceSavings(Savings s) {
        System.out.println("Your balance is: R$"+s.getBalance());
    }

    public static void balanceChecking(Checking c) {
        System.out.println("Your balance is: R$"+c.getBalance());
    }

    public static void withdrawSavings(Scanner scan, Savings s) {
        System.out.print("Type a value: R$");
        double value = scan.nextDouble();

        s.withdraw(value);
    }

    public static void withdrawChecking(Scanner scan, Checking c) {
        System.out.print("Type a value: R$");
        double value = scan.nextDouble();

        c.withdraw(value);
    }

    public static void updateSavings(Scanner scan, Savings s) {
        s.update();
    }

    public static void updateChecking(Scanner scan, Checking c) {
        c.update(c.getTax());
    }

    public static Savings getNewSavings(Scanner scan) {
        System.out.print("Savings number: ");
        String number = scan.next();
        System.out.print("Client CPF: ");
        String cpf = scan.next();
        System.out.print("Savings tax: R$");
        double tax = scan.nextDouble();
        System.out.print("Savings balance: R$");
        double balance = scan.nextDouble();
        System.out.print("Bank name: ");
        scan.nextLine();
        String bank = scan.nextLine();

        Savings s = new Savings(number, cpf, tax, balance, bank);
        return s;
    }

    public static Checking getNewChecking(Scanner scan) {
        System.out.print("Checking number: ");
        String number = scan.next();
        System.out.print("Client CPF: ");
        String cpf = scan.next();
        System.out.print("Checking tax: R$");
        double tax = scan.nextDouble();
        System.out.print("Checking balance: R$");
        double balance = scan.nextDouble();
        System.out.print("Bank name: ");
        scan.nextLine();
        String bank = scan.nextLine();

        Checking c = new Checking(number, cpf, tax, balance, bank);
        return c;
    }

    public static int getOpt(Scanner scan) {
        int opt;
        System.out.print("Menu\n1. Register checking account\n2. Register savings account\n3. Update checking account\n4. Update savings account\n5. Withdraw checking account\n6. Withdraw savings account\n7. Checking account balance\n8. Savings account balance\n0. EXIT\nSelect: ");
        opt = scan.nextInt();
        return opt;
    }
}
