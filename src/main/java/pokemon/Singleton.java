package pokemon;

import java.util.List;

public class Singleton {
    private final static Singleton INSTANCE = new Singleton();

    private Singleton() {}


    public static Singleton getInstance() {
        return INSTANCE;
    }

    private String databaseIp;
    private String databaseUser;
    private String databasePassword;
    private String databaseName;
    private String databasePort;
    private String difficultySelection;
    private String trainerSelection;
    private List<Integer> trainerPokemon;

    public String getTrainerSelection() {
        return trainerSelection;
    }

    public void setTrainerSelection(String trainerSelection) {
        this.trainerSelection = trainerSelection;
    }

    public String getDifficultySelection() {
        return difficultySelection;
    }

    public void setDifficultySelection(String difficultySelection) {
        this.difficultySelection = difficultySelection;
    }

    public String getDatabaseIp() {
        return databaseIp;
    }

    public void setDatabaseIp(String databaseURL) {
        this.databaseIp = databaseURL;
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

    public List<Integer> getTrainerPokemon() {
        return trainerPokemon;
    }

    public void setTrainerPokemon(List<Integer> trainerPokemon) {
        this.trainerPokemon = trainerPokemon;
    }
}
