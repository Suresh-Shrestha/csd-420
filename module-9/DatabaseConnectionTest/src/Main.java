import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/databasedb";
        String user = "student1";
        String password = "pass";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connected successfully!");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM address33");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("ID") + " "
                                + rs.getString("LASTNAME") + " "
                                + rs.getString("FIRSTNAME") + " "
                                + rs.getString("CITY") + " "
                                + rs.getString("STATE") + " "
                                + rs.getString("ZIP"));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}