/**
 * Est la classe representant une case d'un plateau.
 *
 * Celle-ci est caracterisee par :
 *
 * Un nom, qui est son numero d'instance
 */

public abstract class Cell {
    /**
     * Le nom de la case.
     */
    private String name;

    /**
     * Le nombre d'instances de la classe Cell.
     */
    private static int count = 0;

    /**
     * Constructeur Cell.
     *
     * Le nom attribué à la case est pour le moment celui du nombre actuel d'instances de Cell
     */
    public Cell(String name) {
        name = name;
        count++;
    }

    /**
     * Retourne une string decrivant l'objet.
     *
     * @return La phrase a afficher lorsque l'on tombe sur cette case
     */
    @Override
    public String toString() {
        return "Vous tombez sur : " + name;
    }

    public String getName() { return  name;}
    /**
     * Methode abstraite.
     * Applique les effets/interactions d'une case
     * (a implementer plus tard)
     *
     * @param player
     *          Le joueur qui est tombe sur cette case
     */
    public abstract void apply(Player player);
}
