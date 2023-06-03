package interfaces_and_abstract_classes.list10Q01_Q02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int opt;
        double base = 0, height = 0;
        Rectangle r = new Rectangle(base, height);
        boolean objRegistered = false;
        do {
            opt = readOpt(scan);

            if (opt == 1) {
                boolean verified = false;
                try {
                    System.out.print("Digite a base: ");
                    base = scan.nextDouble();
                    System.out.print("Digite a altura: ");
                    height = scan.nextDouble();
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    verified = true;
                }

                if (!verified) {
                    r = new Rectangle(base, height);
                    objRegistered = true;
                } else {
                    System.out.println("[Erro] Objeto não registrado");
                }
            } else if (opt == 2 && objRegistered) {
                System.out.println("Área: "+r.calculateArea());
            } else if (opt == 3 && objRegistered) {
                System.out.println("Perímetro: "+r.calculatePerimeter());
            } else if ((opt == 2 || opt == 3) && !objRegistered) {
                System.out.println("[ERRO] Não há objeto registrado!");
            }
        } while (opt != 0);
        System.out.println("Adeus");
    }

    public static int readOpt(Scanner scan) {
        System.out.print("Menu\n1. Digitar valor de b e h\n2. Calcular área\n3. Calcular perímetro\n0. SAIR\nOpção: ");
        int opt = -1;

        try {
            opt = scan.nextInt();
            if (opt < 0 || opt > 3) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("[Erro] Digite uma opção válida");
            scan.nextLine();
        }

        return opt;
    }
}
