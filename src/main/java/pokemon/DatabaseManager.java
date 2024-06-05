package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    public DatabaseManager() {}

    public static boolean testConnection(String databaseIp, String databasePort, String databaseName, String databaseUser, String databasePassword) {
        try {
            String url = "jdbc:mysql://" + databaseIp + ":" + databasePort + "/" + databaseName;
            Connection conenction = DriverManager.getConnection(url, databaseUser, databasePassword);
            boolean isConnectionValid = conenction.isValid(30);

            conenction.close();//Cierra conexión con la BBDD
            return isConnectionValid;
        } catch (Exception ex) {
            return false;
        }
    }
}
