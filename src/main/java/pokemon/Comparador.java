package pokemon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparador implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Object p1 = o1;
        List<Integer> vidaP1 = new ArrayList<>();
        vidaP1 = Query.pokemonAtributes(Query.pokemonId(p1.toString()));
        Object p2 = o2;
        List<Integer> vidaP2 = new ArrayList<>();
        vidaP2 = Query.pokemonAtributes(Query.pokemonId(p2.toString()));

        if (vidaP1.get(0) > vidaP2.get(0)){
            return 1;
        } else if (vidaP1.get(0) < vidaP2.get(0)){
            return -1;
        }else {
            return 0;
        }
    }
}
