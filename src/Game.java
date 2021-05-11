import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Random;

public class Game {
    /**
     * Le plateau sur lequel on va jouer.
     */
    private Board board;

    /**
     * La liste des cartes.
     */
    private ArrayList<Card> cards;



    /*Default settings*/

    /*
    private ArrayList<Cell> cells = new ArrayList<>(Arrays.asList(new CellProperty("propriete1",10),new CellProperty("propriete2",20),
            new CellProperty("propriete3",30),new CellProperty("propriete4",50),
            new CellProperty("propriete5",100),new CellProperty("propriete6",150),
            new CellProperty("propriete7",200),new CellProperty("propriete8",300)));
    */

    /**
     * Constructeur Game.
     *
     * @param numberOfCells
     *          Le nombre de cases du plateau
     * @param numberOfPlayers
     *          Le nombre de joueurs dans la partie
     * @param numberOfRounds
     *          Le nombre de tours avant la fin de la partie
     */
    public Game(int numberOfCells, int numberOfPlayers, int numberOfRounds) {
        board = new Board(numberOfCells, numberOfPlayers);
        start(numberOfRounds);

    }

    /**
     * Lance la partie et effectue un certain nombre de tours.
     *
     * @param numberOfRounds
     *          Le nombre de tours avant la fin de la partie
     */
    public void start(int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            for (Player player : board.getPlayers()) {
                launch(player);
            }
        }
        end();
    }

    /**
     * Lance les des et fait avancer le joueur.
     *
     * @param player
     *          Le joueur dont c'est le tour
     */
    public void launch(Player player) {
        System.out.println("Tour de : " + player);
        Random rand = new Random(); //instance de random class
        final int  max = 6;
        int de1 = rand.nextInt(max) + 1;
        int de2 = rand.nextInt(max) + 1;
        int result = de1 + de2;
        System.out.println("Un " + de1 + " ! et un " + de2 + " ! " + player + " avance de " + result + " cases.");
        player.move(result);
        System.out.println(board.getCaseAt(player.getPositionOnBoard()));
        System.out.println();
    }


    /**
     * Affiche les resultats de fin de partie pour chacun des joueurs.
     */
    public void end() {
        System.out.println("Partie terminée, voici la position des joueurs :");
        for (Player player : board.getPlayers()) {
            System.out.println(player + " " + board.getCaseAt(player.getPositionOnBoard()));
        }
    }
}
