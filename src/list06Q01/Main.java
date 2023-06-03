package list06Q01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student myStudent = new Student(null, null, null, null);

        studentMenu(scan, myStudent);
    }

    public static void studentMenu(Scanner scan, Student myStudent) {
        boolean registered = false;
        int opt, cont = 1;
        do {
            opt = getOpt(scan);

            if (opt == 1) {
                System.out.print("Student name: ");
                scan.nextLine();
                String name = scan.nextLine();
                System.out.print("Student address: ");
                String address = scan.nextLine();
                double[] scores = getDoubles(scan);
                String strCont = String.valueOf(cont);
                myStudent = new Student(name, strCont, address, scores);
                System.out.println("Student registered");
                registered = true;
                cont++;
            } else if (opt == 2 && registered) {
                isApproved(myStudent);
            } else if (opt == 3 && registered) {
                System.out.println("Student registration: "+ myStudent.getRegistration());
            } else if (opt == 4 && registered) {
                System.out.println("Student Address: "+ myStudent.getAddress());
            } else if ((opt >= 2 && opt <= 4) && !registered) {
                System.out.println("[Error] Student not registered");
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
        System.out.print("Menu\n1. Create a new student\n2. Calculate average\n3. Show registration\n4. Show address\n0. EXIT\nChoice: ");
        opt = scan.nextInt();
        return opt;
    }

    public static double[] getDoubles(Scanner scan) {
        double[] scores = new double[4];
        for (int j = 1; j <= scores.length; j++) {
            System.out.print("Type the "+j+"º score: ");
            scores[j-1] = scan.nextDouble();
        }
        return scores;
    }

    public static void isApproved(Student myStudent) {
        if (myStudent.average(myStudent.getScores()) >= 7) {
            System.out.println("Approved");
        } else {
            System.out.println("Reproved");
        }
        System.out.println("AVG Score: "+ myStudent.average(myStudent.getScores()));
    }
}
