package MonopolyClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Board {


    /**
     * La liste des cases du plateau de jeu.
     */
    private ArrayList<Cell> cells;


    /**
     * Le nombre de cases
     */
    private int nbCells;
/*
    /**
     * Constructeur Board.
     *
     * @param numberOfCells
     *          Le nombre de cases du plateau
     * @param  numberOfPlayers
     *          Le nombre de joueurs
     *
     * @deprecated depuis iteration 2
     * @see Board(Cell[],int)
     /
    public Board(int numberOfCells, int numberOfPlayers) {
        cells = new ArrayList<>();
        GroupProperties group1 = new GroupProperties("groupe1");
        for (int i = 0; i < numberOfCells; i++) {
            cells.add(new CellProperty(new PropertyDeed("name",100,100,20,group1)));
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Entrez le nom du joueur");
            players.add(new Player(input.next(), this));
        }

        nbCells = cells.size();
    }


    /**
     * Constructeur Board.
     *
     * @param cells
     *          a list of cells
     * @param  numberOfPlayers
     *          Le nombre de joueurs
     /
    public Board(Cell[] cells,int numberOfPlayers) {
        this.cells = new ArrayList<Cell>(Arrays.asList(cells));

        for (int i = 0; i < numberOfPlayers; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Entrez le nom du joueur");
            players.add(new Player(input.next(), this));
        }

        nbCells = this.cells.size();
    }

    public Board(Cell[] cells,Player[] players) {
        this.cells = new ArrayList<Cell>(Arrays.asList(cells));

        this.players = new ArrayList<>(Arrays.asList(players));

        nbCells = this.cells.size();
    }
    */

    /**
     * Constructeur Board.
     *
     * @param cells
     *          Liste de cases
     *
    */
    public Board(Cell[] cells) {
        this.cells = new ArrayList<>(Arrays.asList(cells));
        nbCells = this.cells.size();
        for (Cell cell : cells) {
            cell.setBoard(this);
        }
    }

    /**
     * Retourne le nombre de cases de ce plateau.
     *
     * @return Le nombre de cases
     */
    public int getNbCells() {
        return nbCells;
    }

    /**
     * Retourne le nombre de cases de ce plateau.
     *
     * @param i index de la case recherchee
     *
     * @return La case à l'index i
     */
    public Cell getCellAt(int i) {
        return cells.get(i);
    }

    /**
     * Retourne une string decrivant l'objet.
     *
     * @return La phrase a afficher lorsque l'on tombe sur cette case
     */

    public Cell getCell(String name) {
        for (Cell cell : cells) {
            if (cell.getName().compareTo(name) == 0) {
                return cell;
            }
        }
        throw new NoSuchElementException("Cette case : " + name + "n'existe pas");
    }

    public int getCellPosition(String name) {
        for (Cell cell : cells) {
            if (cell.getName().compareTo(name) == 0){
                return cells.indexOf(cell);
            }
        }
        throw new NoSuchElementException("La case " + name + " n'existe pas");
    }

    /**
     * Retourne une string decrivant l'objet.
     *
     * @return La phrase a afficher lorsque l'on tombe sur cette case
     */
    public ArrayList<Cell> getCells() {
        return cells;
    }

}
