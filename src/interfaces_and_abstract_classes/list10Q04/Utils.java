package interfaces_and_abstract_classes.list10Q04;

import interfaces_and_abstract_classes.GeometricObject;
import interfaces_and_abstract_classes.list10Q01_Q02.Rectangle;
import interfaces_and_abstract_classes.list10Q03.Circle;

import java.util.List;
import java.util.Scanner;

public class Utils {
    public static void q4Menu(Scanner scan, List<GeometricObject> g) {
        boolean gRegistered = false;
        int opt;

        do {
            opt = getOpt(scan);

            if (opt == 1) {
                g.add(appendCircle(scan));
                gRegistered = true;
            } else if (opt == 2) {
                g.add(appendRectangle(scan));
                gRegistered = true;
            } else if (opt == 3 && gRegistered) {
                System.out.println("Média das áreas: "+calculateAreaAVG(g));
            } else if (opt == 4 && gRegistered) {
                System.out.println("Média dos perímetros: "+calculatePerimeterAVG(g));
            } else if ((opt == 3 || opt == 4) && !gRegistered) {
                System.out.println("[ERRO] Não há objeto registrado!");
            } else if (opt < 0 || opt > 4) {
                System.out.println("[ERRO] Opção inválida");
            }
        } while (opt != 0);
        System.out.println("Adeus");
    }

    public static double calculatePerimeterAVG(List<GeometricObject> g) {
        double avg = 0;

        for (GeometricObject obj :g) {
            avg += obj.calculatePerimeter();
        }
        avg /= g.size();

        return avg;
    }

    public static double calculateAreaAVG(List<GeometricObject> g) {
        double avg = 0;

        for (GeometricObject obj :g) {
            avg += obj.calculateArea();
        }
        avg /= g.size();

        return avg;
    }

    public static Rectangle appendRectangle(Scanner scan) {
        System.out.print("Digite a base: ");
        double base = scan.nextDouble();
        System.out.print("Digite a altura: ");
        double height = scan.nextDouble();

        Rectangle r = new Rectangle(base, height);

        return r;
    }

    public static Circle appendCircle(Scanner scan) {
        System.out.print("Digite o valor de π: ");
        double pi = scan.nextDouble();
        if (pi - 3 >= 0.15 && pi - 3 < 0.14) {
            pi = 3.14;
        }
        System.out.print("Digite o raio: ");
        double radius = scan.nextDouble();

        Circle c = new Circle(pi, radius);

        return c;
    }

    public static int getOpt(Scanner scan) {
        int opt;
        System.out.print("Menu\n1. Adicionar círculo\n2. Adicionar retângulo\n3. Média das áreas\n4. Média dos perímetros\n0. SAIR\nOpção: ");
        opt = scan.nextInt();
        return opt;
    }
}
