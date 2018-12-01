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
    public static final int MIN_BESTAND = 0;
        
    private int nummer;
    private String bezeichnung;
    private int bestand;
    
    /**
     * @param nummer      Der Nummer muss 4-stellig sein
     * @param bezeichnung Der Bezeichnung muss nicht leer sein
     * @param bestand     Der Bestand darf nie kleiner als 0 werden
     */
    public Artikel(int nummer, String bezeichnung, int bestand) {
        helpers.check(bezeichnung != null || !bezeichnung.trim().isEmpty(), "Der Bezeichnung muss nicht leer sein");
        helpers.check(nummer >= MIN_ARTIKEL_NUMMER && nummer <= MAX_ARTIKEL_NUMMER, 
               "Der Nummer muss 4-stellig sein"
             );
        
        this.nummer = nummer;
        this.bezeichnung = bezeichnung.trim();
        setBestand(bestand);
    }
    
    /**
     * @param nummer      Der Nummer muss 4-stellig sein
     * @param bezeichnung Der Bezeichnung muss nicht leer sein
     */
    public Artikel(int nummer, String bezeichnung){
        this(nummer, bezeichnung, MIN_BESTAND);
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
     * Git einfach der Bestand zurueck.
     * 
     * @return bestand
     */
    public int getBestand() {
        return bestand;
    }
    
    /**
     * @param bestand muss immer >= 0 sein
     */
    private void setBestand(int bestand) {
        helpers.check(bestand >= MIN_BESTAND, 
                      "Der Bestand darf nicht < 0 werden.");
        this.bestand = bestand;
    }
    

    /**
     * @param zusatz muss immer > 0 sein
     */
    public void zugang(int zusatz) {
        helpers.check(zusatz > MIN_BESTAND, 
                      "Der Zusatz darf nicht <= 0 sein.");
        setBestand(this.bestand + zusatz);
    }

    /**
     * @param absatz muss immer > 0 sein
     */
    public void abgang(int absatz) {
        helpers.check(absatz > MIN_BESTAND, 
                      "Der Abgang darf nicht <= 0 sein.");
        setBestand(this.bestand - absatz);
    }
    
    
    public String toString() {
        return "Artikel : "     + getNummer() +
               " Bezeichnung: " + getBezeichnung() + 
               " Bestand: "     + getBestand();
    }
}