package pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {

    @FXML
    public ComboBox difficultySelection;

    @FXML
    private Button databaseReturn;

    @FXML
    private Button helpWindow;

    @FXML
    private Button playButton;

    @FXML
    private Button pokedexWindows;

    @FXML
    private Button programExit;

    @FXML
    private Button trainerWindows;

    @FXML
    void exitProgram() {
        System.exit(0);
    }

    @FXML
    void openGame() {

    }

    @FXML
    void openHelpWindow() {

    }

    @FXML
    void openPokedexWindow() {

    }

    @FXML
    void openTrainerWindows() {

    }

    @FXML
    void returnDatabase() {

    }

    @FXML
    public void selectDifficulty() {

    }

        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> difficulty = new ArrayList<>();
        difficulty.add("Recluta");
        difficulty.add("Marine");
        difficulty.add("Veterano");
        difficulty.add("Pesadilla");
//        difficultySelection = new ComboBox<>(FXCollections.observableArrayList(difficulty));

        difficultySelection.setItems(FXCollections.observableArrayList(difficulty));
    }


}
