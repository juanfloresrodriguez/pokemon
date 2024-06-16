package pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {

    @FXML
    public ComboBox difficultySelection;
    @FXML
    public ImageView trainerImage;

    @FXML
    private Button databaseReturn;

    @FXML
    private Button helpWindow;

    @FXML
    private Button playButton;

    @FXML
    private Button pokedexWindow;

    @FXML
    private Button programExit;

    @FXML
    private Button trainerWindow;


    @FXML
    void exitProgram() {
        System.exit(0);
    }

    @FXML
    void openGame() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("battle.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("POKEMON");
            stage.setScene(scene);
            stage.show();

            //cerramos la ventana actual buscando su referencia a través de algún
            //control (en este caso el botón 'abrir1'
            Stage closeWindows = (Stage) trainerWindow.getScene().getWindow();

            closeWindows.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void openHelpWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("helpWindows.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Ayuda");
            stage.setScene(scene);

            stage.initModality(Modality.APPLICATION_MODAL);

            //stage.show();
            stage.showAndWait();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void openPokedexWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pokedex.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("POKEDEX");
            stage.setScene(scene);
            stage.show();

            //cerramos la ventana actual buscando su referencia a través de algún
            //control (en este caso el botón 'abrir1'
            Stage closeWindows = (Stage) trainerWindow.getScene().getWindow();

            closeWindows.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void openTrainerWindows() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("trainerSelection1.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Selecciona el entrenador");
            stage.setScene(scene);
            stage.show();

            //cerramos la ventana actual buscando su referencia a través de algún
            //control (en este caso el botón 'abrir1'
            Stage closeWindows = (Stage) trainerWindow.getScene().getWindow();

            closeWindows.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        changeTrainerImage();//Para establecer la imagen del entrenador seleccionado
    }

    @FXML
    void returnToDatabase() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("connectionDB.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Configuración BBDD");
            stage.setScene(scene);
            stage.show();

            //cerramos la ventana actual buscando su referencia a través de algún
            //control (en este caso el botón 'abrir1'
            Stage closeStage = (Stage) databaseReturn.getScene().getWindow();

            closeStage.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //cerramos la ventana actual a través de algún control de la misma
        Stage stage = (Stage) databaseReturn.getScene().getWindow();

        stage.close();
    }

    @FXML
    public void selectDifficulty() {
        Singleton s = Singleton.getInstance();
        s.setDifficultySelection(difficultySelection.getSelectionModel().getSelectedItem().toString());
    }


    public void changeTrainerImage(){
        Singleton s = Singleton.getInstance();
//        String trainerName = s.getTrainerSelection();
        File file = new File("imagenes/entrenadores/"+ s.getTrainerSelection() + ".png");
        trainerImage.setImage(new Image(file.toURI().toString()));
    }

        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Singleton s = Singleton.getInstance();

        List<String> difficulty = new ArrayList<>();
        difficulty.add("Recluta");
        difficulty.add("Marine");
        difficulty.add("Veterano");
        difficulty.add("Pesadilla");
//        difficultySelection = new ComboBox<>(FXCollections.observableArrayList(difficulty));

        difficultySelection.setItems(FXCollections.observableArrayList(difficulty));

        if(s.getDifficultySelection()==null){
            difficultySelection.getSelectionModel().selectFirst();
            s.setDifficultySelection(difficultySelection.toString());
        }
        //Una vez que tengamos seleccionado un entrenador se cambia al entrenador seleccionado
        changeTrainerImage();
    }


}
