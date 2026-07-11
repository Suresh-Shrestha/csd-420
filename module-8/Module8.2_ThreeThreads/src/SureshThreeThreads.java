// Suresh Shrestha
// 7/10/2026
// Module-8.2 Assignment

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class SureshThreeThreads extends Application {
private TextArea textArea = new TextArea();
private Random random = new Random();

    @Override
    public void start(Stage stage) {

        textArea.setWrapText(true);
        textArea.setEditable(false);

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 800, 500);

        stage.setTitle("Three Threads");
        stage.setScene(scene);
        stage.show();

        startThreads();
        testMethods();
    }

    // Starts all three threads
    public void startThreads() {

        // Thread for letters
        Thread letterThread = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                char letter = getRandomLetter();

                Platform.runLater(() ->
                    textArea.appendText(String.valueOf(letter)));

            }

        });

        // Thread for numbers
        Thread numberThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {

                char number = getRandomNumber();

                Platform.runLater(() ->
                textArea.appendText(String.valueOf(number)));
            }
        });

        // Thread for symbols
        Thread symbolThread = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {

                char symbol = getRandomSymbol();
                Platform.runLater(() ->
                    textArea.appendText(String.valueOf(symbol)));
            }
        });

        letterThread.start();
        numberThread.start();
        symbolThread.start();
    }

    // Creates a random lowercase letter
    public char getRandomLetter() {

        return (char) ('a' + random.nextInt(26));
    }

    // Creates a random number from 0 to 9
    public char getRandomNumber() {

        return (char) ('0' + random.nextInt(10));
    }

    // Creates a random symbol
    public char getRandomSymbol() {

        String symbols = "!@#$%&*^";

        return symbols.charAt(random.nextInt(symbols.length()));
    }

    // Tests the three methods
    public void testMethods() {

        char letter = getRandomLetter();
        char number = getRandomNumber();
        char symbol = getRandomSymbol();

        System.out.println("Test Results:");

        if (letter >= 'a' && letter <= 'z') {
            System.out.println("Letter method passed.");
        } else {
            System.out.println("Letter method failed.");
        }

        if (number >= '0' && number <= '9') {
            System.out.println("Number method passed.");
        } else {
            System.out.println("Number method failed.");
        }

        if ("!@#$%&*^".indexOf(symbol) >= 0) {
            System.out.println("Symbol method passed.");
        } else {
            System.out.println("Symbol method failed.");
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}


