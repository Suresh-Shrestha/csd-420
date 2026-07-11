// Suresh Shrestha
// 7/10/2026
// Module 7.2 Assignment

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStyleDemo extends Application {

    @Override
    public void start(Stage stage) {

        Circle circle1 = new Circle(40);
        Circle circle2 = new Circle(40);
        Circle circle3 = new Circle(40);
        Circle circle4 = new Circle(40);

        // Apply style class
        circle1.getStyleClass().add("plaincircle");
        circle2.getStyleClass().add("plaincircle");
        circle3.getStyleClass().add("plaincircle");
        circle4.getStyleClass().add("plaincircle");

        // Apply IDs
        circle2.setId("redcircle");
        circle3.setId("greencircle");

        HBox pane = new HBox(20);
        pane.getChildren().addAll(circle1, circle2, circle3, circle4);
        Scene scene = new Scene(pane, 420, 150);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        stage.setTitle("Module 7 CSS Circles");
        stage.setScene(scene);
        stage.show();

        runTests(circle1, circle2, circle3, circle4);

    }

    // Test Code
    private void runTests(Circle c1, Circle c2, Circle c3, Circle c4) {
        System.out.println("------- Running Tests ------");
        System.out.println("Circle 1 class: " + c1.getStyleClass().contains("plaincircle"));
        System.out.println("Circle 2 ID: " + c2.getId().equals("redcircle"));
        System.out.println("Circle 3 ID " + c3.getId().equals("greencircle"));
        System.out.println("Circle 4 class: " + c4.getStyleClass().contains("plaincircle"));
        System.out.println("ALL tests completed.");
    }
    public static void main(String[] args) {
        launch(args);
    }
}