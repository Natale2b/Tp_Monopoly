import java.util.ArrayList;

public class GroupProperties {
    ArrayList<CellProperty> group = new ArrayList<>();
    String name;
    int numberOfCards = 0;

    /**
     * Constructeur GroupProperties.
     *
     * @param name
     *          le nom du groupe
     */
    public GroupProperties(String name) {
        this.name = name;
    }

    /**
     * Ajoute une carte dans le groupe.
     *
     * @param cardProp
     *          carte a ajouter dans le groupe
     */
    public void addProperty(CellProperty cardProp) {
        group.add(cardProp);
        numberOfCards++;
    }

    /**
     * Retourne le nombre de cartes dans le groupe.
     *
     * @return le nombre de cartes dans le groupe
     */
    public int getNumberOfCards() {
        return numberOfCards;
    }
}
