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
     * Le plateau sur lequel se trouve le joueur.
     */
    private Board board;

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
    private ArrayList<Card> cards = new ArrayList<Card>();

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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<CellProperty> getProperties() {
        return properties;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void substractMoney(int money) {
        this.money -= money;
    }



    /**
     * Fait avancer le joueur sur le plateau.
     *
     * @param nbDeCases
     *          Le nombre de cases a parcourir
     */
    public void move(int nbDeCases) {

        System.out.println("Vous possedez : " + money + "€");
        int nbCells = board.getNbCells();
        if (positionOnBoard + nbDeCases > nbCells){
            this.addMoney(board.incomeRound);
        }
        positionOnBoard = (positionOnBoard + nbDeCases) % nbCells;
        board.getCellAt(positionOnBoard).apply(this);
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

        this.substractMoney(rent);
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

    public void addCard(Card card) {
        this.cards.add(card);
    }

    @Override
    public String toString() {
        return name;
    }
}
