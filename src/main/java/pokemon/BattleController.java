package pokemon;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Text atributtesTux;

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

    @FXML
    private ImageView pokemonSelected;

    @FXML
    private Button attackButton;

    @FXML
    private Button SpecialAttackButton;

    Pokemon pk1, pk2, pk3, pk4, pk5, pk6, tux, pkSelected;

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

    private void setTuxStats(Pokemon tux){
        double progress = (double) tux.hp / tux.maxHp;
        hpTux.setProgress(progress);
    }

    private void setTuxText() {
        atributtesTux.setText(tux.setTuxStats());
    }
    @FXML
    void attack() {
        tux.hp-=damage(pkSelected.getAtributes().get(1), pkSelected.getAtributes().get(4));

    }

    @FXML
    void specialAttack() {
        tux.hp-=damage(pkSelected.getAtributes().get(2), pkSelected.getAtributes().get(4));
    }

    private double typeMultiplier() {
        Singleton s = Singleton.getInstance();
        double resul = 0.0;
        if(pkSelected.getType() == "Normal" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[0][0];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[0][1];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Water"){
            resul = s.effectivenessChart[0][2];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[0][3];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[0][4];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[0][5];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[0][6];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[0][8];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[0][9];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[0][10];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[0][11];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[0][12];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[0][13];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[0][14];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[0][15];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[0][16];
        }else if(pkSelected.getType() == "Fire" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[1][0];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[1][1];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Water"){
            resul = s.effectivenessChart[1][2];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[1][3];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[1][4];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[1][5];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[1][6];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[1][8];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[1][9];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[1][10];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[1][11];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[1][12];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[1][13];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[1][14];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[1][15];
        }else if (pkSelected.getType() == "Fire" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[1][16];
        }else if(pkSelected.getType() == "Water" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[2][0];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[2][1];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Water"){
            resul = s.effectivenessChart[2][2];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[2][3];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[2][4];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[2][5];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[2][6];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[2][8];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[2][9];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[2][10];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[2][11];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[2][12];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[2][13];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[2][14];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[2][15];
        }else if (pkSelected.getType() == "Water" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[2][16];
        }else if(pkSelected.getType() == "Grass" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[3][0];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[3][1];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Water"){
            resul = s.effectivenessChart[3][2];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[3][3];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[3][4];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[3][5];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[3][6];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[3][8];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[3][9];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[3][10];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[3][11];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[3][12];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[3][13];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[3][14];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[3][15];
        }else if (pkSelected.getType() == "Grass" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[3][16];
        }else if(pkSelected.getType() == "Electric" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[4][0];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[4][1];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Water"){
            resul = s.effectivenessChart[4][2];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[4][3];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[4][4];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[4][5];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[4][6];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[4][8];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[4][9];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[4][10];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[4][11];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[4][12];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[4][13];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[4][14];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[4][15];
        }else if (pkSelected.getType() == "Electric" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[4][16];
        }else if(pkSelected.getType() == "Ice" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[5][0];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[5][1];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Water"){
            resul = s.effectivenessChart[5][2];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[5][3];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[5][4];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[5][5];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[5][6];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[5][8];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[5][9];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[5][10];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[5][11];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[5][12];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[5][13];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[5][14];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[5][15];
        }else if (pkSelected.getType() == "Ice" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[5][16];
        }else if(pkSelected.getType() == "Fighting" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[6][0];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[6][1];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Water"){
            resul = s.effectivenessChart[6][2];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[6][3];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[6][4];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[6][5];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[6][6];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[6][8];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[6][9];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[6][10];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[6][11];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[6][12];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[6][13];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[6][14];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[6][15];
        }else if (pkSelected.getType() == "Fighting" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[6][16];
        }else if(pkSelected.getType() == "Poison" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[7][0];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[7][1];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Water"){
            resul = s.effectivenessChart[7][2];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[7][3];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[7][4];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[7][5];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[7][6];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[7][8];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[7][9];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[7][10];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[7][11];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[7][12];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[7][13];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[7][14];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[7][15];
        }else if (pkSelected.getType() == "Poison" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[7][16];
        }else if(pkSelected.getType() == "Ground" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[8][0];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[8][1];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Water"){
            resul = s.effectivenessChart[8][2];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[8][3];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[8][4];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[8][5];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[8][6];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[8][8];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[8][9];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[8][10];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[8][11];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[8][12];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[8][13];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[8][14];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[8][15];
        }else if (pkSelected.getType() == "Ground" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[8][16];
        }else if(pkSelected.getType() == "Flying" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[9][0];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[9][1];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Water"){
            resul = s.effectivenessChart[9][2];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[9][3];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[9][4];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[9][5];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[9][6];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[9][8];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[9][9];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[9][10];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[9][11];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[9][12];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[9][13];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[9][14];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[9][15];
        }else if (pkSelected.getType() == "Flying" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[9][16];
        }else if(pkSelected.getType() == "Psychic" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[10][0];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[10][1];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Water"){
            resul = s.effectivenessChart[10][2];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[10][3];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[10][4];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[10][5];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[10][6];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[10][8];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[10][9];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[10][10];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[10][11];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[10][12];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[10][13];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[10][14];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[10][15];
        }else if (pkSelected.getType() == "Psychic" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[10][16];
        }else if(pkSelected.getType() == "Bug" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[11][0];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[11][1];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Water"){
            resul = s.effectivenessChart[11][2];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[11][3];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[11][4];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[11][5];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[11][6];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[11][8];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[11][9];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[11][10];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[11][11];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[11][12];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[11][13];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[11][14];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[11][15];
        }else if (pkSelected.getType() == "Normal" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[11][16];
        }else if(pkSelected.getType() == "Rock" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[12][0];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[12][1];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Water"){
            resul = s.effectivenessChart[12][2];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[12][3];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[12][4];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[12][5];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[12][6];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[12][8];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[12][9];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[12][10];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[12][11];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[12][12];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[12][13];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[12][14];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[12][15];
        }else if (pkSelected.getType() == "Rock" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[12][16];
        }else if(pkSelected.getType() == "Ghost" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[13][0];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[13][1];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Water"){
            resul = s.effectivenessChart[13][2];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[13][3];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[13][4];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[13][5];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[13][6];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[13][8];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[13][9];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[13][10];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[13][11];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[13][12];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[13][13];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[13][14];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[13][15];
        }else if (pkSelected.getType() == "Ghost" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[13][16];
        }else if(pkSelected.getType() == "Dark" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[14][0];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[14][1];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Water"){
            resul = s.effectivenessChart[14][2];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[14][3];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[14][4];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[14][5];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[14][6];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[14][8];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[14][9];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[14][10];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[14][11];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[14][12];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[14][13];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[14][14];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[14][15];
        }else if (pkSelected.getType() == "Dark" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[14][16];
        }else if(pkSelected.getType() == "Dragon" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[15][0];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[15][1];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Water"){
            resul = s.effectivenessChart[15][2];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[15][3];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[15][4];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[15][5];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[15][6];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[15][8];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[15][9];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[15][10];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[15][11];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[15][12];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[15][13];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[15][14];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[15][15];
        }else if (pkSelected.getType() == "Dragon" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[15][16];
        }else if(pkSelected.getType() == "Steel" && tux.getType() == "Normal"){
            resul = s.effectivenessChart[16][0];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Fire"){
            resul = s.effectivenessChart[16][1];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Water"){
            resul = s.effectivenessChart[16][2];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Grass"){
            resul = s.effectivenessChart[16][3];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Electric"){
            resul = s.effectivenessChart[16][4];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Ice"){
            resul = s.effectivenessChart[16][5];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Fighting"){
            resul = s.effectivenessChart[16][6];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Poison"){
            resul = s.effectivenessChart[16][8];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Ground"){
            resul = s.effectivenessChart[16][9];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Flying"){
            resul = s.effectivenessChart[16][116];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Psychic"){
            resul = s.effectivenessChart[16][11];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Bug"){
            resul = s.effectivenessChart[16][12];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Rock"){
            resul = s.effectivenessChart[16][13];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Ghost"){
            resul = s.effectivenessChart[16][14];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Dark"){
            resul = s.effectivenessChart[16][15];
        }else if (pkSelected.getType() == "Steel" && tux.getType() == "Steel"){
            resul = s.effectivenessChart[16][16];
        }
        
        return resul;
    }

    private double damage(int power, int defense){
        double b, e, v, n, a, p, d;
        double damage;
        n=pkSelected.level;
        a=1;
        p=power;
        d=defense;
        b=typeMultiplier();
        e=1;
        v=(int) (Math.random()*100)+85;

        damage = 0.01 * b * e * v * ((((0.2*n+1)*a*p)/25*d)+2);

        return damage;
    }

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
       try {

            tux = new Tux(1);
            setTuxStats(tux);
            setTuxText();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error creating Tux: " + e.getMessage()); // Debugging statement
        }
        //Inicicializamos los Pokemons
        List<Integer> pokemonId = new ArrayList<>();
        pokemonId.addAll(s.getPokemonId());

        switch (pokemonId.size()){

            case 1:
                pk1 = new Pokemon(pokemonId.get(0));
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

