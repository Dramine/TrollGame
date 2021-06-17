package Strat;

import java.util.Scanner;
public class HumanStrat {
    static public void affichageJoueur(int stockj1, int stockj2, int posTroll, int boardSize) {
        System.out.println("Stock joueur 1 :" + stockj1);
        System.out.println("Stock joueur 2 :" + stockj2);
        System.out.print(1);
        for(int i = 1; i < boardSize - 1; i++) {
            if(i != posTroll)
            System.out.print(0);
            else
                System.out.print("T");
        }
        System.out.print(2);
    }
    static public int cin() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        return n;
    }

}
