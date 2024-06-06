package pokemon;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpWindow {

    @FXML
    private Button closeButton;

    @FXML
    void closeWindows() {
            //cerramos la ventana actual
            Stage closeWindow = (Stage) closeButton.getScene().getWindow();

            closeWindow.close();

    }

}
