package list06Q02;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Rectangle myRectangle = new Rectangle(1, 1);

        rectangleMenu(scan, myRectangle);
    }

    public static void rectangleMenu(Scanner scan, Rectangle myRectangle) {
        boolean registered = false;
        int opt;
        do {
            opt = getOpt(scan);

            if (opt == 1) {
                double[] measures = new double[2];
                System.out.print("Base: ");
                measures[0] = scan.nextDouble();
                System.out.print("Height: ");
                measures[1] = scan.nextDouble();
                myRectangle = new Rectangle(measures[0], measures[1]);
                System.out.println("Rectangle registered");
                registered = true;
            } else if (opt == 2 && registered) {
                System.out.println("Area: "+myRectangle.area(myRectangle.getBase(), myRectangle.getHeight()));
            } else if (opt == 3 && registered) {
                System.out.println("Perimeter: "+myRectangle.perimeter(myRectangle.getBase(), myRectangle.getHeight()));
            } else if ((opt == 2 || opt == 3) && !registered) {
                System.out.println("[Error] Rectangle not registered");
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
        System.out.print("Menu\n1. Create a new rectangle\n2. Calculate area\n3. Calculate perimeter\n0. EXIT\nChoice: ");
        opt = scan.nextInt();
        return opt;
    }
}
