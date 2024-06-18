package pokemon;

public class Tux extends Pokemon {
    public Tux(int id){
        super(id);
        changeAtributes();
        super.hp=super.atributes.get(0);
        super.maxHp = super.atributes.get(0);
        super.type=tipos[Query.tuxTypeId()-1];
        System.out.println("VIDA TUX: " + hp + "VIDA MAXIMA: " + maxHp);
        System.out.println(this.type);
    }

    /*
       Orden Atributos
        HP
        Attack
        Special Attack
        Speed
        Defense
   */
    private void changeAtributes() {
        //        Edita los atributos de tux según la dificultad seleccionada
        Singleton s = Singleton.getInstance();
        switch(s.getDifficultySelection()){
            case "Marine":
                super.level=50;
                super.atributes.set(0, 227);
                super.atributes.set(1, 189);
                super.atributes.set(2, 189);
                super.atributes.set(3, 189);
                super.atributes.set(4, 189);
                break;

            case "Veterano":
                super.level=75;
                super.atributes.set(0, 350);
                super.atributes.set(1, 220);
                super.atributes.set(2, 220);
                super.atributes.set(3, 220);
                super.atributes.set(4, 220);
                break;

            case "Pesadilla":
                super.level=100;
                super.atributes.set(0, 444);
                super.atributes.set(1, 372);
                super.atributes.set(2, 372);
                super.atributes.set(3, 372);
                super.atributes.set(4, 372);
                break;

            default:
                super.level=25;
                super.atributes.set(0, 180);
                super.atributes.set(1, 112);
                super.atributes.set(2, 112);
                super.atributes.set(3, 112);
                super.atributes.set(4, 112);
        }

    }
}
