public class Joueur {
    private int positionSurLePlateau = 0;
    private String nom;
    private Plateau plateau;

    public Joueur(String nom, Plateau plateau){
        this.nom = nom;
        this.plateau = plateau;

    }

    public String getNom(){return nom;}
    public int getPositionSurLePlateau(){return positionSurLePlateau;}

    public Case avancer(int nbDeCases){
        positionSurLePlateau = (positionSurLePlateau+nbDeCases)%plateau.getNbCases();
        return plateau.getCaseAt(positionSurLePlateau);
    }

    @Override
    public String toString() {
        return nom;
    }
}
