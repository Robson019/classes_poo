package list08Q1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student s = new Student(null, "000.000.000-00", "00/00/0000", null);
        Teacher t = new Teacher(null, "000.000.000-00", "00/00/0000", 0);

        q1Menu(scan, s, t);
    }

    public static void q1Menu(Scanner scan, Student s, Teacher t) {
        int opt;
        boolean sRegistered = false, tRegistered = false;
        do {
            opt = getOpt(scan);
            if (opt == 1) {
                s = getNewStudent(scan);
                if (s.getCpf() == null || s.getBirthDate() == null) {
                    continue;
                } else {
                    sRegistered = true;
                    System.out.println("Student registered");
                }
            } else if (opt == 2) {
                t = getNewTeacher(scan);
                if (t.getCpf() == null || t.getBirthDate() == null) {
                    continue;
                } else {
                    tRegistered = true;
                    System.out.println("Teacher registered");
                }
            } else if (opt == 3 && sRegistered) {
                System.out.println("Student average: "+ s.scoreAVG(s.getScore()));
            } else if (opt == 4 && sRegistered) {
                System.out.println("Student: "+ s.getName()+" | CPF: "+ s.getCpf());
                System.out.println("Birthdate: "+ s.getBirthDate()+" | Scores: "+ s.showScoreBoard());
            } else if (opt == 5 && tRegistered) {
                System.out.println("Teacher: "+ t.getName()+" | CPF: "+ t.getCpf());
                System.out.println("Birthdate: "+ t.getBirthDate()+" | Salary: R$"+ t.getSalary());
            } else if ((opt == 3 && !sRegistered) || ((opt == 4 || opt == 5) && !tRegistered)) {
                System.out.println("[ERROR] Not registered");
            } else if ((opt <= -1 || opt > 5) && opt != 0) {
                System.out.println("[ERROR] Invalid option");
            }
        } while (opt != 0);
        System.out.println("bye!");
    }

    public static Teacher getNewTeacher(Scanner scan) {
        Teacher t;
        System.out.print("Teacher name: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.print("Teacher CPF: ");
        String cpf = scan.next();
        System.out.print("Teacher birthdate: ");
        String birthDate = scan.next();
        System.out.print("Teacher salary: R$");
        double salary = scan.nextDouble();

        t = new Teacher(name, cpf, birthDate, salary);
        return t;
    }

    public static Student getNewStudent(Scanner scan) {
        Student s;
        System.out.print("Student name: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.print("Student CPF: ");
        String cpf = scan.next();
        System.out.print("Student birthdate: ");
        String birthDate = scan.next();

        double[] scores = new double[4];
        for (int j = 0; j < 4; j++) {
            System.out.print("Student "+(j+1)+"º score: ");
            scores[j] = scan.nextDouble();
        }

        s = new Student(name, cpf, birthDate, scores);
        return s;
    }

    public static int getOpt(Scanner scan) {
        int opt;
        System.out.print("Menu\n1. Register student\n2. Register teacher\n3. Show student average\n4. Show student info\n5. Show teacher info\n0. EXIT\nSelect: ");
        opt = scan.nextInt();
        return opt;
    }
}
