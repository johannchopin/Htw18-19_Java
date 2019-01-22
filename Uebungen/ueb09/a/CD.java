/**
 * Unterklasse CD der Klasse Artikel
 *
 * @author Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class CD extends Artikel
{
    private String interpret;
    private int    anzahlMusiktitel;
    
    CD(int nummer, String bezeichnung, int bestand, double preis, String interpret, int anzahlMusiktitel){
        super(nummer, bezeichnung, bestand, preis);
        this.interpret = interpret;
        this.anzahlMusiktitel = anzahlMusiktitel;
    }
    
    public String getBeschreibung(){
        return this.interpret + " : " + this.bezeichnung;
    }
}
