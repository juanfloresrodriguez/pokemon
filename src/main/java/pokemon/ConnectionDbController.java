package pokemon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void saveConnection() {
    }

    public void testConnection() {
//        logger.debug("testConnection");
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

