package Lista10Q06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Lista10Q06.Utils.q6Menu;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<FullTimer> f = new ArrayList();
        List<Hourly> h = new ArrayList();

        q6Menu(scan, f, h);
    }
}
