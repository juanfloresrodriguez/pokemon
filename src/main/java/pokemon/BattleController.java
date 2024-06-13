package pokemon;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BattleController implements Initializable {

    @FXML
    private Text atributtesPokemon1;

    @FXML
    private Text atributtesPokemon2;

    @FXML
    private Text atributtesPokemon3;

    @FXML
    private Text atributtesPokemon4;

    @FXML
    private Text atributtesPokemon5;

    @FXML
    private Text atributtesPokemon6;

    @FXML
    private ImageView background;

    @FXML
    private ProgressBar hpPokemo1;

    @FXML
    private ProgressBar hpPokemon2;

    @FXML
    private ProgressBar hpPokemon3;

    @FXML
    private ProgressBar hpPokemon4;

    @FXML
    private ProgressBar hpPokemon5;

    @FXML
    private ProgressBar hpPokemon6;

    @FXML
    private ImageView imageAttack;

    @FXML
    private ImageView imageTux;

    @FXML
    private TextField log;

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
    void setPokemonImages(){
        Singleton s = Singleton.getInstance();

        List<Integer> pokemonId = new ArrayList<>();
        pokemonId.addAll(s.getTrainerPokemon());

        File file, file1, file2, file3, file4, file5, back;

        back = new File("imagenes/battle_background.jpg");
        background.setImage(new Image(back.toURI().toString()));

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
    }

    @FXML
    void onDragDetected(MouseEvent event) {
        /* drag was detected, start drag-and-drop gesture*/
        System.out.println("onDragDetected");

        /* allow any transfer mode */
        Dragboard db = pokemon1.startDragAndDrop(TransferMode.ANY);

        /* put a string on dragboard */
        ClipboardContent content = new ClipboardContent();
//        content.putString();
        db.setContent(content);

        event.consume();
    }

    @FXML
    void onDragDone(DragEvent event) {
        /* the drag-and-drop gesture ended */
        System.out.println("onDragDone");
        /* if the data was successfully moved, clear it */
        if (event.getTransferMode() == TransferMode.MOVE) {

        }

        event.consume();
    }

    @FXML
    void onDragDropped(DragEvent event) {
        /* data dropped */
        System.out.println("onDragDropped");
        /* if there is a string data on dragboard, read it and use it */
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            File attack = new File("imagenes/pokemon/78.png");
            imageAttack.setImage(new Image(attack.toURI().toString()));
            success = true;
        }
        /* let the source know whether the string was successfully
         * transferred and used */
        event.setDropCompleted(success);

        event.consume();
    }

    @FXML
    void onDragEntered(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
        System.out.println("onDragEntered");
        /* show to the user that it is an actual gesture target */
        if (event.getGestureSource() != imageAttack &&
                event.getDragboard().hasString()) {
            File attack = new File("imagenes/pokemon/78.png");
            imageAttack.setImage(new Image(attack.toURI().toString()));
        }

        event.consume();
    }

    @FXML
    void onDragExited(DragEvent event) {
        /* mouse moved away, remove the graphical cues */
        File attack = new File("imagenes/pokemon/78.png");
        imageAttack.setImage(new Image(attack.toURI().toString()));

        event.consume();
    }

    @FXML
    void onDragOver(DragEvent event) {
        /* data is dragged over the target */
        System.out.println("onDragOver");

        /* accept it only if it is  not dragged from the same node
         * and if it has a string data */
        if (event.getGestureSource() != imageAttack &&
                event.getDragboard().hasString()) {
            /* allow for both copying and moving, whatever user chooses */
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        event.consume();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setPokemonImages();
    }
}

