package MonopolyClasses;

import java.util.ArrayList;

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
     * La partie dans lequelle se trouve le joueur.
     */
    private Game game;

    /**
     * La somme possedee par le joueur.
     */
    private int money = 1500;

    /**
     * Les proprietes du joueur.
     */
    private ArrayList<CellProperty> properties = new ArrayList<>();

    /**
     * Les cartes du joueur.
     */
    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * Indique si le joueur est coincé sur une case (prison par exemple).
     */
    private int stuck = 0;

    /**
     * Constructeur Player.
     *
     * @param name
     *          Le nom du joueur
     * @param game
     *          Le jeu dans lequel se trouve le joueur
     */
    public Player(String name, Game game) {
        this.name = name;
        this.game = game;

    }
    public Player(String name) {
        this.name = name;

    }


  //  public String getname(){return name;}

    /**
     * Retourne la position du joueur sur le plateau.
     *
     * @return la position du joueur sur le plateau
     */
    public int getPositionOnBoard() { return positionOnBoard; }

    public ArrayList<CellProperty> getProperties() {
        return properties;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void subtractMoney(int money) {
        this.money -= money;
    }

    public void setPositionOnBoard(int positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    public void setStuck(int stuck) {
        this.stuck = stuck;
    }

    /**
     * Fait avancer le joueur sur le plateau.
     *
     * @param de1
     *          Le premier de
     * @param de2
     *          Le second de
     */
    public void move(int de1, int de2) {

        if (stuck == 0){
            int nbCells = game.getBoard().getNbCells();
            if (positionOnBoard + de1 + de2 > nbCells){
                this.addMoney(game.incomeRound);
            }
            positionOnBoard = (positionOnBoard + de1 + de2) % nbCells;
            game.getBoard().getCellAt(positionOnBoard).apply(this);
        }
        else {
            if (de1 == de2){
                stuck = 0;
                move(de1, de2);
            }
            else {
                stuck --;
            }
        }
    }


    /**
     * Permet d'acheter une propriete.
     *
     * @param cell
     *          la case de la propriete a acheter
     *
     * @return true si l'achat est effectue, false sinon (faute d'argent)
     */
    public Boolean buy(CellProperty cell){
        int price = cell.getPrice();


        if (price <= money){
            money -= price;
            updatePropertiesGroups(cell);
            properties.add(cell);
            return true;
        }
        else {
            System.out.println("Vous n'avez pas assez d'argent !");
            return false;
        }
    }

    /**
     * Permet de payer un loyer a un joueur.
     *
     * @param cell
     *          case sur laquelle on paye un loyer
     */
    public void pay(CellProperty cell){
        int rent = cell.getRent();

        this.subtractMoney(rent);
        cell.getOwner().addMoney(rent);
    }


    /**
     * Actualise les groupes de proprietes lorsque l'on en achete une nouvelle
     *
     * Permet de savoir si on a le monopole et donc si on peut construire
     * et si nos loyers a nus sont doubles
     *
     * @param newCard
     *          L'acte de la nouvelle propriete
     */
    private void updatePropertiesGroups(CellProperty newCard){
        int count = 0;
        GroupProperties newGroup = newCard.getGroup();
        ArrayList<CellProperty> temp = new ArrayList<>();
        for (CellProperty card : properties) {
            if (card.getGroup() == newGroup){
                count++;
                temp.add(card);
            }
        }
        if (count == newGroup.getNumberOfCards()){
            for (CellProperty cell:temp) {
                cell.setBuildable(true);
                cell.setRent(cell.getRent()*2);
            }
        }
    }

    public void lose() {
        for (CellProperty cell : properties){
            cell.reset();
        }
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    @Override
    public String toString() {
        return name;
    }


}
