package pokemon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

/**
 * JavaFX App
 */
public class App extends Application {
//    private static final String URL = "jdbc:mysql://localhost:3306/pokemon?useSSL=false&serverTimezone=UTC";
//    private static final String USER = "root";
//    private static final String PASSWORD = "";

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("connectionDB"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }



    public static void main(String[] args) throws SQLException {
        launch();
//        int pokemonID = 2;
//
//        Connection conenction = DriverManager.getConnection(URL, USER, PASSWORD);
//        String query = "SELECT * FROM Pokemon WHERE ID_Pokemon = ?";
//        PreparedStatement statement = conenction.prepareStatement(query);
//        statement.setInt(1, pokemonID);
//        ResultSet resultSet = statement.executeQuery();
//        resultSet.next();
//        System.out.println(resultSet.getString("Pokemon"));


    }

}