// Suresh Shrestha
// 6/19/2026
// Module-4.2 Assignment

import java.util.Iterator;
import java.util.LinkedList;

public class ShresthaLinkedListTest {
    public static void main(String[] args) {

        checkProgram();

        testLinkedList(50000);
        testLinkedList(500000);
    }

    public static void testLinkedList(int numberOfItems) {
        LinkedList<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < numberOfItems; i++) {
            numbers.add(i);
        }

        long startTime = System.nanoTime();

        long iteratorTotal = 0;
        Iterator<Integer> listIterator = numbers.iterator();

        while (listIterator.hasNext()) {
            iteratorTotal += listIterator.next();

        }
        long iteratorTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();

        long getTotal = 0;

        for (int i = 0; i < numbers.size(); i++) {
            getTotal += numbers.get(i);
        }

        long getTime = System.nanoTime() - startTime;

        System.out.println("LinkedList Size: " + numberOfItems);
        System.out.println("Iterator total: " + iteratorTotal);
        System.out.println("Iterator time: " + iteratorTime + " nanoseconds");
        System.out.println("get(index) total: " + getTotal);
        System.out.println("get(index) time: " + getTime + " nanoseconds");
        System.out.println();
    }

    public static void checkProgram() {

        LinkedList<Integer> testNumbers = new LinkedList<>();

        testNumbers.add(5);
        testNumbers.add(10);
        testNumbers.add(15);

        int total = 0;

        for (int number : testNumbers) {
            total += number;
        }

        if (total == 30 && testNumbers.size() == 3) {
            System.out.println("Test code passed. The list works correctly.");
        } else {
            System.out.println("Test code failed.");
        }

        System.out.println();
    }
}
/*
 Results Discussion

 The program tested the performance of traversing a LinkedList
 containing 50,000 and 500,000 integers using an Iterator and
 the get(index) method.

 For 50,000 integers, the Iterator completed the traversal in
 2,182,400 nanoseconds, while the get(index) method took
 1,062,512,800 nanoseconds.

 For 500,000 integers, the Iterator completed the traversal in
8,444,200 nanoseconds, while the get(index) method took
197,866,213,100  nanoseconds.

 The Iterator was much faster because it moves through the
 LinkedList one element at a time. The get(index) method was
 significantly slower because LinkedList does not support
 direct index access. Each call to get(index) requires
 traversing the list to find the requested position.

 As the number of elements increased from 50,000 to 500,000
 the performance difference became much larger. These results
 show that an Iterator is the preferred method for traversing
 a LinkedList, while repeatedly using get(index) should be
 avoided for large lists.
 */
