package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    protected int id;
    protected String name;
    protected Type type;
    protected String trainer;
    protected int level;
    protected int hp;
    protected int maxHp;
    protected static Type[]  tipos= Type.values();
    protected List<Integer> atributes = new ArrayList<>();
    /*
       Orden Atributos
      0  HP
      1  Attack
      2  Special Attack
      3  Speed
      4  Defense
   */
    public Pokemon(int id) {
       Singleton s = Singleton.getInstance();
            this.id = id;
            this.name = Query.pokemonName(id);
            this.type = tipos[Query.pokemonType(id)-1];
            System.out.println(this.type);
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

    public int getType() {

        return type.getPosition();
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    private void changeAtributes() {
        Singleton s = Singleton.getInstance();

        int improvement;
        switch(s.getDifficultySelection()){
            case "Marine":
                this.level = (int) (Math.random() * 75) + 50;
                improvement = (int) (Math.random() * 75) + 50;
                for (int i = 0; i < atributes.size(); i++) {
                    atributes.set(i, atributes.get(i) + improvement);
                }
                break;
            case "Veterano":
                this.level = (int) (Math.random() * 50) + 25;
                improvement = (int) (Math.random() * 50) + 25;
                for (int i = 0; i < atributes.size(); i++) {
                    atributes.set(i, atributes.get(i) + (improvement));
                }
                break;
            case "Pesadilla":
                this.level = (int) (Math.random() * 25) + 1;
                improvement = (int) (Math.random() * 25) + 1;
                for (int i = 0; i < atributes.size(); i++) {
                    atributes.set(i, atributes.get(i) + improvement);
                }
                break;
            default: //RECLUTA
                this.level = (int) (Math.random() * 100) + 75;
                improvement = (int) (Math.random() * 100) + 75;
                for (int i = 0; i < atributes.size(); i++) {
                    atributes.set(i, atributes.get(i) + improvement);
                }
        }
    }

    public String getPokemonAtributes(){
        int HP = atributes.get(0);
        int ATT = atributes.get(1);
        int SATT = atributes.get(2);
        int SPE = atributes.get(3);
        int DEF = atributes.get(4);

        String cadena = "Vida: " + HP + "\r\n" + "Ataques: " + ATT + "\r\n" + "Ataque Especial : " + SATT + "\r\n" + "Velocidad: " + SPE + "\r\n" + "Defensa: " + DEF + "\r\n" + "Tipo: " + type;
        return cadena;
    }
    public String setTuxStats() {
        String cadena = "Vida: " +  getAtributes().get(0) + "\r\n" + "Tipo: " + type;

        return cadena;
    }
}
