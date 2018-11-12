package src.artikel;


/**
 * Décrivez votre classe ArtikelTst ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ArtikelTst
{   
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
