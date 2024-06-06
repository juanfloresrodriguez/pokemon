package pokemon;

public class Singleton {
    private final static Singleton INSTANCE = new Singleton();

    private Singleton() {}


    public static Singleton getInstance() {
        return INSTANCE;
    }

    private String databaseURL;
    private String databaseUser;
    private String databasePassword;
    private String databaseName;
    private String databasePort;

    public String getDatabaseURL() {
        return databaseURL;
    }

    public void setDatabaseURL(String databaseURL) {
        this.databaseURL = databaseURL;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(String databaseType) {
        this.databasePort = databaseType;
    }






}
