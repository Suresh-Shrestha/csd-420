// Suresh Shrestha
// 7/24/2026
// Module 10.2 Assignment

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class FanDatabase extends Application {

    private TextField txtId = new TextField();
    private TextField txtFirst = new TextField();
    private TextField txtLast = new TextField();
    private TextField txtTeam = new TextField();

    private final String URL = "jdbc:mysql://localhost:3306/databasedb";
    private final String USER  = "student1";
    private final String PASS = "pass";

    @Override
    public void start(Stage stage) {

        Button btnDisplay = new Button("Display");
        Button btnUpdate = new Button("Update");

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(new Label("ID:"), 0 ,0);
        pane.add(txtId,1 ,0);

        pane.add(new Label("First Name:"), 0 ,1);
        pane.add(txtFirst,1,1);

        pane.add(new Label("Last Name:"), 0 ,2);
        pane.add(txtLast, 1 ,2);

        pane.add(new Label("Favorite Team:"), 0 ,3);
        pane.add(txtTeam, 1, 3);

        pane.add(btnDisplay, 0, 4);
        pane.add(btnUpdate, 1, 4);

        btnDisplay.setOnAction(e -> displayRecord());
        btnUpdate.setOnAction(e -> updateRecord());

        Scene scene = new Scene(pane, 350, 220);

        stage.setTitle("Fan Database");
        stage.setScene(scene);
        stage.show();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    private void displayRecord() {

        String sql = "SELECT * FROM fans WHERE ID=?";

        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            int id = Integer.parseInt(txtId.getText());
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                txtFirst.setText(rs.getString("firstname"));
                txtLast.setText(rs.getString("lastname"));
                txtTeam.setText(rs.getString("favoriteteam"));
            }else{

                showMessage("Record not found.");
            }
        }catch(Exception e){

            showMessage(e.getMessage());
        }
    }

    private void updateRecord() {
        String sql =
                "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";

        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, txtFirst.getText());
            ps.setString(2, txtLast.getText());
            ps.setString(3, txtTeam.getText());
            ps.setInt(4, Integer.parseInt(txtId.getText()));

            int rows = ps.executeUpdate();

            if(rows > 0) {
                showMessage("Record updated.");
            }else {
                showMessage("Record not found.");
            }
        }catch(Exception e){

            showMessage(e.getMessage());

        }
    }

    private void showMessage(String message){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

    public static void main(String[] args) {
        launch(args);
    }
}