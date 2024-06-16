package pokemon;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
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
    private TextArea log;

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

    @FXML
    private Text diedTuxCounter;

    List<Pokemon> pokemonList;

    ImageView[] pokemonImages;

    Text[] pokemonAtributtes;

    private int countTux = 0;

    Pokemon pk1, pk2, pk3, pk4, pk5, pk6, tux, pkSelected;
    private String logMessage = "";

    public String getLogMessage()
    {
        return logMessage;
    }

    public void setLogMessage(String status)
    {

        logMessage = logMessage + " \n" + status;
    }

    void setBattleStage(){
        File file, back, tux;

        back = new File("imagenes/battle_background.jpg");
        background.setImage(new Image(back.toURI().toString()));

        tux = new File("imagenes/pokemon/tux.png");
        imageTux.setImage(new Image(tux.toURI().toString()));

        for(int i =0; i<pokemonList.size(); i++){
            file = new File("imagenes/pokemon/" + pokemonList.get(i).getId() + ".png");
            pokemonImages[i].setImage(new Image(file.toURI().toString()));
        }

        int count = 6 - pokemonList.size();
        int numPokemon = pokemonList.size();
        if(count >0) {
            for (int i = 0; i < count; i++) {
                file = new File("imagenes/pokeball/pokeball.png");
                pokemonImages[numPokemon+i].setImage(new Image(file.toURI().toString()));
            }
        }
    }

    private void setStats(){
        for(int i=0; i<this.pokemonList.size(); i++){
            pokemonAtributtes[i].setText(pokemonList.get(i).getPokemonAtributes());
        }
    }

    private void setTuxStats(Pokemon tux){
        double progress = (double) tux.getAtributes().get(0) / tux.maxHp;
        hpTux.setProgress(progress);
    }

    private void setTuxText() {
        atributtesTux.setText(tux.setTuxStats());
        diedTuxCounter.setText("Tux muertos: " + countTux);
    }

    @FXML
    void attack() throws InterruptedException {
        double damage = damage(pkSelected.getAtributes().get(1), pkSelected.getAtributes().get(4));
        double initialHealth = tux.getAtributes().get(0);

        tux.atributes.set(0, (int) (initialHealth - damage));

        setLogMessage(pkSelected.getName() + " ha realizado un Ataque normal a Tux realizando " + (int) damage + " daño.");
        log.setText(logMessage);

        gameplay();
    }

    @FXML
    void specialAttack() throws InterruptedException {
        double damage = damage(pkSelected.getAtributes().get(2), pkSelected.getAtributes().get(4));
        double initialHealth = tux.getAtributes().get(0);

        tux.atributes.set(0, (int) (initialHealth - damage));

        setLogMessage(pkSelected.getName() + " ha realizado un Ataque especial a Tux realizando " + (int) damage + " daño.");
        log.setText(logMessage);

        gameplay();
    }

    private double typeMultiplier() {
        Singleton s = Singleton.getInstance();
        
        return s.effectivenessChart[pkSelected.getType()][tux.getType()];
    }

    private int damage(int power, int defense){
        double b, e, v, n, a, p, d;
        double damage;
        n=pkSelected.level;
        a=1;
        p=power;
        d=defense;
        b=typeMultiplier();
        e=1;
        v=(int) (Math.random()*100+85);

        double upperOperation = (0.2 * n  + 1) * a * p ;
        double downOperation = 25 * d;

        damage = 0.1 * b * e * v * ((upperOperation/downOperation)+2);

        return (int) damage;
    }

    private int damageTux(int power, int defense){
        double b, e, v, n, a, p, d;
        double damage;
        n=tux.level;
        a=1;
        p=power;
        d=defense;
        b=typeMultiplier();
        e=1;
        v=(int) (Math.random()*100)+85;

        double upperOperation = (0.2 * n  + 1) * a * p ;
        double downOperation = 25 * d;

        damage = 0.1 * b * e * v * ((upperOperation/downOperation)+2);


        setLogMessage("Tux ha atacado a " + pkSelected.getName() +" realizando " + (int) damage + " daño.");
        log.setText(logMessage);
        return (int) damage;
    }

    private void tuxAttack() throws InterruptedException {
        int prob = (int) (Math.random()*20);
        if (prob < 20) {
//            pkSelected.hp-=damageTux(tux.getAtributes().get(2), tux.getAtributes().get(4));

            double damage = damageTux(tux.getAtributes().get(2), tux.getAtributes().get(4));
            double initialHealth = pkSelected.getAtributes().get(0);

            pkSelected.atributes.set(0, (int) (initialHealth - damage));
        }else{
//            pkSelected.hp-=damageTux(tux.getAtributes().get(1), tux.getAtributes().get(4));
            double damage = damageTux(tux.getAtributes().get(1), tux.getAtributes().get(4));
            double initialHealth = pkSelected.getAtributes().get(0);

            pkSelected.atributes.set(0, (int) (initialHealth - damage));
        }

        Thread.sleep(1000);
    }

    private void reloadStats() {
        setStats();
        setTuxText();
        setTuxStats(tux);
    }

    private void gameOperations() throws InterruptedException {
        if (tux.atributes.get(0)<= 0) {
            tux = new Tux(1);
            reloadStats();
            countTux++;
        }else if (pkSelected.getAtributes().get(0) <= 0) {
            File pk = new File("imagenes/pokemon/died.png");
            imageAttack.setImage(new Image(pk.toURI().toString()));

        }
        if(pkSelected.getAtributes().get(0) > 0) {

            reloadStats();

            attackButton.setDisable(true);
            SpecialAttackButton.setDisable(true);
            tuxAttack();
            attackButton.setDisable(false);
            SpecialAttackButton.setDisable(false);
            reloadStats();
        }
    }

    private void gameplay() throws InterruptedException {
        int cont=0;
        if(pkSelected != null || pkSelected.getAtributes().get(0) > 0) {
               gameOperations();
        }else {
            int speed = 0;
            int selected = 0;
            for (int i = 0; i < pokemonList.size(); i++) {
                if (pokemonList.get(i).getAtributes().get(3) > speed) {
                    speed = pokemonList.get(i).getAtributes().get(3);
                    selected = i;
                }
            }
            //colocamos el pokemon que más velocidad tiene
            try {
                File pk = new File("imagenes/pokemon/" + pokemonList.get(selected).getId() + ".png");
                imageAttack.setImage(new Image(pk.toURI().toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            pkSelected = pokemonList.get(selected);
            System.out.println(pkSelected.name);

        }
    }


    @FXML
    void onDragDetected(MouseEvent event) {
        /* drag was detected, start drag-and-drop gesture*/
//        System.out.println("onDragDetected");
        /* allow any transfer mode */
        Node source = (Node) event.getSource();
        ImageView imagenArrastrada = (ImageView) source;
        String imageUrl = imagenArrastrada.getImage().getUrl();
        String nombreImagen = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);
        System.out.println(imageUrl);
        System.out.println(nombreImagen);
        if(nombreImagen.equals( "pokeball.png")){
            return;
        }

        Dragboard db = ((ImageView) event.getSource()).startDragAndDrop(TransferMode.ANY);
        /* put a string on dragboard */
        ClipboardContent content = new ClipboardContent();
        pokemonSelected = (ImageView) event.getSource();
        content.putImage(pokemonSelected.getImage());
        content.putString(nombreImagen.split("\\.")[0]);
        db.setContent(content);
        event.consume();
    }

    @FXML
    void onDragDone(DragEvent event) {
        /* the drag-and-drop gesture ended */
//        System.out.println("onDragDone");
        /* if the data was successfully moved, clear it */
        if (event.getTransferMode() == TransferMode.MOVE) {
            // Any cleanup code if needed

        }
        event.consume();
    }

    @FXML
    void onDragDropped(DragEvent event) {
        /* data dropped */
//        System.out.println("onDragDropped");
        /* if there is an image data on dragboard, read it and use it */
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasImage()) {
            Image droppedImage = db.getImage();
            imageAttack.setImage(droppedImage);
            success = true;
        }
        int idPokemon = Integer.parseInt(db.getString());
        for(int i =0; i<pokemonList.size(); i++){
            if(idPokemon == pokemonList.get(i).id ){
                pkSelected = pokemonList.get(i);
            }
        }
        /* let the source know whether the image was successfully
         * transferred and used */
        event.setDropCompleted(success);
        event.consume();
    }

    @FXML
    void onDragEntered(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
//        System.out.println("onDragEntered");
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
//        System.out.println("onDragOver");
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
        try {
            Singleton s = Singleton.getInstance();
            s.getTrainerPokemonMap();
            pokemonImages = new ImageView[] {pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6};
            pokemonAtributtes = new Text[] {atributtesPokemon1, atributtesPokemon2, atributtesPokemon3, atributtesPokemon4, atributtesPokemon5, atributtesPokemon6};

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

            this.pokemonList = new ArrayList<>();
            for (int i = 0; i < pokemonId.size(); i++) {
                this.pokemonList.add(new Pokemon(pokemonId.get(i)));
            }

            setBattleStage();
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(pkSelected == null) {
            int speed = 0;
            int selected = 0;
            for (int i = 0; i < pokemonList.size(); i++) {
                if (pokemonList.get(i).getAtributes().get(3) > speed) {
                    speed = pokemonList.get(i).getAtributes().get(3);
                    selected = i;
                }
            }
            //colocamos el pokemon que más velocidad tiene
            try {
                File pk = new File("imagenes/pokemon/" + pokemonList.get(selected).getId() + ".png");
                imageAttack.setImage(new Image(pk.toURI().toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            pkSelected = pokemonList.get(selected);
            setLogMessage("Se ha elegido el pokemon con mayor velocidad para comenzar la partida: " + pkSelected.getName());
            log.setText(logMessage);
        }
    }
}

