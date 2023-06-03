package interfaces_and_abstract_classes.list10Q05Old;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static interfaces_and_abstract_classes.list10Q05Old.Utils.q5Menu;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Employee> e = new ArrayList();
        List<Manager> m = new ArrayList();

        q5Menu(scan, e, m);
    }
}
