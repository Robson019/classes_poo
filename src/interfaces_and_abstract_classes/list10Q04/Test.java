package interfaces_and_abstract_classes.list10Q04;

import interfaces_and_abstract_classes.GeometricObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static interfaces_and_abstract_classes.list10Q04.Utils.q4Menu;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<GeometricObject> g = new ArrayList();

        q4Menu(scan, g);
    }
}
