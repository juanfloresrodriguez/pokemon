package pokemon;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
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
    private ProgressBar hpTux;

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

    private ImageView pokemonSelected;

    Pokemon pk1, pk2, pk3, pk4, pk5, pk6, tux;

    @FXML
    void setPokemonImages(){
        Singleton s = Singleton.getInstance();

        List<Integer> pokemonId = new ArrayList<>();
        pokemonId.addAll(s.getPokemonId());

        File file, file1, file2, file3, file4, file5, back, tux;

        back = new File("imagenes/battle_background.jpg");
        background.setImage(new Image(back.toURI().toString()));

        tux = new File("imagenes/pokemon/tux.png");
        imageTux.setImage(new Image(tux.toURI().toString()));

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

    private void setStats(){
        Singleton s = Singleton.getInstance();
        String cadena1, cadena2, cadena3, cadena4, cadena5, cadena6;

        switch (s.getPokemonId().size()){
            case 1:
                cadena1=pk1.setPokemonAtributes();
                atributtesPokemon1.setText(cadena1);
                break;
            case 2:
                cadena1=pk1.setPokemonAtributes();
                atributtesPokemon1.setText(cadena1);
                cadena2=pk2.setPokemonAtributes();
                atributtesPokemon2.setText(cadena2);
                break;
            case 3:
                cadena1=pk1.setPokemonAtributes();
                atributtesPokemon1.setText(cadena1);
                cadena2=pk2.setPokemonAtributes();
                atributtesPokemon2.setText(cadena2);
                cadena3=pk3.setPokemonAtributes();
                atributtesPokemon3.setText(cadena3);
                break;
            case 4:
                cadena1=pk1.setPokemonAtributes();
                atributtesPokemon1.setText(cadena1);
                cadena2=pk2.setPokemonAtributes();
                atributtesPokemon2.setText(cadena2);
                cadena3=pk3.setPokemonAtributes();
                atributtesPokemon3.setText(cadena3);
                cadena4=pk4.setPokemonAtributes();
                atributtesPokemon4.setText(cadena4);
                break;
            case 5:
                cadena1=pk1.setPokemonAtributes();
                atributtesPokemon1.setText(cadena1);
                cadena2=pk2.setPokemonAtributes();
                atributtesPokemon2.setText(cadena2);
                cadena3=pk3.setPokemonAtributes();
                atributtesPokemon3.setText(cadena3);
                cadena4=pk4.setPokemonAtributes();
                atributtesPokemon4.setText(cadena4);
                cadena5=pk5.setPokemonAtributes();
                atributtesPokemon5.setText(cadena5);
                break;
            case 6:
                cadena1=pk1.setPokemonAtributes();
                atributtesPokemon1.setText(cadena1);
                cadena2=pk2.setPokemonAtributes();
                atributtesPokemon2.setText(cadena2);
                cadena3=pk3.setPokemonAtributes();
                atributtesPokemon3.setText(cadena3);
                cadena4=pk4.setPokemonAtributes();
                atributtesPokemon4.setText(cadena4);
                cadena5=pk5.setPokemonAtributes();
                atributtesPokemon5.setText(cadena5);
                cadena6=pk6.setPokemonAtributes();
                atributtesPokemon6.setText(cadena6);
                break;
        }
    }

//    private void setTuxStats(){
//        double progress = (double) tux.hp / tux.maxHp;
//        hpTux.setProgress(progress);
//    }

    @FXML
    void onDragDetected(MouseEvent event) {
        /* drag was detected, start drag-and-drop gesture*/
        System.out.println("onDragDetected");
        /* allow any transfer mode */
        Dragboard db = ((ImageView) event.getSource()).startDragAndDrop(TransferMode.ANY);
        /* put a string on dragboard */
        ClipboardContent content = new ClipboardContent();
        pokemonSelected = (ImageView) event.getSource();
        content.putImage(pokemonSelected.getImage());
        db.setContent(content);
        event.consume();
    }

    @FXML
    void onDragDone(DragEvent event) {
        /* the drag-and-drop gesture ended */
        System.out.println("onDragDone");
        /* if the data was successfully moved, clear it */
        if (event.getTransferMode() == TransferMode.MOVE) {
            // Any cleanup code if needed
        }
        event.consume();
    }

    @FXML
    void onDragDropped(DragEvent event) {
        /* data dropped */
        System.out.println("onDragDropped");
        /* if there is an image data on dragboard, read it and use it */
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasImage()) {
            Image droppedImage = db.getImage();
            imageAttack.setImage(droppedImage);
            success = true;
        }
        /* let the source know whether the image was successfully
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
                event.getDragboard().hasImage()) {
            imageAttack.setOpacity(0.3); // Highlight effect
        }
        event.consume();
    }

    @FXML
    void onDragExited(DragEvent event) {
        /* mouse moved away, remove the graphical cues */
        imageAttack.setOpacity(1.0); // Remove highlight effect
        event.consume();
    }

    @FXML
    void onDragOver(DragEvent event) {
        /* data is dragged over the target */
        System.out.println("onDragOver");
        /* accept it only if it is not dragged from the same node
         * and if it has an image data */
        if (event.getGestureSource() != imageAttack &&
                event.getDragboard().hasImage()) {
            /* allow for both copying and moving, whatever user chooses */
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setPokemonImages();
        Singleton s = Singleton.getInstance();
        s.getTrainerPokemonMap();

        //Iniciamos al tux
//        tux = new Tux();
//        setTuxStats();
        //Inicicializamos los Pokemons
        List<Integer> pokemonId = new ArrayList<>();
        pokemonId.addAll(s.getPokemonId());

        switch (pokemonId.size()){

            case 1:
                pk1 = new Pokemon(pokemonId.get(0));
//                tux = new Tux(0);
                break;
            case 2:
                pk1 = new Pokemon(pokemonId.get(0));
                pk2 = new Pokemon(pokemonId.get(1));
                break;
            case 3:
                pk1 = new Pokemon(pokemonId.get(0));
                pk2 = new Pokemon(pokemonId.get(1));
                pk3 = new Pokemon(pokemonId.get(2));

                break;
            case 4:
                pk1 = new Pokemon(pokemonId.get(0));
                pk2 = new Pokemon(pokemonId.get(1));
                pk3 = new Pokemon(pokemonId.get(2));
                pk4 = new Pokemon(pokemonId.get(3));
                break;
            case 5:
                pk1 = new Pokemon(pokemonId.get(0));
                pk2 = new Pokemon(pokemonId.get(1));
                pk3 = new Pokemon(pokemonId.get(2));
                pk4 = new Pokemon(pokemonId.get(3));
                pk5 = new Pokemon(pokemonId.get(4));
                break;
            case 6:
                pk1 = new Pokemon(pokemonId.get(0));
                pk2 = new Pokemon(pokemonId.get(1));
                pk3 = new Pokemon(pokemonId.get(2));
                pk4 = new Pokemon(pokemonId.get(3));
                pk5 = new Pokemon(pokemonId.get(4));
                pk6 = new Pokemon(pokemonId.get(5));
                break;
        }

        setStats();
        // Establecemos los atributos para que se puedan arrastrar los pokemon
        ImageView[] pokemons = {pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6};
        for (ImageView pokemon : pokemons) {
            pokemon.setOnDragDetected(this::onDragDetected);
            pokemon.setOnDragDone(this::onDragDone);
        }
        imageAttack.setOnDragOver(this::onDragOver);
        imageAttack.setOnDragDropped(this::onDragDropped);
        imageAttack.setOnDragEntered(this::onDragEntered);
        imageAttack.setOnDragExited(this::onDragExited);
    }

}

