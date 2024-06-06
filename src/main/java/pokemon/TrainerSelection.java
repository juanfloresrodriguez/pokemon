package pokemon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class TrainerSelection implements Initializable {

    @FXML
    private Button returnButon;

    @FXML
    private Group trainer1;

    @FXML
    private Group trainer10;

    @FXML
    private Group trainer11;

    @FXML
    private Group trainer12;

    @FXML
    private Group trainer13;

    @FXML
    private Group trainer14;

    @FXML
    private Group trainer2;

    @FXML
    private Group trainer3;

    @FXML
    private Group trainer4;

    @FXML
    private Group trainer5;

    @FXML
    private Group trainer6;

    @FXML
    private Group trainer7;

    @FXML
    private Group trainer8;

    @FXML
    private Group trainer9;

    @FXML
    private ImageView trainer1Pokemon1;

    @FXML
    private ImageView trainer1Pokemon2;

    @FXML
    private ImageView trainer1Pokemon3;

    @FXML
    private ImageView trainer1Pokemon4;

    @FXML
    private ImageView trainer1Pokemon5;

    @FXML
    private ImageView trainer1Pokemon6;

    @FXML
    private ImageView trainer1Trainer;

    @FXML
    void returnToMainMenu() {
        //abrimos la ventana principal
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("mainMenu.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Menú Principal");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //cerramos la ventana actual a través de algún control de la misma
        Stage stage = (Stage) returnButon.getScene().getWindow();

        stage.close();
    }

    private void setTrainerImages()  {

        Singleton s = Singleton.getInstance();
        try{
            Connection connection = DriverManager.getConnection(s.getDatabaseURL(), s.getDatabaseUser(), s.getDatabasePassword());


            String query = "SELECT ID_Trainer FROM Trainers";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet trainersId = statement.executeQuery();

            while(trainersId.next()) {
                trainersId.getInt(1);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void setPokemonImages(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
