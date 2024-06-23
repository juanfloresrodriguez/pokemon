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
import javafx.scene.input.MouseEvent;
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
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

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
    private Button alphabeticalSort;

    @FXML
    private Button hpSort;

//    List<String> names = new ArrayList<>();
ObservableList<String> pokemonNamesList = FXCollections.observableArrayList();
ObservableList<String> pokemonNamesListHpSort = FXCollections.observableArrayList();

    @FXML
    void alphabeliticalPokedexSort() {
//        pokemonNames.setItems(FXCollections.observableArrayList(Query.allPokemonName()).sorted());

       pokemonNamesList.addAll(Query.allPokemonName());
       Collections.sort(pokemonNamesList);
       pokemonNames.getItems().addAll(pokemonNamesList);
       pokemonNames.getSelectionModel().selectFirst();
    }

    @FXML
    void hpPokedexSort() {
        pokemonNamesListHpSort.addAll(Query.allPokemonNameHpSorted());
//        Collections.sort(pokemonNamesListHpSort, new Comparador());
        pokemonNames.setItems(pokemonNamesListHpSort);
        pokemonNames.getSelectionModel().selectFirst();
    }

    @FXML
    void setPokemonImage(){
//        Establece las imagenes de los pokemons
        int idPokemon = Query.pokemonId(pokemonNames.getValue());

        InputStream is = PokedexController.class.getResourceAsStream("/imagenes/pokemon/"+idPokemon+".png");
        pokemon.setImage(new Image(is));
        getAtributes();
    }

    void getAtributes(){
//        Muestra los atributos de los pokemons
        List<Integer> atributes = new ArrayList<>();
        atributes.addAll(Query.pokemonAtributes(Query.pokemonId(pokemonNames.getValue())));

        int HP = atributes.get(0);
        int ATT = atributes.get(1);
        int SATT = atributes.get(2);
        int SPE = atributes.get(3);
        int DEF = atributes.get(4);

        String cadena = "Vida: " + HP + "\r\n" + "Ataques: " + ATT
                + "\r\n" + "Ataque Especial : " + SATT + "\r\n"
                + "Velocidad: " + SPE + "\r\n" + "Defensa: " + DEF;

        pokemonAtributes.setText(cadena);
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
        pokemonNames.setItems(FXCollections.observableArrayList(Query.allPokemonName()));
        pokemonNames.getSelectionModel().selectFirst();


        setPokemonImage();
    }
}
