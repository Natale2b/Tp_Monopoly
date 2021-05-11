import java.util.ArrayList;
import java.util.TreeMap;

public class Player {
    /**
     * Position du joueur sur le plateau.
     */
    private int positionOnBoard = 0;

    /**
     * Le nom du joueur.
     */
    private String name;

    /**
     * Le plateau sur lequel se trouve le joueur.
     */
    private Board board;

    /**
     * La somme possedee par le joueur.
     */
    private int money = 0;

    //private ArrayList<CellProperty> properties;

    /**
     * Constructeur Player.
     *
     * @param name
     *          Le nom du joueur
     * @param board
     *          Le plateau sur lequel se trouve le joueur
     */
    public Player(String name, Board board) {
        this.name = name;
        this.board = board;

    }

  //  public String getname(){return name;}

    /**
     * Retourne la position du joeur sur le plateau.
     *
     * @return la position du joeur sur le plateau
     */
    public int getPositionOnBoard() { return positionOnBoard; }

    /*
    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void substractMoney(int money) {
        this.money -= money;
    }
    */

    /**
     * Fait avancer le joueur sur le plateau.
     *
     * @param nbDeCases
     *          Le nombre de cases a parcourir
     */
    public void move(int nbDeCases) {
        positionOnBoard = (positionOnBoard + nbDeCases) % board.getNbCases();
    }

    /*
    /**
     * Permet d'acheter une propriete
     *
     /
    public Boolean buy(CellProperty cell){
        int price = cell.getPrice();

        if (price <= money){
            money -= price;
            return true;
        }
        else {
            System.out.println("Vous n'avez pas assez d'argent !");
            return false;
        }
    }
    */

    @Override
    public String toString() {
        return name;
    }
}
