package pokemon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

//Hay que implementarlo en el singleton
public class ConnectionDbController implements Initializable {
    private static final Logger logger = LogManager.getLogger(ConnectionDbController.class);

    @FXML
    public Text connectionStatus;

    @FXML
    private TextField databaseName;

    @FXML
    private Button databaseAcept;

    @FXML
    private Button databaseExit;

    @FXML
    private TextField databaseIP;

    @FXML
    private TextField databasePass;

    @FXML
    private TextField databasePort;

    @FXML
    private Button databaseTest;

    @FXML
    private TextField databaseUser;

    @FXML
    private TextField driver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void saveConnection() {
        Singleton s = Singleton.getInstance();
        if(DatabaseManager.testConnection(databaseIP.getText(), databasePort.getText(), databaseName.getText(), databaseUser.getText(), databasePass.getText())) {
            s.setDatabaseIp(databaseIP.getText());
            s.setDatabasePort(databasePort.getText());
            s.setDatabaseName(databaseName.getText());
            s.setDatabaseUser(databaseUser.getText());
            s.setDatabasePassword(databasePass.getText());
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("mainMenu.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Menú Principal");
            stage.setScene(scene);
            stage.show();

            //cerramos la ventana actual buscando su referencia a través de algún
            //control (en este caso el botón 'abrir1'
            Stage closeStage = (Stage) databaseAcept.getScene().getWindow();

            closeStage.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testConnection() {
        connectionStatus.setText("Intentando conectar ...");
        boolean isConnected = DatabaseManager.testConnection(databaseIP.getText(), databasePort.getText(), databaseName.getText(), databaseUser.getText(), databasePass.getText());
        if(isConnected) {
            connectionStatus.setText("Test Superado, la conexión ha sido un exito");
        } else {
            connectionStatus.setText("No se ha podio conectar");
        }
    }

    public void exitProgram() {
        System.out.println("Has salido del programa");
        System.exit(0);

    }
}

