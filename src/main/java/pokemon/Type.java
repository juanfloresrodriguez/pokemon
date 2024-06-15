package pokemon;

public enum Type {
    NORMAL(1,0), FIRE(2,1), WATER(3, 2),
    GRASS(4, 3), ELECTRIC(5, 4), ICE(6, 5), FIGHTING(7,6),
    POISON(8,7), GROUND(9, 8), FLYING(10,9), PSYCHIC(11,10),
    BUG(12, 11), ROCK(13,12), GHOST(14,13), DARK(15,15),
    DRAGON(16,14), STEEL(17,16);


    private final int position;
    private final int id;

    Type(int id, int position) {
        this.id = id;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }


}
