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

            String databaseUrl = "jdbc:mysql://" + s.getDatabaseIp() + ":" + s.getDatabasePort()+ "/" + s.getDatabaseName();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());
            for(int i =0; i<12; i++) {

                String query = "SELECT Trainer FROM Trainers WHERE ID_Trainer = " + num;
                PreparedStatement statement = connection.prepareStatement(query);

                ResultSet name = statement.executeQuery();
                name.next();
                names.add(name.getString("Trainer"));
                num++;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        return names;
    }

    public static int trainerId(String trainerName){
        Singleton s = Singleton.getInstance();
        int trainerId;

        try {
            String databaseUrl = "jdbc:mysql://" + s.getDatabaseIp() + ":" + s.getDatabasePort()+ "/" + s.getDatabaseName();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            String query = "SELECT ID_Trainer FROM Trainers WHERE Trainer = '" + trainerName +"'";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet trainer = statement.executeQuery();
            trainer.next();
            trainerId = trainer.getInt("ID_Trainer");
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
            String databaseUrl = "jdbc:mysql://" + s.getDatabaseIp() + ":" + s.getDatabasePort()+ "/" + s.getDatabaseName();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

                String query = "SELECT ID_Pokemon FROM Rel_Trainer_Pokemon WHERE ID_Trainer = " + trainerId;
                PreparedStatement statement = connection.prepareStatement(query);

                ResultSet pokemonName = statement.executeQuery();
                while(pokemonName.next()) {
                    pokemon.add(pokemonName.getInt("ID_Pokemon"));
                }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return pokemon;
    }

    public static List<String> allPokemonName(){
        Singleton s = Singleton.getInstance();
        List<String> pokemon = new ArrayList<>();

        try {
            String databaseUrl = "jdbc:mysql://" + s.getDatabaseIp() + ":" + s.getDatabasePort()+ "/" + s.getDatabaseName();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            int num=1;

            for(int i =0; i<151;i++) {
                String query = "SELECT Pokemon FROM Pokemon " + "WHERE ID_Pokemon =" + num;
                PreparedStatement statement = connection.prepareStatement(query);

                ResultSet pokemonName = statement.executeQuery();
//                while(pokemonName.next()) {
                    pokemonName.next();
                    pokemon.add(pokemonName.getString(1));
//                }

                num++;
            }
            System.out.println(pokemon);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return pokemon;
    }

    public static int pokemonId(String pokemonName){
        Singleton s = Singleton.getInstance();
        int pokemonId;

        try {
            String databaseUrl = "jdbc:mysql://" + s.getDatabaseIp() + ":" + s.getDatabasePort()+ "/" + s.getDatabaseName();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            String query = "SELECT ID_Pokemon FROM Pokemon WHERE Pokemon = '" + pokemonName +"'";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet pokemon = statement.executeQuery();
            pokemon.next();
            pokemonId = pokemon.getInt("ID_Pokemon");
            return pokemonId;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;//Devuelve -1 si hay un error
        }


    }

    public static List<String> pokemonAtributes(int pokemonId){
        Singleton s = Singleton.getInstance();
        List<String> atributes = new ArrayList<>();

        try {
            String databaseUrl = "jdbc:mysql://" + s.getDatabaseIp() + ":" + s.getDatabasePort()+ "/" + s.getDatabaseName();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            String query = "SELECT HP, Attack, Special_Attack, Speed, Defense FROM Pokemon WHERE ID_Pokemon =" + pokemonId;
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet pokemon = statement.executeQuery();
            pokemon.next();
            atributes.add(pokemon.getString("HP"));
            atributes.add(pokemon.getString("Attack"));
            atributes.add(pokemon.getString("Special_Attack"));
            atributes.add(pokemon.getString("Speed"));
            atributes.add(pokemon.getString("Defense"));

            return atributes;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
