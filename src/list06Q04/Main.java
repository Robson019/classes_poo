package list06Q04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Imc[] myImcs = new Imc[5];

        imcMenu(scan, myImcs);
    }

    public static void imcMenu(Scanner scan, Imc[] myImcs) {
        boolean registered = false;
        int opt, cont = 0;
        do {
            opt = getOpt(scan);

            if (opt == 1 && cont < 5) {
                System.out.print("Name: ");
                scan.nextLine();
                String name = scan.nextLine();
                System.out.print("height: ");
                double height = scan.nextDouble();
                System.out.print("weight: ");
                double weight = scan.nextDouble();
                myImcs[cont] = new Imc(name, height, weight);
                System.out.println("People registered");
                registered = true;
                cont++;
            }  else if (opt == 1 && cont >= 5) {
                System.out.println("[Error] People limit reached");
            } else if (opt == 2 && registered) {
                getPeopleWithLowImc(myImcs, cont);
            } else if (opt == 3 && registered) {
                getPeopleWithNormalImc(myImcs, cont);
            } else if (opt == 4 && registered) {
                getPeopleWithHighImc(myImcs, cont);
            }else if ((opt >= 2 && opt <= 4) && !registered) {
                System.out.println("[Error] No people registered");
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
        System.out.print("Menu\n1. Register new IMC\n2. Show low IMC peoples\n3. Show normal IMC peoples\n4. Show high IMC peoples\n0. EXIT\nChoice: ");
        opt = scan.nextInt();
        return opt;
    }

    public static void getPeopleWithHighImc(Imc[] myImcs, int range) {
        int cont = 1;
        for (int j = 0; j < range; j++) {
            if (myImcs[j].calculateImc() >= 25) {
                System.out.println(cont+". "+ myImcs[j].getName()+" - "+ myImcs[j].calculateImc());
                cont++;
            }
        }
    }

    public static void getPeopleWithNormalImc(Imc[] myImcs, int range) {
        int cont = 1;
        for (int j = 0; j < range; j++) {
            if (myImcs[j].calculateImc() > 18.5 && myImcs[j].calculateImc() < 25) {
                System.out.println(cont+". "+ myImcs[j].getName()+" - "+ myImcs[j].calculateImc());
                cont++;
            }
        }
    }

    public static void getPeopleWithLowImc(Imc[] myImcs, int range) {
        int cont = 1;
        for (int j = 0; j < range; j++) {
            if (myImcs[j].calculateImc() < 18.5) {
                System.out.println(cont+". "+ myImcs[j].getName()+" - "+ myImcs[j].calculateImc());
                cont++;
            }
        }
    }
}
