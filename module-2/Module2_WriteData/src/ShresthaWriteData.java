// Suresh Shrestha
// 06/11/2026
// Module-2.2 Assignment

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class ShresthaWriteData {

    public static void main(String[] args) {
        int[] numbers = new int[5];
        double[] doubles = new double[5];

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            numbers[i] = random.nextInt(100) + 1;
            doubles[i] = random.nextDouble() * 100;
        }
        try (PrintWriter output = new PrintWriter(new FileWriter("shrestha datafile.dat", true))) {

            output.println("Five Random Integers:");
            for (int number : numbers) {
                output.print(number + " ");
            }

            output.println();

            output.println("Five Random Double Values:");
            for (double value : doubles) {
                output.printf("%.2f ", value);
            }

            output.println();
            output.println("----------------------");

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
        }
    }
}

