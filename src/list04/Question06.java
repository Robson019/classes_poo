package list04;

import java.util.Scanner;

public class Question06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] a = new int[5], b = new int[5];

        readVectorValues(scan, a);
        readVectorValues(scan, b);

        boolean equal = equalsVerification(a, b);
        resultEqual(equal);
    }

    public static void readVectorValues(Scanner scan, int[] vector) {
        for (int j = 0; j < 5; j++) {
            System.out.print("Type a number for ["+j+"]: ");
            vector[j] = scan.nextInt();
        }
    }

    public static void resultEqual(boolean equal) {
        if (!equal) {
            System.out.println("Vectors are different");
        } else {
            System.out.println("Vectors are the same");
        }
    }

    public static boolean equalsVerification(int[] a, int[] b) {
        boolean equal = true;
        for (int j = 0; j < 5; j++) {
            if (a[j] != b[j]) {
                equal = false;
                break;
            }
        }
        return equal;
    }
}
