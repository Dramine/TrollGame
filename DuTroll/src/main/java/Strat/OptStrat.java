package Strat;

import utils.Opt;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class OptStrat {
    List<ArrayList<Integer>> configuration;
    List<Integer> Gopt;
    int boardSize;
    int m;
    int[][][] G;

    public OptStrat(int boardSize, int n1, int n2) {
        int m = (boardSize + 1) /2;
        configuration = new ArrayList<ArrayList<Integer>>();
        G = new int[n1][n2][m];
        //on créer la matrice de taille stockJ1 * stockJ2 et on initialise tout par des vecteur nul qui seront remplis plus tard.
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                for( int w = 0; w < m; w++) {
                 G[i][j][w] = -10;
                }
            }
        }
        System.out.println(G[3][3][3]);
    }

    public void initConfig() {

    }

    public void gain(int n1, int n2, int t) { //refaire ca
        System.out.println("gain");
        if (n1 == 0) { //cas ou J1 n'a plus de pierre on vide la reserve de J2 en deplacant le troll vers J1
            for (int i = 0; i < n2; i++) {
                t--;
            }
        }
        if (n2 == 0) { //cas ou J2 n'a plus de pierre, on vide la reserve de J1 en deplacant le troll vers J2
            for (int i = 0; i < n1; i++) {
                t++;
            }
        }
        if (n1 == n2) { //cas ou les deux joueurs ont le meme nombre de pierre
            if (t == m)
                G[n1 - 1][n2 - 1][t] = 0; //  troll au millieu
            if (t < m)
                G[n1 - 1][n2 - 1][t] = -1; // troll + proche de j1
            if (t > m)
                G[n1 - 1][n2 - 1][t] = 1; //  troll + proche de j2
        }
        if (n1 > n2) { // J1 a plus de pierre que J2
            if (t == m)
                G[n1 - 1][n2 - 1][t] = 1; // troll au millieu
            if (t < m)
                G[n1 - 1][n2 - 1][t] = 1; // troll + proche de J1
        }
        if (n1 < n2) { // J2 a plus de pierre que J1
            if (t == m)
                G[n1 - 1][n2 - 1][t] = -1; // troll au milleu
            if (t > m)
                G[n1 - 1][n2 - 1][t] = -1; // troll + proche de J2
        }
        //cas non trivial le troll n'est sur aucun des deux chateux et les joueurs n'ont pas un stock nul de pierre.
        if(n1 != 0 && n2 != 0 && t != 0 && t != boardSize) {
            int n1Prime, n2Prime;
            int tPrime = 0;
            for(int i = 0; i < n1; i++) {
                for(int j = 0; j < n2; j++) {
                    if(i == j)
                        tPrime = t;
                    if( i < j)
                        tPrime = t - 1;
                    if( i > j)
                        tPrime = t + 1;
                    n1Prime = n1 - (i + 1);
                    n2Prime = n2 - (j + 1);

                    if(G[n1Prime][n2Prime][tPrime] == -10)
                        gain(n1Prime, n2Prime, tPrime);
                }
            }
        }
    }
}
