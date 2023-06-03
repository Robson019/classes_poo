package list09Q02;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Checking c = new Checking("0000", "000.000.000-00", 0, 0, null);
        Savings s = new Savings("0000", "000.000.000-00", 0, 0, null);

        Scanner scan = new Scanner(System.in);

        Utils.q2Menu(scan, c, s);
    }
}
