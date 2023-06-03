package list08Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealEstate {
    public static void main(String[] args) {
        List<House> h = new ArrayList();
        List<Apartment> a = new ArrayList();
        List<Realty> r = new ArrayList();

        Scanner scan = new Scanner(System.in);

        q4Menu(scan, h, a, r);
    }

    public static void q4Menu(Scanner scan, List<House> h, List<Apartment> a, List<Realty> r) {
        int opt, hRegisters = 0, aRegisters = 0, rRegisters = 0;
        boolean rRegistered = false;
        do {
            opt = getOpt(scan);
            if (opt == 1) {
                h.add(hRegisters, getNewHouse(scan));
                if (h.get(hRegisters).getCEP() != null) {
                    r.add(rRegisters, h.get(hRegisters));
                    rRegistered = true;
                    hRegisters++;
                    rRegisters++;
                    System.out.println("House registered");
                } else {
                    System.out.println("[ERROR] House not registered");
                }
            } else if (opt == 2) {
                a.add(aRegisters, getNewApartment(scan));
                if (a.get(aRegisters).getCEP() != null) {
                    r.add(rRegisters, a.get(aRegisters));
                    rRegistered = true;
                    aRegisters++;
                    rRegisters++;
                    System.out.println("Apartment registered");
                } else {
                    System.out.println("[ERROR] Apartment not registered");
                }
            } else if (opt == 3 && rRegistered) {
                showNotHiredProperties(r);
            } else if (opt == 4 && rRegistered) {
                showFurnishedProperties(r);
            } else if ((opt == 3 || opt == 4) && !rRegistered) {
                System.out.println("[ERROR] No properties registers");
            } else if ((opt <= -1 || opt > 4) && opt != 0) {
                System.out.println("[ERROR] Invalid option");
            }
        } while (opt != 0);
        System.out.println("bye!");
    }

    public static void showFurnishedProperties(List<Realty> r) {
        for (Realty myRealty :r) {
            if (myRealty.isFurnished()) {
                System.out.println(myRealty.getStreet());
            }
        }
    }

    public static void showNotHiredProperties(List<Realty> r) {
        for (Realty myRealty :r) {
            if (!myRealty.isHired()) {
                System.out.println(myRealty.getStreet());
            }
        }
    }

    public static Apartment getNewApartment(Scanner scan) {
        Apartment a;

        System.out.print("Street name: ");
        scan.nextLine();
        String streetName = scan.nextLine();
        System.out.print("Building name: ");
        String buildName = scan.nextLine();
        System.out.print("Apartment number: ");
        String number = scan.next();
        System.out.print("Apartment district: ");
        scan.nextLine();
        String district = scan.nextLine();
        System.out.print("Apartment city: ");
        String city = scan.nextLine();
        System.out.print("Apartment state: ");
        String state = scan.nextLine();
        System.out.print("Apartment CEP: ");
        String cep = scan.nextLine();
        System.out.print("Apartment price: R$");
        double price = scan.nextDouble();
        System.out.print("is Hired? (y/n) ");
        char auxBool = scan.next().charAt(0);
        boolean hired = false;
        if (auxBool == 'y') {
            hired = true;
        }
        System.out.print("is Furnished? (y/n) ");
        auxBool = scan.next().charAt(0);
        boolean furnished = false;
        if (auxBool == 'y') {
            furnished = true;
        }

        a = new Apartment(streetName, number, district, city, state, cep, price, hired, furnished, buildName);
        return a;
    }

    public static House getNewHouse(Scanner scan) {
        House h;

        System.out.print("Street name: ");
        scan.nextLine();
        String streetName = scan.nextLine();
        System.out.print("House number: ");
        String number = scan.next();
        System.out.print("House district: ");
        scan.nextLine();
        String district = scan.nextLine();
        System.out.print("House city: ");
        String city = scan.nextLine();
        System.out.print("House state: ");
        String state = scan.nextLine();
        System.out.print("House CEP: ");
        String cep = scan.nextLine();
        System.out.print("House price: R$");
        double price = scan.nextDouble();
        System.out.print("is Hired? (y/n) ");
        char auxBool = scan.next().charAt(0);
        boolean hired = false;
        if (auxBool == 'y') {
            hired = true;
        }
        System.out.print("is Furnished? (y/n) ");
        auxBool = scan.next().charAt(0);
        boolean furnished = false;
        if (auxBool == 'y') {
            furnished = true;
        }

        h = new House(streetName, number, district, city, state, cep, price, hired, furnished);
        return h;
    }

    public static int getOpt(Scanner scan) {
        int opt;
        System.out.print("Menu\n1. Register house\n2. Register apartment\n3. Show not hired properties\n4. Show furnished properties\n0. EXIT\nSelect: ");
        opt = scan.nextInt();
        return opt;
    }
}
