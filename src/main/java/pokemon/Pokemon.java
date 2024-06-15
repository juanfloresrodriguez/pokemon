package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    protected int id;
    protected String name;
    protected String type;
    protected String trainer;
    protected int level;
    protected int hp;
    protected int maxHp;
    protected List<Integer> atributes = new ArrayList<>();
    /*
       Orden Atributos
        HP
        Attack
        Special Attack
        Speed
        Defense
   */
    public Pokemon(int id) {
       Singleton s = Singleton.getInstance();
            this.id = id;
            this.name = Query.pokemonName(id);
            this.type = Query.pokemonType(id);
            this.trainer = s.getTrainerSelection();
            this.atributes = Query.pokemonAtributes(id);

            hp = atributes.get(0);

            changeAtributes();

    }

    Pokemon() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Integer> getAtributes() {
        return atributes;
    }

    public void setAtributes(List<Integer> atributes) {
        this.atributes = atributes;
    }

    private void changeAtributes() {
        Singleton s = Singleton.getInstance();

        int improvement;
        switch(s.getTrainerSelection()){
            case "Recluta":
                this.level = (int) (Math.random() * 100) + 75;
                improvement = (int) (Math.random() * 100) + 75;
                for (int i = 0; i < atributes.size(); i++) {
                    atributes.set(i, atributes.get(i) * improvement);
                }
                break;
            case "Marine":
                this.level = (int) (Math.random() * 75) + 50;
                improvement = (int) (Math.random() * 75) + 50;
                for (int i = 0; i < atributes.size(); i++) {
                    atributes.set(i, atributes.get(i) * improvement);
                }
                break;
            case "Veterano":
                this.level = (int) (Math.random() * 50) + 25;
                improvement = (int) (Math.random() * 50) + 50;
                for (int i = 0; i < atributes.size(); i++) {
                    atributes.set(i, atributes.get(i) * improvement);
                }
                break;
            case "Pesadilla":
                this.level = (int) (Math.random() * 25) + 1;
                improvement = (int) (Math.random() * 25) + 1;
                for (int i = 0; i < atributes.size(); i++) {
                    atributes.set(i, atributes.get(i) * improvement);
                }
                break;
        }
    }

    public String setPokemonAtributes(){
        int HP = atributes.get(0);
        int ATT = atributes.get(1);
        int SATT = atributes.get(2);
        int SPE = atributes.get(3);
        int DEF = atributes.get(4);

        String Type = Query.pokemonType(this.id);
        if(Type == null){
            Type="Typeless";
        }
        String cadena = "Vida: " + HP + "\r\n" + "Ataques: " + ATT + "\r\n" + "Ataque Especial : " + SATT + "\r\n" + "Velocidad: " + SPE + "\r\n" + "Defensa: " + DEF + "\r\n" + "Tipo: " + Type;
        return cadena;
    }
    public String setTuxStats() {
        String cadena = "Vida: " +  hp + "\r\n" + "Tipo: " + type;

        return cadena;
    }
}
