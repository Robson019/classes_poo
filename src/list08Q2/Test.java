package list08Q2;

import java.util.Scanner;

public class Test {
    // eu salvei o arquivo errado, esse está desatualizado (incompleto)
    public static void main(String[] args) {
        Client[] c = new Client[3];
        Checking ca = new Checking(null, 0, 0, null);
        Savings sa = new Savings(null, 0, 0, null);

        Scanner scan = new Scanner(System.in);

        q2Menu(scan, c, ca,sa);
    }

    public static void q2Menu(Scanner scan, Client[] c, Checking ca, Savings sa) {
        int opt, registers = 0;
        boolean cRegistered = false;
        do {
            opt = getOpt(scan);
            if (opt == 1 && registers < c.length) {
                c[registers] = getNewClient(scan);
                if (c[registers].getCpf() != null) {
                    cRegistered = true;
                    System.out.println("Client registered");
                    registers++;
                }
            } else if (opt == 2 && cRegistered) {
                int clientSearch = clientPositionSearch(scan, c, registers);
                if (clientSearch != -1) {
                    //c[clientSearch].getCheckingAccount().withdraw();
                }
            } else if (opt == 3 && cRegistered) {
                System.out.println("working...");
            } else if (opt == 4 && cRegistered) {
                System.out.println("working...");
            } else if (opt == 5 && cRegistered) {
                System.out.println("working...");
            } else if ((opt > 1 && opt < 6) && !cRegistered) {
                System.out.println("[ERROR] No client registered");
            } else if (opt == 1 && registers >= c.length) {
                System.out.println("[ERROR] Client limit registered");
            } else if ((opt <= -1 || opt > 5) && opt != 0) {
                System.out.println("[ERROR] Invalid option");
            }
        } while (opt != 0);
        System.out.println("bye!");
    }

    private static int clientPositionSearch(Scanner scan, Client[] c, int registers) {
        System.out.print("Client CPF: ");
        String cpfSearch = scan.next();

        for (int f = 0; f <= registers; f++) {
            if (cpfSearch.equals(c[f].getCpf())) {
                return f;
            }
        }
        return -1;
    }

    public static Client getNewClient(Scanner scan) {
        Client c;
        Checking ca;
        Savings sa;

        System.out.print("Client name: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.print("Client CPF: ");
        String cpf = scan.next();

        System.out.println("== Checking Account register ==");
        System.out.print("Checking number: ");
        String number = scan.next();
        System.out.print("Checking tax: ");
        double tax = scan.nextDouble();
        System.out.print("Checking balance: R$");
        double balance = scan.nextDouble();
        System.out.print("Checking bank name: ");
        scan.nextLine();
        String bank = scan.nextLine();
        ca = new Checking(number, tax, balance, bank);

        System.out.println("== Savings Account register ==");
        System.out.print("Savings number: ");
        number = scan.next();
        System.out.print("Savings tax: ");
        tax = scan.nextDouble();
        System.out.print("Savings balance: R$");
        balance = scan.nextDouble();
        System.out.print("Savings bank name: ");
        scan.nextLine();
        bank = scan.nextLine();
        sa = new Savings(number, tax, balance, bank);


        c = new Client(name, cpf, ca, sa);
        return c;
    }

    public static int getOpt(Scanner scan) {
        int opt;
        System.out.print("Menu\n1. Register client\n2. Withdraw checking account\n3. Withdraw savings account\n4. Deposit checking account\n5. Deposit savings account\n0. EXIT\nSelect: ");
        opt = scan.nextInt();
        return opt;
    }
}

