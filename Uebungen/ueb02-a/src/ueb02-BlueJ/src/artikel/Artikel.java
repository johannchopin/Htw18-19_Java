package src.artikel;

/**
 * 
 * Die Klasse simuliert ein Artikel
 * 
 * @author leparesseux
 * @version 1.0
 */
public class Artikel {
    private final static int MIN_NUMMER = 1000;
    private final static int MAX_NUMMER = 10000;
    private final static int DEFAULT_BESTAND = 0;
    
    private int nummer;
    private String bezeichnung;
    private int bestand;

    /**
     * IllegalArgumentException mit @nachricht zurückgesendet, wenn die @bedigung
     * falsch ist
     * 
     * @param bedigung
     * @param nachricht die Nachricht der Ausnahme
     */
    public void check(boolean bedigung, String nachricht) {
        if (!bedigung)
            throw new IllegalArgumentException(nachricht);
    }
    
    public Artikel(int nummer, String bezeichnung, int bestand) {
        check(bezeichnung != null || !bezeichnung.trim().isEmpty(), "Der Bezeichnung muss nicht leer sein.");
        check(MIN_NUMMER <= nummer && nummer <= MAX_NUMMER, "Der Nummer muss 4-stellig sein");

        this.nummer = nummer;
        this.bezeichnung = bezeichnung;
        setBestand(bestand);
    }

    public Artikel(int nummer, String bezeichnung) {
        this(nummer, bezeichnung, DEFAULT_BESTAND);
    }

    /**  
     * einfach der nummer zuruecksenden
     */
    public int getNummer() {
        return nummer;
    }

     /**  
     * einfach die Bezeichnung zuruecksenden
     */
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**  
     * einfach der Bestand zuruecksenden
     */
    public int getBestand() {
        return bestand;
    }

    /**
     * 
     * @param bestand muss immer >= 0 sein
     */
    public void setBestand(int bestand) {
        check(bestand >= DEFAULT_BESTAND, "Der Bestand darf nicht < 0 werden.");
        this.bestand = bestand;
    }

    private void setBestand(int bestand, boolean bedigung, String nachricht) {
        check(bedigung, nachricht);
        this.bestand = bestand;
    }

    /**
     * 
     * @param zusatz muss immer > 0 sein
     */
    public void zugang(int zusatz) {
        setBestand(this.bestand + zusatz, 
                   zusatz > 0, 
                   "Der Zusatz muss > 0 sein");
    }

    /**
     * 
     * @param absatz muss immer > 0 und <= this.bestand sein
     */
    public void abgang(int absatz) {
        setBestand(this.bestand - absatz, 
                   DEFAULT_BESTAND < absatz && absatz <= this.bestand, 
                   "Der Absatz darf nicht < 0 sein");
    }

    public String toString() {
        return "Artikel : " + getNummer() + 
               " Bezeichnung: " + getBezeichnung() + 
               " Bestand: " + getBestand();
    }
}
