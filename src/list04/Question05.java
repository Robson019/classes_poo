package list04;

import java.util.Objects;
import java.util.Scanner;

public class Question05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPeoples = 0;

        while (numberOfPeoples <= 0) {
            System.out.print("Number of peoples: ");
            numberOfPeoples = scan.nextInt();
        }

        String[] peoples = new String[numberOfPeoples];

        readPeoples(scan, peoples);

        boolean search = findPeople(scan, peoples);

        resultFind(search);
    }

    public static void resultFind(boolean find) {
        if (find) {
            System.out.println("People found!");
        } else {
            System.out.println("People not found!");
        }
    }

    public static void readPeoples(Scanner scan, String[] peoples) {
        for (int j = 0; j < peoples.length; j++) {
            int i = j + 1;
            System.out.print("Type the "+i+"º name: ");
            peoples[j] = scan.next();
            peoples[j] = peoples[j].toLowerCase();
        }
    }

    public static boolean findPeople(Scanner scan, String[] peoples) {
        System.out.print("Consult: ");
        String consult = scan.next();
        consult = consult.toLowerCase();
        boolean search = false;

        for (int j = 0; j < peoples.length; j++) {
            if (Objects.equals(peoples[j], consult)) {
                search = true;
                break;
            }
        }
        return search;
    }
}
