package Lista10Q05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Lista10Q05.Utils.q5Menu;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Funcionario> f = new ArrayList();
        List<Gerente> g = new ArrayList();

        q5Menu(scan, f, g);
    }
}
