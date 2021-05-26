package MonopolyClasses;

import java.util.Scanner;

public class CellProperty extends Cell{

    /**
     * Le prix de la propriete.
     */
    private int price;

    /**
     * Le prix d'une maison.
     */
    private int housePrice;

    /**
     * Le nieau de construction du terrain.
     */
    private int housing = 0;

    /**
     * Les differents loyers possibles de la propriete.
     */
    private int[] rents = {0,0,0,0,0,0};

    /**
     * Le groupe auquel appartient la propriete.
     */
    private GroupProperties group;

    /**
     * Le loyer de la propriete.
     */
    private int rent;

    /**
     * Le proprietaire (s'il y en a un).
     */
    private Player owner = null;

    /**
     * Indique si on peut construire sur la propriete
     * (si on possede toutes les propriete du meme groupe).
     */
    private boolean buildable = false;

    /**
     * Constructeur PropertyDeed.
     *
     * Constructeur le plus simple calcule les differents
     * loyers avec celui du terrain nu
     *
     * @param name
     *          le nom de la propriete
     * @param price
     *          le prix de la propriete
     * @param housePrice
     *          le prix de la construction d'une maison sur la propriete
     * @param rent
     *          le loyer de la propriete
     * @param group
     *          le groupe auquel appartient la propriete
     *
     */
    public CellProperty(String name, int price, int housePrice, int rent, GroupProperties group){
        super(name);
        this.price = price;
        this.housePrice = housePrice;
        this.group = group;
        this.rent = rent;
        rents[0] = rent;
        rents[1] = rent * 3;
        rents[2] = rent * 4;
        rents[3] = rent * 5;
        rents[4] = rent * 6;
        rents[5] = rent * 7;
        group.addProperty(this);
    }

    /**
     * Constructeur PropertyDeed.
     *
     * Constructeur avec precision cas par cas des differents loyers
     * utilise le premier constructeur
     *
     * @see CellProperty (java.lang.String, int, int, int, GroupProperties)
     */
    public CellProperty(String name, int price, int housePrice,
                        int rent, int house1, int house2, int house3, int house4, int hotel, GroupProperties group){
        super(name);
        new CellProperty(name,price,housePrice,rent,group);
        rents[1] = house1;
        rents[2] = house2;
        rents[3] = house3;
        rents[4] = house4;
        rents[5] = hotel;
    }

    /**
     * Constructeur PropertyDeed.
     *
     * Constructeur avec precision cas par cas des differents loyers regroupés dans une liste
     * utilise le premier constructeur
     *
     * @see CellProperty (java.lang.String, int, int, int, GroupProperties)
     */
    public CellProperty(String name, int price, int housePrice, int[] rents, GroupProperties group){
        super(name);
        new CellProperty(name,price,housePrice,rents[0],group);
        this.rents[1] = rents[1];
        this.rents[2] = rents[2];
        this.rents[3] = rents[3];
        this.rents[4] = rents[4];
        this.rents[5] = rents[5];
    }

    /**
     * Permet d'effectuer les actions attendues lorsque le joueur tombe sur la case.
     *
     * Propose l'achat si la propriete est libre,
     * sinon fait payer le joueur ce qu'il doit au proprietaire
     *
     * @param player
     *          Le joueur qui tombe sur la case
     */
    @Override
    public void apply(Player player) {
        System.out.println(this.toString());
        if (owner == null) {
            ask(player);
        }
        else {
            player.pay(this);
        }

    }

    /**
     * Permet de gerer l'achat potentiel d'une propriete
     *
     * @param player
     *          Le joueur pouvant acheter
     */
    public void ask(Player player) {
        Scanner input = new Scanner(System.in);
        boolean asking = true;
        while (asking) {
            System.out.println("Voulez vous acheter ? (y/n)");
            String temp = input.next();
            if(temp.equals("y")) {
                if(player.buy(this)) {
                    owner = player;
                }
                asking = false;
            }
            else if(temp.equals("n")) {
                asking = false;
            }
            else {
                System.out.println("Reponse incorrecte le format attendu est : 'y' ou 'n'");
            }
        }
    }

    /**
     * Retourne le proprietaire de la propriete.
     *
     * @return le proprietaire de la propriete
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Retourne le prix de la propriete.
     *
     * @return le prix de la propriete
     */
    public int getPrice() {
        return price;
    }

    /**
     * Retourne le loyer de la propriete en prenant en compte les maisons.
     *
     * @param i
     *          le nombre de maisons (5 = un hotel)
     *
     * @return le loyer de la propriete en fonction du nombre de maisons
     */
    public int getRentAt(int i) {
        return rents[i];
    }

    /**
     * Retourne le loyer de la propriete.
     *
     * @return le loyer de la propriete
     */
    public int getRent() {
        return rent;
    }

    /**
     * Retourne le groupe de la propriete.
     *
     * @return le groupe de la propriete
     */
    public GroupProperties getGroup() {
        return group;
    }

    /**
     * Permet de definir si le terrain est constructible ou non
     *
     * @param buildable
     *          un booleen (true -> constructible)
     */
    public void setBuildable(boolean buildable) {
        this.buildable = buildable;
    }

    /**
     * Permet de definir le loyer
     *
     * @param rent
     *          le nouveau loyer
     */
    public void setRent(int rent) {
        this.rent = rent;
    }

    public void reset(){
        buildable = false;
        rent = rents[0];
        housing = 0;
        owner = null;
    }

    public void build(){
        if(buildable && owner.getMoney() >= housePrice && housing <= rents.length){
            owner.subtractMoney(housePrice);
            housing++;
            actualize();
        }
    }

    private void actualize(){
        this.rent = rents[housing];
    }
}
