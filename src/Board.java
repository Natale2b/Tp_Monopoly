import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    /**
     * La liste des cases du plateau de jeu.
     */
    private ArrayList<Cell> cells = new ArrayList<>();

    /**
     * La liste des joeurs.
     */
    private ArrayList<Player> players = new ArrayList<>();

    /**
     * Constructeur Board.
     *
     * @param numberOfCellss
     *          Le nombre de cases du plateau
     * @param  numberOfPlayers
     *          Le nombre de joueurs
     */
    public Board(int numberOfCellss, int numberOfPlayers) {
        for (int i = 0; i < numberOfCellss; i++) {
            cells.add(new CellProperty("Place St Nicolas", 100));
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Entrez le nom du joueur");
            players.add(new Player(input.next(), this));
        }
    }

    /**
     * Retourne le nombre de cases de ce plateau.
     *
     * @return Le nombre de cases
     */
    public int getNbCases() {
        return cells.size();
    }

    /**
     * Retourne le nombre de cases de ce plateau.
     *
     * @param i index de la case recherchee
     *
     * @return La case à l'index i
     */
    public Cell getCaseAt(int i) {
        return cells.get(i);
    }

    /**
     * Retourne une string decrivant l'objet.
     *
     * @return La phrase a afficher lorsque l'on tombe sur cette case
     */
    public ArrayList<Cell> getCells() {
        return cells;
    }

    /**
     * Retourne la liste des joueurs.
     *
     * @return les joueurs du plateau sous forme d'une arrayList
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
