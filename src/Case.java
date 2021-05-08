public class Case {
    private String nom;
    private static int compte = 0;
    public Case(){
        nom = String.valueOf(compte);
        compte ++;
    }


    @Override
    public String toString() {
        return "Case : " + nom;
    }
}
