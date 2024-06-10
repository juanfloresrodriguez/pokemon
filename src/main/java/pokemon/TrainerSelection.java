package pokemon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class TrainerSelection implements Initializable {

    @FXML
    private Button returnButton;

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
        Stage stage = (Stage) returnButton.getScene().getWindow();

        stage.close();
    }

    private void setTrainerImages()  {

        Singleton s = Singleton.getInstance();
        try{
            Connection connection = DriverManager.getConnection(s.getDatabaseIp(), s.getDatabaseUser(), s.getDatabasePassword());
            int num = 2;
//            for(int i =0; i<12; i++) {
                String query = "SELECT Trainer FROM Trainers WHERE ID_Trainer =" + num;
                PreparedStatement statement = connection.prepareStatement(query);



                ResultSet trainerName = statement.executeQuery();
//            System.out.println(trainerName.getString(1));
//            File file = new File("imagenes/"+ trainerName.getString(1) +".png");
//            trainer1Trainer.setImage(new Image(file.toURI().toString()));

//                num++;
//            }

            while(trainerName.next()) {
                trainerName.getString(1);
                System.out.println(trainerName);
                File file = new File("imagenes/" + trainerName + ".png");
                trainer1Trainer.setImage(new Image(file.toURI().toString()));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void setPokemonImages(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTrainerImages();
    }
}
