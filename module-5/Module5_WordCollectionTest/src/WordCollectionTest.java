// Suresh Shrestha
// 6/26/2026
// Module-5.2 Assignment

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCollectionTest {

    public static void main(String[] args) {

        TreeSet<String> words = new TreeSet<>();

        try {
            File file = new File("collection_of_words.txt");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String word = input.next().toLowerCase();
                words.add(word);
            }

            input.close();

            System.out.println("Words in Ascending Order:");
            for (String word : words) {
                System.out.println(word);
            }

            System.out.println("\nWords in Descending Order:");
            for (String word : words.descendingSet()) {
                System.out.println(word);
            }

            runTests(words);

        } catch (FileNotFoundException e) {
            System.out.println("Error: collection_of_words.txt not found.");
        }
    }

    // Test code
    public static void runTests(TreeSet<String> words) {

        System.out.println("\n----- Test Results -----");

        if (words.contains("apple")) {
            System.out.println("Test 1 Passed: 'apple' found.");
        } else {
            System.out.println("Test 1 Failed.");
        }

        if (words.size() == 15) {
            System.out.println("Test 2 Passed: Duplicate words removed.");
        } else {
            System.out.println("Test 2 Failed.");
        }

        if (words.first().equals("apple")) {
            System.out.println("Test 3 Passed: First word is correct.");
        } else {
            System.out.println("Test 3 Failed.");
        }

        if (words.last().equals("tiger")) {
            System.out.println("Test 4 Passed: Last word is correct.");
        } else {
            System.out.println("Test 4 Failed.");
        }
    }
}