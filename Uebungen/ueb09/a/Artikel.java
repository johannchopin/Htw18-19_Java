import static java.lang.Math.round;

/**
 * Die Klasse simuliert ein Artikel
 * 
 * @author Guidoux Alexandre && Chopin Johann
 * @version 1.0
 */

public class Artikel {
    private static final int    MIN_ARTIKEL_NUMMER = 1000;
    private static final int    MAX_ARTIKEL_NUMMER = 9999;
    public  static final int    MIN_BESTAND = 0;
    public  static final int    ZAHL_NULL = 0;
    public  static final double STANDARTMAESSIGER_PREIS = 1;

    protected int    nummer;
    protected String bezeichnung;
    protected int    bestand;
    protected double preis; 

    /**
     * @param nummer      Der Nummer muss 4-stellig sein
     * @param bezeichnung Der bezeichnung muss nicht leer sein
     * @param bestand     Der Bestand darf nie kleiner als 0 werden
     * @param preis       Der Preis muss > 0 sein
     */
    public Artikel(int nummer, String bezeichnung, int bestand, double preis) {
        Helpers.check(bezeichnung != null || !bezeichnung.trim().isEmpty(), "Der bezeichnung muss nicht leer sein");
        Helpers.check(nummer >= MIN_ARTIKEL_NUMMER && nummer <= MAX_ARTIKEL_NUMMER, 
            "Der Nummer muss 4-stellig sein"
        );

        this.nummer = nummer;
        this.bezeichnung = bezeichnung.trim();
        setBestand(bestand);
        setPreis(preis);
    }

    public Artikel(int nummer, String bezeichnung){
        this(nummer, bezeichnung, MIN_BESTAND, STANDARTMAESSIGER_PREIS);
    }

    public Artikel(int nummer, String bezeichnung, int bestand){
        this(nummer, bezeichnung, bestand, STANDARTMAESSIGER_PREIS);
    }

    public Artikel(int nummer, String bezeichnung, double preis){
        this(nummer, bezeichnung, MIN_BESTAND, preis);
    }

    /**
     * @return nummer
     */
    public int getNummer() {
        return nummer;
    }

    /**
     * @return bezeichnung
     */
    public String getBeschreibung() {
        return bezeichnung;
    }

    /** 
     * @return bestand
     */
    public int getBestand() {
        return bestand;
    }

    /**
     * @return preis
     */
    public double getPreis() {
        return this.preis;
    }

    /** 
     * @param bestand muss immer >= 0 sein
     */
    private void setBestand(int bestand) {
        Helpers.check(bestand >= ZAHL_NULL, 
            "Der Bestand darf nicht < 0 werden.");
        this.bestand = bestand;
    }

    /**
     * @param preis muss immer > 0 sein
     */
    private void setPreis(double preis){
        preis = (double)round(preis * 100) / 100 ;
        Helpers.check(preis > ZAHL_NULL,
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
        System.out.println((prozentsatz/100 + 1) * preis);
        setPreis((prozentsatz/100 + 1) * preis);
    }

    public void ChangePreis(int prozentsatz){
        ChangePreis((double)prozentsatz);
    }

    /**
     * @param zusatz muss immer > 0 sein
     */
    public void zugang(int zusatz) {
        Helpers.check(zusatz > ZAHL_NULL, 
            "Der Zusatz darf nicht <= 0 sein.");
        setBestand(this.bestand + zusatz);
    }

    /**
     * @param absatz muss immer > 0 sein
     */
    public void abgang(int absatz) {
        Helpers.check(absatz > ZAHL_NULL, 
            "Der Abgang darf nicht <= 0 sein.");
        setBestand(this.bestand - absatz);
    }
    
    public String toString(){
        return String.format("%-5s  %-50s  %-5s  %-7s  %6.2f",
                this.nummer, this.getBeschreibung(), 
                this.preis, this.bestand, this.bestand*this.preis);
    }
}