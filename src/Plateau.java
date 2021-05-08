import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {
    /*test*/
    public ArrayList<Case> cases = new ArrayList<>();
    public ArrayList<Joueur> joueurs = new ArrayList<>();

    public Plateau(int nombreDeCases, int nombreDeJoueurs){
        for (int i = 0; i < nombreDeCases; i++) {
            cases.add(new Case());
        }
        for (int i = 0; i < nombreDeJoueurs; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Entrez le nom du joueur");
            joueurs.add(new Joueur(input.next(),this));
        }
    }

    public int getNbCases(){return cases.size();}
    public Case getCaseAt(int i){
        return cases.get(i);
    }
}
