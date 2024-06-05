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
}
