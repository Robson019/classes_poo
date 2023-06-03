package list04;

import java.util.Objects;
import java.util.Scanner;

public class Question08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Type a phrase: ");
        String phrase = scan.nextLine();
        phrase = phrase.toLowerCase();

        System.out.println("NUmber of letters: "+getLettersCount(phrase));
    }

    public static int getLettersCount(String phrase) {
        int lettersCount = 0;
        for (int j = 0; j < phrase.length(); j++) {
            if (Objects.equals(phrase.charAt(j), 'a') || Objects.equals(phrase.charAt(j), 'b') ||
                Objects.equals(phrase.charAt(j), 'c') || Objects.equals(phrase.charAt(j), 'd') ||
                Objects.equals(phrase.charAt(j), 'e') || Objects.equals(phrase.charAt(j), 'f') ||
                Objects.equals(phrase.charAt(j), 'g') || Objects.equals(phrase.charAt(j), 'h') ||
                Objects.equals(phrase.charAt(j), 'i') || Objects.equals(phrase.charAt(j), 'j') ||
                Objects.equals(phrase.charAt(j), 'k') || Objects.equals(phrase.charAt(j), 'l') ||
                Objects.equals(phrase.charAt(j), 'm') || Objects.equals(phrase.charAt(j), 'n') ||
                Objects.equals(phrase.charAt(j), 'o') || Objects.equals(phrase.charAt(j), 'p') ||
                Objects.equals(phrase.charAt(j), 'q') || Objects.equals(phrase.charAt(j), 'r') ||
                Objects.equals(phrase.charAt(j), 's') || Objects.equals(phrase.charAt(j), 't') ||
                Objects.equals(phrase.charAt(j), 'u') || Objects.equals(phrase.charAt(j), 'v') ||
                Objects.equals(phrase.charAt(j), 'w') || Objects.equals(phrase.charAt(j), 'x') ||
                Objects.equals(phrase.charAt(j), 'y') || Objects.equals(phrase.charAt(j), 'z')) {
                lettersCount++;
            }
        }
        return lettersCount;
    }
}
