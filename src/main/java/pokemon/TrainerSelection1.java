package pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class TrainerSelection1 implements Initializable {
    Singleton s = Singleton.getInstance();

    @FXML
    private Button returnButton;

    @FXML
    private ImageView trainer;

    @FXML
    private ComboBox<String> trainerName;



    @FXML
    void setTrainerImage(){
//Convierte el nombre seleccionado del comboBox lo convierte a un string y llama a la foto que se llama así
        String name = trainerName.getValue();
        File file = new File("imagenes/entrenadores/" + name + ".png");
        trainer.setImage(new Image(file.toURI().toString()));

        s.setTrainerSelection(name);
    }

    @FXML
    void setPokemonTrainer(){
        
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try{
            Singleton s = Singleton.getInstance();
            List<String> names = new ArrayList<>();
            int num=1;
            String databaseUrl = "jdbc:mysql://" + s.getDatabaseIp() + ":" + s.getDatabasePort()+ "/" + s.getDatabaseName();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());
            for(int i =0; i<12; i++) {

                String query = "SELECT Trainer FROM Trainers WHERE ID_Trainer = " + num;
                PreparedStatement statement = connection.prepareStatement(query);

                ResultSet name = statement.executeQuery();
                name.next();
                names.add(name.getString("Trainer"));
                num++;
            }
            System.out.println(names);
            trainerName.setItems(FXCollections.observableArrayList(names));
            if(s.getTrainerSelection()==null){
                trainerName.getSelectionModel().selectFirst();
            }

            setTrainerImage();
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
