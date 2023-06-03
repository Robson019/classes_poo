package list09Q03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<FullTime> f = new ArrayList();
        List<Hourly> h = new ArrayList();

        Scanner scan = new Scanner(System.in);

        Utils.q3Menu(scan, f, h);
    }
}
