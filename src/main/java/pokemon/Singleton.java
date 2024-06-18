package pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private String databaseUrl;
    private String difficultySelection;
    private String trainerSelection;
    private Map<Integer , List<Integer>> trainerPokemon = new HashMap<>();
    private List<Integer> pokemonId = new ArrayList<>();

    public Double[][] effectivenessChart = {
            // Normal
            {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.25, 0.0, 1.0, 1.0, 1.25, 1.0},
            // Fuego
            {1.0, 1.25, 1.25, 1.75, 1.0, 1.75, 1.0, 1.0, 1.0, 1.75, 1.0, 1.0, 1.75, 1.0, 1.25, 1.0, 1.75, 1.0},
            // Agua
            {1.0, 1.75, 1.25, 1.25, 1.0, 1.75, 1.0, 1.0, 1.75, 1.0, 1.0, 1.0, 1.75, 1.0, 1.0, 1.0, 1.0, 1.0},
            // Planta
            {1.0, 1.25, 1.75, 1.25, 1.0, 1.0, 1.0, 1.25, 1.75, 1.25, 1.0, 1.25, 1.75, 1.0, 1.0, 1.0, 1.25, 1.0},
            // Eléctrico
            {1.0, 1.0, 1.75, 1.25, 1.25, 1.0, 1.0, 1.0, 0.0, 1.75, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
            // Hielo
            {1.0, 1.25, 1.25, 1.75, 1.75, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.75, 1.0, 1.75, 1.0, 1.25, 1.0},
            // Lucha
            {1.75, 1.0, 1.0, 1.0, 1.0, 1.75, 1.0, 1.25, 1.0, 1.25, 1.0, 1.0, 1.75, 1.0, 1.0, 1.0, 1.75, 1.25},
            // Veneno
            {1.0, 1.0, 1.0, 1.75, 1.0, 1.0, 1.0, 1.25, 1.25, 1.0, 1.0, 1.0, 1.0, 1.25, 1.0, 1.0, 1.0, 1.75},
            // Tierra
            {1.0, 1.75, 1.0, 1.0, 1.75, 1.0, 1.0, 1.75, 1.0, 1.0, 1.0, 1.0, 1.75, 1.0, 1.0, 1.0, 1.0, 1.0},
            // Volador
            {1.0, 1.0, 1.0, 1.75, 1.25, 1.0, 1.75, 1.0, 1.0, 1.0, 1.0, 1.75, 1.25, 1.0, 1.0, 1.0, 1.0, 1.0},
            // Psíquico
            {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.75, 1.75, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
            // Bicho
            {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.75, 1.0, 1.0, 1.0, 1.0, 1.25, 1.0, 1.0, 1.0, 1.0, 1.0},
            // Roca
            {1.0, 1.75, 1.0, 1.0, 1.0, 1.75, 1.0, 1.0, 1.25, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
            // Fantasma
            {0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.75, 1.0, 1.0, 1.0, 1.0},
            // Dragón
            {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.75, 1.0, 1.0, 0.0},
            // Siniestro
            {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.75, 1.0, 1.0, 1.75, 1.0, 1.0, 1.0, 1.25},
            // Acero
            {1.0, 1.25, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.75, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.25, 1.0},
            // Hada
            {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.75, 1.0, 1.0}
    };



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

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public Map<Integer, List<Integer>> getTrainerPokemon() {
        return trainerPokemon;
    }

    public void setTrainerPokemon(Map<Integer, List<Integer>> trainerPokemon) {
        this.trainerPokemon = trainerPokemon;
    }

    public List<Integer> getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(List<Integer> pokemonId) {
        this.pokemonId = pokemonId;
    }
//    Map<Integer, List<String>>
    public void getTrainerPokemonMap() {
        //Genera un mapa con los pokemons asociados a los entrenadores
        for(int i=0; i < pokemonId.size(); i++){
            this.trainerPokemon.put(pokemonId.get(i), Query.pokemonAtributes(pokemonId.get(i)));
        }


//        return trainerPokemon;
    }
}
