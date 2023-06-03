package list03;

import java.util.Scanner;

public class Question03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word;
        int vowels = 0;

        System.out.print("Type a word: ");
        word = scan.next();
        vowels = getVowels(word, vowels);

        System.out.println("Number of vowels: "+ vowels);
    }

    public static int getVowels(String word, int vowels) {
        word = word.toLowerCase();

        for (int j = 0; j < word.length(); j++) {
            if (word.charAt(j) == 'a' || word.charAt(j) == 'e' || word.charAt(j) == 'i' || word.charAt(j) == 'o' || word.charAt(j) == 'u') {
                vowels++;
            }
        }
        return vowels;
    }
}
