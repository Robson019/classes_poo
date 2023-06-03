package list06Q03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Circle myCircle = new Circle(1);

        circleMenu(scan, myCircle);
    }

    public static void circleMenu(Scanner scan, Circle myCircle) {
        boolean registered = false;
        int opt;
        do {
            opt = getOpt(scan);

            if (opt == 1) {
                System.out.print("Radius: ");
                double radius = scan.nextDouble();
                myCircle = new Circle(radius);
                System.out.println("Circle registered");
                registered = true;
            } else if (opt == 2 && registered) {
                System.out.println("Area: "+myCircle.area());
            } else if (opt == 3 && registered) {
                System.out.println("Perimeter: "+myCircle.perimeter());
            } else if ((opt == 2 || opt == 3) && !registered) {
                System.out.println("[Error] Circle not registered");
            } else {
                if (opt != 0) {
                    System.out.println("[Error] Invalid option");
                }
            }
        } while(opt != 0);
        System.out.println("Bye");
    }

    public static int getOpt(Scanner scan) {
        int opt;
        System.out.print("Menu\n1. Create a new circle\n2. Calculate area\n3. Calculate perimeter\n0. EXIT\nChoice: ");
        opt = scan.nextInt();
        return opt;
    }
}
