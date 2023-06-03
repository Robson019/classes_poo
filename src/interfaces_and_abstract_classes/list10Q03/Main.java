package interfaces_and_abstract_classes.list10Q03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int opt;
        double pi = 3.14, radius = 0;
        Circle c = new Circle(pi, radius);
        boolean objRegistered = false;
        do {
            System.out.print("Menu\n1. Digitar valor de π e r\n2. Calcular área\n3. Calcular perímetro\n0. SAIR\nOpção: ");
            opt = scan.nextInt();

            if (opt == 1) {
                System.out.print("Digite o valor de π: ");
                pi = scan.nextDouble();
                if (pi - 3 >= 0.15 && pi - 3 < 0.14) {
                    pi = 3.14;
                }
                System.out.print("Digite o raio: ");
                radius = scan.nextDouble();

                c = new Circle(pi, radius);

                objRegistered = true;
            } else if (opt == 2 && objRegistered) {
                System.out.println("Área: "+c.calculateArea());
            } else if (opt == 3 && objRegistered) {
                System.out.println("Perímetro: "+c.calculatePerimeter());
            } else if ((opt == 2 || opt == 3) && !objRegistered) {
                System.out.println("[ERRO] Não há objeto registrado!");
            } else if (opt < 0 || opt > 3) {
                System.out.println("[ERRO] Opção inválida");
            }
        } while (opt != 0);
        System.out.println("Adeus");
    }
}
