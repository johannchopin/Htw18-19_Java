import java.util.Scanner;
import java.lang.StringBuffer;

/**
 * Ermoeglicht die Lager-Klasse zu benutzen
 *
 * ! Code ruf_artikel_darstellung
 *
 * @author Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class LagerDialog
{    
    // Klassenkonstanten : Funktion der Benutzer
    enum Funktion { ENDE, RUF_LAGER, RUF_ANLEGEN, RUF_LOESCHT_ARTIKEL, 
        RUF_ARTIKEL_ZUGANG, RUF_ARTIKEL_ABGANG, 
        RUF_ARTIKEL_PREIS_AENDERN, RUF_LAGER_DARSTELLUNG,
        RUF_ARTIKEL_DARSTELLUNG};
    enum ArtikelType { STANDARD, BUCH, CD, VIDEO };
    String menuString = printlnMenu();
    String artikelMenu = printlnArtikelWahl();

    private static final String KENNUNG_ARTIKEL_MSG = "Kennung des Artikels: ";
    private Scanner input = new Scanner(System.in);
    private ArtikelLager lager;

    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
        if (!(lager instanceof ArtikelLager)){
            System.out.println("Ein Lager muss geschaffen sein.");
            ruf_lager();
        }

        Funktion wahl = Funktion.RUF_LAGER;
        while (wahl != Funktion.ENDE) {
            try {
                wahl = einlesenFunktion();
                ausfuehrenFUNKTION(wahl);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Irgendeine Ausnahme gefangen: " + e);
                e.printStackTrace(System.out);
                wahl = Funktion.ENDE;
            }
        }
    }

    /**
     * @return String Darstellung des Menues
     */
    private String printlnMenu(){
        StringBuffer output = new StringBuffer();
        output.append("\n==== Waehlen Sie ein Nummer ====\n");
        for (Funktion value : Funktion.values()){
            output.append(value.ordinal()).append(": ")
            .append(value).append('\n');
        }
        output.append("--> ");    
        output.trimToSize();
        return output.toString();
    }

    /**
     * Schafft eine String, die das Menu dargestellt
     */
    private String printlnArtikelWahl(){
        StringBuffer output = new StringBuffer();
        output.append("\n==== Waehlen Sie ein Nummer ====\n");
        for (ArtikelType value : ArtikelType.values()){
            output.append(value.ordinal()).append(": ")
            .append(value).append('\n');
        }
        output.append("--> ");    
        output.trimToSize();
        return output.toString();
    }

    /**
     * der Wert von FUNKTION ist mit der Ordinalzahl nummer verbunden
     * @return eine Wert von FUNKTION
     */
    private Funktion intToFunktion(int nummer){
        for(Funktion f: Funktion.values()){
            if(nummer == f.ordinal())
                return f;
        }
        return Funktion.ENDE;
    }

    /**
     * der Wert von ArtikelType ist mit der Ordinalzahl nummer verbunden
     * @return eine Wert von ArtikelType
     */
    private ArtikelType intToArtikelType(int nummer){
        for(ArtikelType a: ArtikelType.values()){
            if(nummer == a.ordinal())
                return a;
        }
        return ArtikelType.STANDARD;
    }

    /**
     * Menü ausgeben und FUNKTION einlesen.
     * 
     * @return eingelesene FUNKTION als ganzzahliger Wert
     */
    private Funktion einlesenFunktion() {        
        System.out.println(menuString);
        int eingabe = input.nextInt();
        if (eingabe >= 0 && eingabe < Funktion.values().length)
            return intToFunktion(eingabe);
        else{
            System.out.println("Falsche FUNKTION: " + eingabe + 
                ".Bitte versucht es neue\nWeitermachen...Druck ENTER");
            input.nextLine();
            return einlesenFunktion();
        }
    }

    /**
     * Ausführen der ausgeFUNKTIONten FUNKTION
     * 
     * @param FUNKTION fur die auszuführende FUNKTION
     */
    private void ausfuehrenFUNKTION(Funktion wahl) {
        switch(wahl) {            
            case ENDE:
            System.out.println("Auf Wiedersehen <3");
            System.exit(0);

            case RUF_LAGER:
            ruf_lager();
            break;

            case RUF_ANLEGEN:
            try{
                ruf_anlegen();
            }catch(ArrayStoreException|IndexOutOfBoundsException e){
                System.out.println("Lager ist voll. Abbruch");
            }
            break;

            case RUF_LOESCHT_ARTIKEL:
            ruf_loeschtArtikel();
            break;

            case RUF_ARTIKEL_ZUGANG:
            ruf_artikelZugang();
            break;

            case RUF_ARTIKEL_ABGANG:
            ruf_artikelAbgang();
            break;

            case RUF_ARTIKEL_PREIS_AENDERN:
            ruf_artikelPreisAendern();
            break;

            case RUF_LAGER_DARSTELLUNG:
            ruf_lagerDarstellung();
            break;
            
            case RUF_ARTIKEL_DARSTELLUNG:
                rufArtikelDarstellung();
            break;

            default:            
            System.out.println("Der FUNKTION ist nicht bekannt. Bitte versuchen es neu");
            break;
        }
    }

    /**
     * ruft den Kontruktor des Lagers
     */
    void ruf_lager(){
        int groesse = Helpers.readInt(input, "Groesse des Lagers: ");
        if(this.lager != null &&
        Helpers.isInputTrue(input, 
            "Wollen Sie wirklich den alten loeschen (j/n) ?"))
            this.lager = new ArtikelLager(groesse);
        else
            this.lager = new ArtikelLager(groesse);
        System.out.println("Lager ist erzeugt.");
    }

    /**
     * ruf die "anlegen" Methode des Lagers
     */
    private void ruf_anlegen(){
        // Standard values for an article
        int nummer, bestand; 
        double preis;
        String bezeichnung;
        // Buch values
        String autor, verlag;
        // CD values
        String interpret;
        int anzahlMusikTitel;
        // Video values
        double spieldauer;
        int erscheinungsjahr;
        // Choice the type of article
        ArtikelType wahl = intToArtikelType(
                Helpers.readInt(input, artikelMenu)
            );

        // Must-have variables initialization
        nummer = Helpers.readInt(input, "Nummer: ");
        bezeichnung = Helpers.readLine(input, "Titel oder Name des Artikels: ");
        bestand = Artikel.MIN_BESTAND;
        preis = Artikel.STANDARTMAESSIGER_PREIS;
        if(Helpers.isInputTrue(input, "Bestand einstellen? (j/n): ")){
            bestand = Helpers.readInt(input, "Bestand: ");
        }
        if(Helpers.isInputTrue(input, "Preis einstellen? (j/n): ")){
            preis = Helpers.readDouble(input, "Preis: ");
        }

        switch(wahl){
            case STANDARD:
            this.lager.anlegen(nummer, bezeichnung, bestand, preis);
            System.out.println("Artikel: %s mit der Kennung %d hinzugefuegt"
                .format(bezeichnung, nummer));
            break;

            case BUCH:
            autor = Helpers.readLine(input, "Name des Autors: ");
            verlag = Helpers.readLine(input, "Name des Verlags: ");
            this.lager.anlegen(
                new Buch(nummer, bezeichnung, bestand, preis, autor, verlag)
            );
            System.out.println("Buch: %s mit der Kennung %d hinzugefuegt"
                .format(bezeichnung, nummer));
            break;

            case CD:
            interpret = Helpers.readLine(input, "Name des Interpret: ");
            anzahlMusikTitel = Helpers.readInt(input, "Anzahl der Musik: ");
            this.lager.anlegen(
                new CD(nummer, bezeichnung, bestand, preis, interpret, anzahlMusikTitel)
            );
            System.out.println("CD: %s mit der Kennung %d hinzugefuegt"
                .format(bezeichnung, nummer));
            break;

            case VIDEO:
            spieldauer = Helpers.readDouble(input, "Spieldauer (in Minuten): ");
            erscheinungsjahr = Helpers.readInt(input, "Erscheinungsjahr: ");
            this.lager.anlegen(
                new Video(nummer, bezeichnung, bestand, preis, spieldauer, erscheinungsjahr)
            );
            System.out.println("Video: %s mit der Kennung %d hinzugefuegt"
                .format(bezeichnung, nummer));
            break;

            default:
            System.out.println("Artikel nicht erkannt. Abbruch.");
        }
    }

    /**
     * ruft die "loeschen" Methode des Lagers
     */
    private void ruf_loeschtArtikel(){
        int id = Helpers.readInt(input, KENNUNG_ARTIKEL_MSG);
        try{
            this.lager.loeschen(id);
            System.out.println("Artikel ist geloescht.");
        } catch(ArrayStoreException|ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

    /**
     * ruft die "Zugang" methode des Lagers
     */
    private void ruf_artikelZugang(){
        int id = Helpers.readInt(input, KENNUNG_ARTIKEL_MSG);
        int zusatz = Helpers.readInt(input, "Zusatz des Artikels: ");
        try{
            this.lager.artikelZugang(id, zusatz);
            System.out.println(id + "sind hinzugefuegt");
        } catch (ArrayStoreException|IllegalArgumentException e){
            System.out.println(e);
        }
    }

    /**
     * ruft die "Abgang" Methode des Lagers
     */
    private void ruf_artikelAbgang(){
        int id = Helpers.readInt(input, KENNUNG_ARTIKEL_MSG);
        int absatz = Helpers.readInt(input, "Absatz des Artikels: ");

        try{
            this.lager.artikelAbgang(id, absatz);
            System.out.println(absatz + "sind weggenommen.");
        } catch (ArrayStoreException|IllegalArgumentException e){
            System.out.println(e);
        }
    }

    /**
     * ruft die "ChangePreis" Methode des Lagers
     */
    private void ruf_artikelPreisAendern(){
        int id = Helpers.readInt(input, KENNUNG_ARTIKEL_MSG);
        double prozentsatz = Helpers.readDouble(input, "Prozensatz: ");

        try{
            this.lager.artikelPreisAendern(id, prozentsatz);
            System.out.println("gemacht");
        } catch(ArrayStoreException|IllegalArgumentException e){
            System.out.println(e);
        }
    }

    /**
     * Stellt die String-Darstellung des Lagers dar.
     */
    private void ruf_lagerDarstellung(){
        System.out.println(this.lager);
    }
    
    private String rufArtikelDarstellung(){
        return "NOT IMPLEMENTED";
    }

    /**
     * Main-Methode : Erzeuget des LagerDialog-Objekts und start der
     * Hauptschleife.
     */
    public static void main(String[] args) {
        LagerDialog currentStore = new LagerDialog();
        currentStore.start();
    }

    // Trick to generate a Lager with LagerCreator
    public LagerDialog(ArtikelLager currentLager){
        this.lager = currentLager;
    }
    public LagerDialog(){
        this.lager = null;
    };
}
