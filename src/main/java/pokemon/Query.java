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
//                while(pokemonName.next()) {
                    pokemonName.next();
                    pokemon.add(pokemonName.getString(1));
//                }

                num++;
            }
            System.out.println(pokemon);
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return pokemon;
    }

    public static int pokemonId(String pokemonName){
        Singleton s = Singleton.getInstance();
        int pokemonId;

        try {
            String databaseUrl = s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            String query = "SELECT ID_Pokemon FROM Pokemon WHERE Pokemon = '" + pokemonName +"'";
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

    public static List<String> pokemonAtributes(int pokemonId){
        Singleton s = Singleton.getInstance();
        List<String> atributes = new ArrayList<>();

        try {
            String databaseUrl =s.getDatabaseUrl();
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

            connection.close();
            return atributes;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static String pokemonType(int pokemonId){
        Singleton s = Singleton.getInstance();
        String pokemonType;
        try {
            String databaseUrl =s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            String query = "SELECT p.Pokemon, t.Type\n" +
                    "FROM Pokemon p\n" +
                    "         JOIN Rel_Pokemon_Type rpt ON p.ID_Pokemon = rpt.ID_Pokemon\n" +
                    "         JOIN Types t ON rpt.ID_Type = t.ID_Type\n" +
                    "WHERE p.ID_Pokemon = "+ pokemonId +
                    " LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet pokemon = statement.executeQuery();
            pokemon.next();
            pokemonType = pokemon.getString("Type");

            connection.close();
            return pokemonType;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public static String tuxType(){
        Singleton s = Singleton.getInstance();
        String tuxType;
        try {
            String databaseUrl =s.getDatabaseUrl();
            Connection connection = DriverManager.getConnection(databaseUrl, s.getDatabaseUser(), s.getDatabasePassword());

            //Genera un numero aleotorio el cual corresponde a un tipo de pokemon
            int num = (int) (Math.random()*17+1);

            String query = "SELECT Type from Types WHERE ID_Type =" + num;
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet pokemon = statement.executeQuery();
            pokemon.next();
            tuxType = pokemon.getString("Type");

            connection.close();
            return tuxType;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
}
