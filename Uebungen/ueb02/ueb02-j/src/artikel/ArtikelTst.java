package src.artikel;


/**
 * Sehr rudimentäres "Testprogramm"
 *
 * @author Guidoux Alexandre && Chopin Johann
 * @version 1.0
 */
public class ArtikelTst {   
    public static void main(String [] args) {
        Artikel artikel1 = new Artikel(4949, "Little Unicorn");
        System.out.println("Artikel: " + artikel1);
        artikel1.setBestand(49);
        System.out.println("Artikel: " + artikel1);
        artikel1.zugang(2000);
        System.out.println("Artikel: " + artikel1);
        artikel1.abgang(2000);
        System.out.println("Artikel: " + artikel1);
    }
}
