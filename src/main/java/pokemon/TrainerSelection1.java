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
import java.io.InputStream;
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
    private ImageView pokemon1;

    @FXML
    private ImageView pokemon2;

    @FXML
    private ImageView pokemon3;

    @FXML
    private ImageView pokemon4;

    @FXML
    private ImageView pokemon5;

    @FXML
    private ImageView pokemon6;

    ImageView[] pokemonImages;
    List<Pokemon> pokemonList;

    @FXML
    void setTrainerImage(){
//Convierte el nombre seleccionado del comboBox lo convierte a un string y llama a la foto que se llama así
        String name = trainerName.getValue();
        InputStream is = PokedexController.class.getResourceAsStream("/imagenes/entrenadores/" + name + ".png");
        trainer.setImage(new Image(is));

        s.setTrainerSelection(name);
        setPokemonTrainer();
    }

    @FXML
    void setPokemonTrainer(){
        List<Integer> pokemonId = new ArrayList<>();
        pokemonId.addAll(Query.trainerPokemon());

        this.pokemonList = new ArrayList<>();
        for (int i = 0; i < pokemonId.size(); i++) {
            this.pokemonList.add(new Pokemon(pokemonId.get(i)));
        }

        for(int i =0; i<pokemonList.size(); i++){
            InputStream is = PokedexController.class.getResourceAsStream("/imagenes/pokemon/" + pokemonList.get(i).getId() + ".png");
            pokemonImages[i].setImage(new Image(is));
        }

        int count = 6 - pokemonList.size();
        int numPokemon = pokemonList.size();
        if(count >0) {
            for (int i = 0; i < count; i++) {
                InputStream is = PokedexController.class.getResourceAsStream("/imagenes/pokeball/pokeball.png");
                pokemonImages[numPokemon+i].setImage(new Image(is));
            }
        }

        //Establecemos los pokemon del entrenador en el Singleton
        s.setPokemonId(pokemonId);
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
        trainerName.setItems(FXCollections.observableArrayList(Query.trainersNames()));
        pokemonImages = new ImageView[] {pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6};

        if(s.getTrainerSelection()==null){
            trainerName.getSelectionModel().selectFirst();
        }

        setTrainerImage();
    }
}
