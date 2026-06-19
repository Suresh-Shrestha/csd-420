// Suresh Shrestha
// 6/18/2026
// Module-3.2 Assignment

import java.util.ArrayList;
import java.util.Random;

public class TestRemoveDuplicates {

    public static void main(String[] args) {

        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        // Fill the ArrayList with 50 random values from 1 to 20
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        // Display the original list
        System.out.println("Original List:");
        System.out.println(originalList);

        // Remove duplicates
        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);

        // Display the list without duplicates
        System.out.println("\nList with Duplicates Removed:");
        System.out.println(noDuplicates);
    }
    // Generic method to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> result = new ArrayList<>();

        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }
}
