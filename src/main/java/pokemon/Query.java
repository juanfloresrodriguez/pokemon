package pokemon;

import javafx.collections.FXCollections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query {

    public static List<String> trainersNames(){
        Singleton s = Singleton.getInstance();
        List<String> names = new ArrayList<>();
        try {
            int num=1;

            String databaseUrl = s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());
            for(int i =0; i<12; i++) {

                String query = "SELECT Trainer FROM Trainers WHERE ID_Trainer = " + num;
                PreparedStatement statement = connection.prepareStatement(query);

                ResultSet name = statement.executeQuery();
                name.next();
                names.add(name.getString("Trainer"));
                num++;
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return names;
    }

    public static int trainerId(String trainerName){
        Singleton s = Singleton.getInstance();
        int trainerId;

        try {
            String databaseUrl = s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            String query = "SELECT ID_Trainer FROM Trainers WHERE Trainer = '" + trainerName +"'";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet trainer = statement.executeQuery();
            trainer.next();
            trainerId = trainer.getInt("ID_Trainer");
            connection.close();
            return trainerId;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;//Devuelve -1 si hay un error
        }
    }

    public static List<Integer> trainerPokemon(){
        Singleton s = Singleton.getInstance();

        List<Integer> pokemon = new ArrayList<>();
        int trainerId = trainerId(s.getTrainerSelection());
        try {
            String databaseUrl = s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

                String query = "SELECT ID_Pokemon FROM Rel_Trainer_Pokemon WHERE ID_Trainer = " + trainerId;
                PreparedStatement statement = connection.prepareStatement(query);

                ResultSet pokemonName = statement.executeQuery();
                while(pokemonName.next()) {
                    pokemon.add(pokemonName.getInt("ID_Pokemon"));
                }

                s.setPokemonId(pokemon);
                connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return pokemon;
    }

    public static List<String> allPokemonName(){
        Singleton s = Singleton.getInstance();
        List<String> pokemon = new ArrayList<>();

        try {
            String databaseUrl = s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            int num=1;

            for(int i =0; i<151;i++) {
                String query = "SELECT Pokemon FROM Pokemon " + "WHERE ID_Pokemon =" + num;
                PreparedStatement statement = connection.prepareStatement(query);

                ResultSet pokemonName = statement.executeQuery();
                    pokemonName.next();
                    pokemon.add(pokemonName.getString(1));
                num++;
            }
            System.out.println(pokemon);
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return pokemon;
    }

    public static String pokemonName(int id) {
        Singleton s = Singleton.getInstance();
        String pokemonName;

        try {
            String databaseUrl = s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            String query = "SELECT Pokemon FROM Pokemon WHERE ID_Pokemon =" + id;
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet pokemon = statement.executeQuery();
            pokemon.next();
            pokemonName = pokemon.getString("Pokemon");
            connection.close();
            return pokemonName;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;//Devuelve null si hay un error
        }
    }

    public static int pokemonId(String pokemonName){
        Singleton s = Singleton.getInstance();
        int pokemonId;

        try {
            String databaseUrl = s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            String query = "SELECT ID_Pokemon FROM Pokemon WHERE Pokemon = \"" + pokemonName + "\";";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet pokemon = statement.executeQuery();
            pokemon.next();
            pokemonId = pokemon.getInt("ID_Pokemon");
            connection.close();
            return pokemonId;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;//Devuelve -1 si hay un error
        }

    }

    public static List<Integer> pokemonAtributes(int pokemonId){
        Singleton s = Singleton.getInstance();
        List<Integer> atributes = new ArrayList<>();

        try {
            String databaseUrl =s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            String query = "SELECT HP, Attack, Special_Attack, Speed, Defense FROM Pokemon WHERE ID_Pokemon =" + pokemonId;
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet pokemon = statement.executeQuery();
            pokemon.next();
            atributes.add(pokemon.getInt("HP"));
            atributes.add(pokemon.getInt("Attack"));
            atributes.add(pokemon.getInt("Special_Attack"));
            atributes.add(pokemon.getInt("Speed"));
            atributes.add(pokemon.getInt("Defense"));

            connection.close();
            System.out.println(atributes);
            return atributes;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static int pokemonType(int pokemonId){
        Singleton s = Singleton.getInstance();
        int pokemonType=0;
        try {
            String databaseUrl =s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            String query = "SELECT p.Pokemon, t.ID_Type\n" +
                    "FROM Pokemon p\n" +
                    "         JOIN Rel_Pokemon_Type rpt ON p.ID_Pokemon = rpt.ID_Pokemon\n" +
                    "         JOIN Types t ON rpt.ID_Type = t.ID_Type\n" +
                    "WHERE p.ID_Pokemon = "+ pokemonId +
                    " LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet pokemon = statement.executeQuery();
            pokemon.next();
            pokemonType = pokemon.getInt(2);

            connection.close();


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return pokemonType;
    }

    public static int tuxTypeId(){
        Singleton s = Singleton.getInstance();
        int tuxType=0;
        try {
            String databaseUrl =s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            //Genera un numero aleotorio el cual corresponde a un tipo de pokemon
            int num = (int) (Math.random()*17)+1;

            String query = "SELECT ID_Type from Types WHERE ID_Type =" + num;
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet pokemon = statement.executeQuery();
            pokemon.next();
            tuxType = pokemon.getInt("ID_Type");

            connection.close();


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return tuxType;
    }
}
