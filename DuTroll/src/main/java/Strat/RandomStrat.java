package Strat;
import java.lang.Math;

public class RandomStrat {
    static public int randomStrat(int stock) {
        int tirage;
        if (stock > 3) {
            tirage = (int) (Math.random() * 3 + 1);
        } else {
            tirage = stock;
        }
        return tirage;
    }
}
