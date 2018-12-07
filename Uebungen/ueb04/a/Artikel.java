import static java.lang.Math.round;

/**
 * 
 * Die Klasse simuliert ein Artikel
 * 
 * @author Guidoux Alexandre && Chopin Johann
 * @version 1.0
 */

public class Artikel {
    public static final int MIN_ARTIKEL_NUMMER = 1000;
    public static final int MAX_ARTIKEL_NUMMER = 9999;
    public static final int ZAHL_NULL = 0;
    public static final double STANDARTMAESSIGER_PREIS = 1;
        
    private int nummer;
    private String bezeichnung;
    private int bestand;
    private double preis; 
    
    /**
     * @param nummer      Der Nummer muss 4-stellig sein
     * @param bezeichnung Der Bezeichnung muss nicht leer sein
     * @param bestand     Der Bestand darf nie kleiner als 0 werden
     * @param preis       Der Preis muss > 0 sein
     */
    public Artikel(int nummer, String bezeichnung, int bestand, double preis) {
        helpers.check(bezeichnung != null || !bezeichnung.trim().isEmpty(), "Der Bezeichnung muss nicht leer sein");
        helpers.check(nummer >= MIN_ARTIKEL_NUMMER && nummer <= MAX_ARTIKEL_NUMMER, 
               "Der Nummer muss 4-stellig sein"
             );
        
        this.nummer = nummer;
        this.bezeichnung = bezeichnung.trim();
        setBestand(bestand);
        setPreis(preis);
    }
    
    /**
     * Falls es noch keinen Bestand und keinen Preis gibt.
     * 
     * @param nummer      Der Nummer muss 4-stellig sein
     * @param bezeichnung Der Bezeichnung muss nicht leer sein
     */
    public Artikel(int nummer, String bezeichnung){
        this(nummer, bezeichnung, ZAHL_NULL, STANDARTMAESSIGER_PREIS);
    }
    
    /**
     * Gibt einfach der Nummer zurueck.
     * 
     * @return nummer
     */
    public int getNummer() {
        return nummer;
    }
    
    /**
     * Gibt einfach die Bezeichnung zurueck.
     * 
     * @return bezeichnung
     */
    public String getBezeichnung() {
        return bezeichnung;
    }
    
    /**
     * Gibt einfach der Bestand zurueck.
     * 
     * @return bestand
     */
    public int getBestand() {
        return bestand;
    }
        
    /**
     * Gibt einfach der Preis zurueck.
     * 
     * @return preis
     */
    public double getPreis() {
        return this.preis;
    }
    
    /**
     * Stellt der Bestand ein.
     * 
     * @param bestand muss immer >= 0 sein
     */
    private void setBestand(int bestand) {
        helpers.check(bestand >= ZAHL_NULL, 
                      "Der Bestand darf nicht < 0 werden.");
        this.bestand = bestand;
    }
    
    /**
     * Stellt der Preis ein.
     * 
     * @param preis muss immer > 0 sein
     */
    private void setPreis(double preis){
        preis = (double)round(preis * 100) / 100 ;
        helpers.check(preis > ZAHL_NULL,
                      "Der Preis darf nicht < 0 werden.");
        this.preis = preis;
    }
    private void setPreis(int preis){
        setPreis((double)preis);
    }
    
    /**
     * Veraendert den Preis mit einem bestimmten prozensatz
     * 
     * @param prozensatz 
     */
    public void ChangePreis(double prozentsatz){
        setPreis((1 + prozentsatz) * preis);
    }
    public void ChangePreis(int prozentsatz){
        ChangePreis((double)prozentsatz);
    }
    

    /**
     * @param zusatz muss immer > 0 sein
     */
    public void zugang(int zusatz) {
        helpers.check(zusatz > ZAHL_NULL, 
                      "Der Zusatz darf nicht <= 0 sein.");
        setBestand(this.bestand + zusatz);
    }

    /**
     * @param absatz muss immer > 0 sein
     */
    public void abgang(int absatz) {
        helpers.check(absatz > ZAHL_NULL, 
                      "Der Abgang darf nicht <= 0 sein.");
        setBestand(this.bestand - absatz);
    }
    
    
    public String toString() {
        return "Artikel : "     + getNummer() +
               " Bezeichnung: " + getBezeichnung() + 
               " Bestand: "     + getBestand() + 
               " Preis : "      + getPreis();
    }
}