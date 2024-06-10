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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PokedexController implements Initializable {

    @FXML
    private ImageView pokemon;

    @FXML
    private Text pokemonAtributes;

    @FXML
    private ComboBox<String> pokemonNames;

    @FXML
    private Button returnButton;

    @FXML
    void setPokemonImage() {
        int idPokemon = Query.pokemonId(pokemonNames.getValue());
        File file = new File("imagenes/pokemon/" + idPokemon  + ".png");
        pokemon.setImage(new Image(file.toURI().toString()));
    }

    void getAtributes(){
        List<String> atributes = new ArrayList<>();
        atributes.addAll(Query.pokemonAtributes(Query.pokemonId(pokemonNames.getValue())));

        String HP = atributes.get(1);
        String ATT = atributes.get(2);
        String SATT = atributes.get(3);
        String SPE = atributes.get(4);
        String DEF = atributes.get(5);

        pokemonAtributes.setText("Hola");
//        pokemonAtributes.setText("Vida: " + HP + "Ataques: " + ATT + "Ataque Especial : " + SATT + "Velocidad: " + SPE + "Defensa: " + DEF);
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
        System.out.println(Query.allPokemonName().size());
        pokemonNames.setItems(FXCollections.observableArrayList(Query.allPokemonName()));

        pokemonNames.getSelectionModel().selectFirst();


        setPokemonImage();
    }
}
