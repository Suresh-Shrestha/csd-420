import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShresthaReadData {

    public static void main(String[] args) {

        try {
            File file = new File("shrestha datafile.dat");
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }

            input.close();
        }
         catch (FileNotFoundException e) {
            System.out.println("File not found.");
         }
    }
}
