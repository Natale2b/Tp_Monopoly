import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Plateau plateau;
    private ArrayList<Carte> cartes;
    private int nombreDeTours;
    /*Default settings*/


    public Game(int nombreDeCase, int nombreDeJoueurs, int nombreDeTours){
        plateau = new Plateau(nombreDeCase, nombreDeJoueurs);
    }

    public void partie(int nbTours){
        for (int i = 0; i < nbTours; i++) {
            for (Joueur joueur:plateau.joueurs) {
                lancer(joueur);
            }
        }
        finDePartie();
    }

    public void lancer(Joueur joueur){
        System.out.println("Tour de : "+joueur);
        Random rand = new Random(); //instance of random class
        int max = 6;
        int de1 = rand.nextInt(max)+1;
        int de2 = rand.nextInt(max)+1;
        int resultat = de1 + de2;
        System.out.println("Un "+de1+" ! et un "+de2+" ! "+joueur.getNom()+" avance de "+resultat+" cases.");
        joueur.avancer(resultat);
        System.out.println(plateau.getCaseAt(joueur.getPositionSurLePlateau()));
        System.out.println();
    }

    public void finDePartie(){
        System.out.println("Partie terminée, voici la position des joueurs :");
        for (Joueur joueur:plateau.joueurs) {
            System.out.println(joueur + " " + plateau.getCaseAt(joueur.getPositionSurLePlateau()));
        }
    }
}
