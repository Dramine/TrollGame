import Jeu.Game;
import Strat.OptStrat;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        OptStrat optStrat;
        int boardSize = 7;
        int stock = 15;
        Game game = new Game(2, 1, boardSize, stock);
        optStrat = new OptStrat(boardSize, 15, 15);
        optStrat.gain(0, 0, 0);
        /*System.out.println( "Hello World!" );
        int boardSize = 7;
        int stock = 15;
        Game game = new Game(2, 1, boardSize, stock);
        int gagnant = game.play();
        if(gagnant == - 1) {
            System.out.println("le joueur de gauche l'emporte");
        }
        if(gagnant == 0) {
            System.out.println("Match nul");
        }
        if(gagnant == 1) {
            Sys*/
    }

    //OptStrat strat = new OptStrat(game);
    //strat.displayGopt();


}

