package MonopolyClasses;

import java.util.ArrayList;

public class GroupProperties {
    ArrayList<CellProperty> group;
    String name;

    /**
     * Constructeur GroupProperties.
     *
     * @param name
     *          le nom du groupe
     */
    public GroupProperties(String name) {
        this.name = name;
        this.group = new ArrayList<>();
    }

    /**
     * Ajoute une carte dans le groupe.
     *
     * @param cardProp
     *          carte a ajouter dans le groupe
     */
    public void addProperty(CellProperty cardProp) {
        group.add(cardProp);
    }

    /**
     * Retourne le nombre de cartes dans le groupe.
     *
     * @return le nombre de cartes dans le groupe
     */
    public int getNumberOfCards() {
        return group.size();
    }

}
