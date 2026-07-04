// Suresh Shrestha
// 7/3/2026
// Module - 6.2 Assignment

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSort {
    // Generic bubble sort using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {

                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Generic bubble sort using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++){
            for (int j = 0; j < list.length - 1 - i; j++) {

                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Test program
    public static void main(String[] args) {

        // Test Comparable version with Integers
        Integer[] numbers = {9, 3, 7, 1, 5};
        System.out.println("Original Integer Array:");
        System.out.println(Arrays.toString(numbers));

        bubbleSort(numbers);
        System.out.println("sorted Integer Array (Comparable):");
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        // Test Comparable version with Strings
        String[] fruits = {"Orange", "Apple", "Banana", "Grape", "Kiwi"};

        System.out.println("Original String Array:");
        System.out.println(Arrays.toString(fruits));

        bubbleSort(fruits);

        System.out.println("sorted String Array (Comparable):");
        System.out.println(Arrays.toString(fruits));

        System.out.println();

        // Test Comparator version (Descending Order)
        Integer[] scores = {9, 3, 7, 1, 5};

        System.out.println("Original Scores:");
        System.out.println(Arrays.toString(scores));

        bubbleSort(scores, Comparator.reverseOrder());

        System.out.println("Sorted Scores (Comparator - descending):");
        System.out.println(Arrays.toString(scores));
    }
}