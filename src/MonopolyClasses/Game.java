package MonopolyClasses;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    /**
     * Le nombre de tours avant la fin d'une partie.
     */
    private int numberOfRounds;
    /**
     * Le plateau sur lequel on va jouer.
     */
    private Board board;

    /**
     * Le gain à chaque tour.
     */
    public final int incomeRound = 0;

    /**
     * La liste des cartes.
     */
    private ArrayList<Card> cards;

    private ArrayList<Player> players = new ArrayList<>();

    private Player playerTurn;
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
        this.numberOfRounds = numberOfRounds;
        for (int i = 0; i < numberOfPlayers; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Entrez le nom du joueur");
            players.add(new Player(input.next(), this));

        }
        start(numberOfRounds);
    }

    /**
     * Lance la partie et effectue un certain nombre de tours.
     *
     * @param numberOfRounds
     *          Le nombre de tours avant la fin de la partie
     *
     * @deprecated since Iteration 3
     */
    public void startOld(int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            checkLose();
            for (Player player : players) {
                launch(player);
                possessionsPrint();
                System.out.println("FIN DU TOUR");
                System.out.println();
            }
            prettyPrintPosition();
        }
        end();
    }
    /**
     * Lance la partie et effectue un certain nombre de tours.
     *
     * @param numberOfRounds
     *          Le nombre de tours avant la fin de la partie
     *
     * @deprecated since Iteration 3
     */
    public void start(int numberOfRounds) {
        playerTurn = players.get(0);
        for (int i = 0; i < numberOfRounds; i++) {
            while (playerTurn != players.get(players.size()-1)){
                if (removeLoser()) {
                    if (checkLose()) {break;}
                }
                nextTurn();
            }
            removeLoser();
            if (checkLose()) {break;}
            nextTurn();
            System.out.println("Fin du tour");
            prettyPrintPosition();
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
        System.out.println("Un " + de1 + " ! et un " + de2 + " ! ");
        player.move(de1, de2);
        System.out.println();
    }



    public void nextTurn(){
        int indexOfPlayer = players.indexOf(playerTurn);
        indexOfPlayer = (indexOfPlayer + 1) % players.size();
        playerTurn = players.get(indexOfPlayer);
        launch(playerTurn);
    }

    private boolean removeLoser() {
        boolean result = false;
        ArrayList<Player> losers = new ArrayList<>();
        for (Player p : players){
            if (p.getMoney()<0){
                System.out.println( p + " est ruiné.");
                p.lose();
                losers.add(p);
            }
        }
        for (Player p : losers){
            players.remove(p);
            result = true;
        }
        return result;
    }

    private boolean checkLose() {
        return players.size() == 1;
    }

    /**
     * Affiche les resultats de fin de partie pour chacun des joueurs.
     */
    public void end() {
        System.out.println();
        System.out.println("Partie terminée, voici la position des joueurs :");
        int maxMoney = 0;
        Player winner = null;
        for (Player player : players) {
            System.out.println(player + " " + board.getCellAt(player.getPositionOnBoard()));
            if (player.getMoney()>maxMoney){
                maxMoney = player.getMoney();
                winner = player;
            }
        }
        System.out.println("Le gagnant est : " + winner);
    }

    public void possessionsPrint(){
        for (Player player:players) {
            System.out.println(player +" / " + player.getMoney() + "// possede : ");
            for (CellProperty deed:player.getProperties()) {
                System.out.println(deed.getName());
            }
        }
    }

    public void prettyPrintPosition() {
        System.out.println("Plateau");
        for (Cell cell:board.getCells()) {
            String s =  "[" + cell.getName() + "]";
            for (Player player : players) {
                if (player.getPositionOnBoard() == board.getCellPosition(cell.getName())){
                    s += " | " + player;
                }
            }
            System.out.println(s);
        }
    }

    public Board getBoard() {
        return board;
    }
}
