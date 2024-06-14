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


    @FXML
    void setTrainerImage(){
//Convierte el nombre seleccionado del comboBox lo convierte a un string y llama a la foto que se llama así
        String name = trainerName.getValue();
        File file = new File("imagenes/entrenadores/" + name + ".png");
        trainer.setImage(new Image(file.toURI().toString()));

        s.setTrainerSelection(name);
        setPokemonTrainer();
    }

    @FXML
    void setPokemonTrainer(){
        List<Integer> pokemonId = new ArrayList<>();
        pokemonId.addAll(Query.trainerPokemon());
        System.out.println(pokemonId.size());

        File file, file1, file2, file3, file4, file5;

        switch(pokemonId.size()) {
            case 1: //Un solo pokemon
                file = new File("imagenes/pokemon/" + pokemonId.get(0) + ".png");
                pokemon1.setImage(new Image(file.toURI().toString()));
                //POKEBALLS
                file1 = new File("imagenes/pokemon/pokeball.png");
                pokemon2.setImage(new Image(file1.toURI().toString()));

                file2 = new File("imagenes/pokemon/pokeball.png");
                pokemon3.setImage(new Image(file2.toURI().toString()));

                file3 = new File("imagenes/pokemon/pokeball.png");
                pokemon4.setImage(new Image(file3.toURI().toString()));

                file4 = new File("imagenes/pokemon/pokeball.png");
                pokemon5.setImage(new Image(file4.toURI().toString()));

                file5 = new File("imagenes/pokemon/pokeball.png");
                pokemon6.setImage(new Image(file5.toURI().toString()));
                break;
            case 2:
                file = new File("imagenes/pokemon/" + pokemonId.get(0) + ".png");
                pokemon1.setImage(new Image(file.toURI().toString()));

                file1 = new File("imagenes/pokemon/" + pokemonId.get(1) + ".png");
                pokemon2.setImage(new Image(file1.toURI().toString()));

                //POKEBALLS
                file2 = new File("imagenes/pokemon/pokeball.png");
                pokemon3.setImage(new Image(file2.toURI().toString()));

                file3 = new File("imagenes/pokemon/pokeball.png");
                pokemon4.setImage(new Image(file3.toURI().toString()));

                file4 = new File("imagenes/pokemon/pokeball.png");
                pokemon5.setImage(new Image(file4.toURI().toString()));

                file5 = new File("imagenes/pokemon/pokeball.png");
                pokemon6.setImage(new Image(file5.toURI().toString()));

                break;
            case 3:
                file = new File("imagenes/pokemon/" + pokemonId.get(0) + ".png");
                pokemon1.setImage(new Image(file.toURI().toString()));

                file1 = new File("imagenes/pokemon/" + pokemonId.get(1) + ".png");
                pokemon2.setImage(new Image(file1.toURI().toString()));

                file2 = new File("imagenes/pokemon/" + pokemonId.get(2) + ".png");
                pokemon3.setImage(new Image(file2.toURI().toString()));

                //POKEBALLS
                file3 = new File("imagenes/pokemon/pokeball.png");
                pokemon4.setImage(new Image(file3.toURI().toString()));

                file4 = new File("imagenes/pokemon/pokeball.png");
                pokemon5.setImage(new Image(file4.toURI().toString()));

                file5 = new File("imagenes/pokemon/pokeball.png");
                pokemon6.setImage(new Image(file5.toURI().toString()));

                break;
            case 4:
                file = new File("imagenes/pokemon/" + pokemonId.get(0) + ".png");
                pokemon1.setImage(new Image(file.toURI().toString()));

                file1 = new File("imagenes/pokemon/" + pokemonId.get(1) + ".png");
                pokemon2.setImage(new Image(file1.toURI().toString()));

                file2 = new File("imagenes/pokemon/" + pokemonId.get(2) + ".png");
                pokemon3.setImage(new Image(file2.toURI().toString()));

                file3 = new File("imagenes/pokemon/" + pokemonId.get(3) + ".png");
                pokemon4.setImage(new Image(file3.toURI().toString()));

                //POKEBALLS
                file4 = new File("imagenes/pokemon/pokeball.png");
                pokemon5.setImage(new Image(file4.toURI().toString()));

                file5 = new File("imagenes/pokemon/pokeball.png");
                pokemon6.setImage(new Image(file5.toURI().toString()));

                break;
            case 5:
                file = new File("imagenes/pokemon/" + pokemonId.get(0) + ".png");
                pokemon1.setImage(new Image(file.toURI().toString()));

                file1 = new File("imagenes/pokemon/" + pokemonId.get(1) + ".png");
                pokemon2.setImage(new Image(file1.toURI().toString()));

                file2 = new File("imagenes/pokemon/" + pokemonId.get(2) + ".png");
                pokemon3.setImage(new Image(file2.toURI().toString()));

                file3 = new File("imagenes/pokemon/" + pokemonId.get(3) + ".png");
                pokemon4.setImage(new Image(file3.toURI().toString()));

                file4 = new File("imagenes/pokemon/" + pokemonId.get(4) + ".png");
                pokemon5.setImage(new Image(file4.toURI().toString()));

                //POKEBALLS
                file5 = new File("imagenes/pokemon/pokeball.png");
                pokemon6.setImage(new Image(file5.toURI().toString()));

                break;
            case 6:
                file = new File("imagenes/pokemon/" + pokemonId.get(0) + ".png");
                pokemon1.setImage(new Image(file.toURI().toString()));

                file1 = new File("imagenes/pokemon/" + pokemonId.get(1) + ".png");
                pokemon2.setImage(new Image(file1.toURI().toString()));

                file2 = new File("imagenes/pokemon/" + pokemonId.get(2) + ".png");
                pokemon3.setImage(new Image(file2.toURI().toString()));

                file3 = new File("imagenes/pokemon/" + pokemonId.get(3) + ".png");
                pokemon4.setImage(new Image(file3.toURI().toString()));

                file4 = new File("imagenes/pokemon/" + pokemonId.get(4) + ".png");
                pokemon5.setImage(new Image(file4.toURI().toString()));

                file5 = new File("imagenes/pokemon/" + pokemonId.get(5) + ".png");
                pokemon6.setImage(new Image(file5.toURI().toString()));
                break;
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


        if(s.getTrainerSelection()==null){
            trainerName.getSelectionModel().selectFirst();
        }

        setTrainerImage();


    }
}
