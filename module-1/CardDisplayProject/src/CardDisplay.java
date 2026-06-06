// Suresh Shrestha
// 6/5/2026
// module-1.3 Assignment

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class CardDisplay extends Application {

    private HBox cardBox = new HBox(10);

    @Override
    public void start(Stage stage) {
        cardBox.setAlignment(Pos.CENTER);

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> displayCards()); // Lambda expression

        VBox root = new VBox(20, cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);

        displayCards();

        Scene scene = new Scene(root, 500, 300);
        stage.setTitle("Suresh's Random Card Display");
        stage.setScene(scene);
        stage.show();
    }

    private void displayCards() {
        cardBox.getChildren().clear();

        ArrayList<Integer> cards = new ArrayList<>();

        for (int i = 1; i <= 52; i++) {
            cards.add(i);
        }

        Collections.shuffle(cards);

        for (int i = 0; i < 4; i++) {
            String imagePath = "cards/" + cards.get(i) + ".png";
            Image image = new Image(imagePath);

            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(140);
            imageView.setPreserveRatio(true);

            cardBox.getChildren().add(imageView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}