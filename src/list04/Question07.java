package list04;

import java.util.Scanner;

public class Question07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Type a phrase: ");
        String phrase = scan.nextLine();

        char[] invertedPhrase = getInvertedPhrase(phrase);

        printInvertedPhrase(invertedPhrase);
    }

    private static void printInvertedPhrase(char[] invertedPhrase) {
        for (int j = 0; j < invertedPhrase.length; j++) {
            System.out.print(invertedPhrase[j]);
        }
        System.out.println();
    }

    public static char[] getInvertedPhrase(String phrase) {
        char[] invertedPhrase = new char[phrase.length()];

        for (int j = 0; j < phrase.length(); j++) {
            char finalLetter = phrase.charAt((phrase.length()-1) - j);
            invertedPhrase[j] = finalLetter;
        }
        return invertedPhrase;
    }
}
