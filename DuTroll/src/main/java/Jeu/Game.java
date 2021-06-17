package Jeu;

import java.util.ArrayList;

import static Strat.HumanStrat.*;
import static Strat.RandomStrat.randomStrat;

public class Game {
    private final int boardSize;
    private int[] board;
    private ArrayList<Castle> castles;
    private int tour;
    private int trollPos;
    int s1, s2;

    public Game(int s1, int s2, int boardSize, int stock, int postrollInit) {
        assert (boardSize % 2 == 1);
        tour = 0;
        this.s1 = s1;
        this.s2 = s2;
        this.boardSize = boardSize;
        board = new int[boardSize];
        castles = new ArrayList<Castle>();
        for (int i = 1; i < boardSize - 1; i++) {
            board[i] = 0;
        }
        board[0] = 1;
        board[boardSize - 1] = 2;
        trollPos = postrollInit;
        board[trollPos] = 3;
        Castle c1 = new Castle(stock,1);
        Castle c2 = new Castle(stock,2);
        castles.add(c1);
        castles.add(c2);
    }
    public Game(int s1, int s2, int boardSize, int stock) {
        this(s1, s2, boardSize, stock, (boardSize - 1) / 2);
    }

    /**
     * @return -1 si le joueur de gauche gagne la partie, 0 si nul, et 1 le joueur de droite gagne la partie.
     */
    public int play() {
        boolean finish = false;
        while (!finish) {
            int resTour = tour();
            board[trollPos] = 0;
            trollPos += resTour;
            board[trollPos] = 3;
            finish = gameFinish();
        }
        endGame();
        return gagnantGame();
    }
    private boolean gameFinish() {
        if (trollPos == 0 || trollPos == boardSize - 1)
            return true;
        if (castles.get(0).getStock() == 0 || castles.get(1).getStock() == 0)
           return true;
        return false;
    }
    private int gagnantGame() {
        int mid = (boardSize - 1) / 2;
        if (trollPos == mid)
            return 0;
        if(trollPos < mid)
            return -1;
        return 1;
    }
    private void endGame() {
        if (trollPos < 0 && trollPos < boardSize - 1) {
            while (castles.get(0).getStock() != 0) {
                trollPos++;
                castles.get(0).setStock(castles.get(0).getStock() - 1);
            }
            while (castles.get(1).getStock() != 0) {
                trollPos++;
                castles.get(1).setStock(castles.get(1).getStock() - 1);
            }
        }
    }
    /**
     * @return 1 si le troll dois avancer vers la droite (joueur2) -1 si il dois allez vers la gauche et 0 si il reste sur place.
     */
    public int tour() {
        int tiragej1, tiragej2;
        if(s1 == 2 || s2 == 2)
            affichageJoueur(castles.get(0).getStock(), castles.get(1).getStock(),trollPos, boardSize);
        tiragej1 = strat(s1, castles.get(0).getStock());
        tiragej2 = strat(s2, castles.get(1).getStock());
        updatestock(tiragej1, tiragej2);
        tour++;
        return gagnantTour(tiragej1, tiragej2);
    }
    public int strat(int strategie, int stock) {
        switch (strategie) {
            case 1:
                return randomStrat(stock);
            case 2:
                return cin();
        }
        return -1;
    }
    public int gagnantTour(int tirageJ1, int tiragej2) {
        if (tirageJ1 < tiragej2)
            return -1;
        if (tirageJ1 > tiragej2)
            return 1;
        return 0;
    }
    public void updatestock(int j1, int j2) {
        castles.get(0).setStock(castles.get(0).getStock() - j1);
        castles.get(1).setStock(castles.get(1).getStock() - j2);
    }

    public void displayTour(int tiragej1, int tiragej2) {
        System.out.println("joueur 1 utilise : " + tiragej1 + " pierre");
        System.out.println("joueur 2 utilise : " + tiragej2 + " pierre");
        System.out.println("stock du joueur 1 :" + castles.get(0).getStock());
        System.out.println("stock du joueur 2 :" + castles.get(1).getStock());
        if(tiragej1 == tiragej2)
            System.out.println("tour Null");
        if(tiragej1 > tiragej2)
            System.out.println("joueur 1 remporte ce tour");
        if(tiragej2 > tiragej1)
            System.out.println("joueur 2 remporte ce tour");
        displayBoard();
    }
    public void displayBoard() {
        for(int i = 0; i < boardSize; i++) {
            System.out.print(board[i]);
        }
        System.out.println("");
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int[] getBoard() {
        return board;
    }

    public int getTrollPos() {
        return trollPos;
    }
}
