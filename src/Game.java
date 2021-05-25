import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    /**
     * Le plateau sur lequel on va jouer.
     */
    private Board board;

    /**
     * La liste des cartes.
     */
    private ArrayList<Card> cards;

    private ArrayList<Player> players = new ArrayList<>();


    /*Default settings*/

    /*
    private ArrayList<Cell> cells = new ArrayList<>(Arrays.asList(new CellProperty("propriete1",10),new CellProperty("propriete2",20),
            new CellProperty("propriete3",30),new CellProperty("propriete4",50),
            new CellProperty("propriete5",100),new CellProperty("propriete6",150),
            new CellProperty("propriete7",200),new CellProperty("propriete8",300)));
    */

    /*
     * Constructeur Game.
     *
     * @param numberOfCells
     *          Le nombre de cases du plateau
     * @param numberOfPlayers
     *          Le nombre de joueurs dans la partie
     * @param numberOfRounds
     *          Le nombre de tours avant la fin de la partie
     *
     * @deprecated depuis Iteration 2
     * @see Game(Cell[], int, int)
     */
    /*
    public Game(int numberOfCells, int numberOfPlayers, int numberOfRounds) {
        board = new Board(numberOfCells);
        start(numberOfRounds);

    }*/

    public Game(Board board, Player[] players, int numberOfRounds) {
        this.board = board;
        this.players = new ArrayList<>(Arrays.asList(players));
        start(numberOfRounds);

    }

    /**
     * Constructeur Game.
     *
     * @param board
     *          Le plateau
     * @param numberOfPlayers
     *          Le nombre de joueurs dans la partie
     * @param numberOfRounds
     *          Le nombre de tours avant la fin de la partie
     *
     */
    public Game(Board board, int numberOfPlayers, int numberOfRounds) {
        this.board = board;

        for (int i = 0; i < numberOfPlayers; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Entrez le nom du joueur");
            players.add(new Player(input.next(), board));
        }

        start(numberOfRounds);

    }

    /**
     * Constructeur Game.
     *
     * @param cells
     *          Liste predefinie de cases d'un plateau
     * @param numberOfPlayers
     *          Le nombre de joueurs dans la partie
     * @param numberOfRounds
     *          Le nombre de tours avant la fin de la partie
     */
    /*
    public Game(Cell[] cells, int numberOfPlayers, int numberOfRounds) {
        board = new Board(cells, numberOfPlayers);
        start(numberOfRounds);

    }*/

    /**
     * Lance la partie et effectue un certain nombre de tours.
     *
     * @param numberOfRounds
     *          Le nombre de tours avant la fin de la partie
     */
    public void start(int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            for (Player player : players) {
                launch(player);
                prettyTest();
                System.out.println("FIN DU TOUR");
                System.out.println();
                Scanner input = new Scanner(System.in);
                System.out.println("Continuer ?(y/n)");
                String temp = input.next();
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
        System.out.println();
    }


    /**
     * Affiche les resultats de fin de partie pour chacun des joueurs.
     */
    public void end() {
        System.out.println("Partie terminée, voici la position des joueurs :");
        for (Player player : players) {
            System.out.println(player + " " + board.getCellAt(player.getPositionOnBoard()));
        }
    }

    public void prettyTest(){
        for (Player player:players) {
            System.out.println(player +" / " + player.getMoney() + "// possede : ");
            for (CellProperty deed:player.getProperties()) {
                System.out.println(deed.getName());
            }
        }
    }
}
