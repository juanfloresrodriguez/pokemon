package pokemon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class EndGameController implements Initializable {
    @FXML
    private ImageView background;

    @FXML
    private Button exitButton;

    @FXML
    void exit() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InputStream is = PokedexController.class.getResourceAsStream("/imagenes/dead.gif");
        background.setImage(new Image(is));

    }
}