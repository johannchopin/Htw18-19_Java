import java.util.Scanner;

/**
 * Ermoeglicht die Lager-Klasse zu benutzen
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class LagerDialog
{    
    // Klassenkonstanten : Wahl der Benutzer
    private static final int ENDE                        = 0;
    private static final int RUF_LAGER                   = 1;
    private static final int RUF_ANLEGEN                 = 2;
    private static final int RUF_ARTIKEL_ZUGANG          = 3;
    private static final int RUF_ARTIKEL_ABGANG          = 4;
    private static final int RUF_ARTIKEL_PREIS_ANDERN    = 5;
    private static final int RUF_LAGER_DARSTELLUNG       = 6;

    private Scanner input = new Scanner(System.in);
    private Lager lager;
    
    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
        int funktion = -1;
        
        if (!(lager instanceof Lager)){
            System.out.println("Ein Lager muss geschaffen sein.");
            ruf_lager();
        }
        
        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Irgendeine Ausnahme gefangen: " + e);
                e.printStackTrace(System.out);
                funktion = ENDE;
            }
        }
    }

    /**
     * Menü ausgeben und Wahl einlesen.
     * 
     * @return eingelesene Funktion als ganzzahliger Wert
     */
    private int einlesenFunktion() {
        System.out.println(
            "\n==== Waehlen Sie ein Nummer ====\n" +
            ENDE                     + " : beenden\n" +
            RUF_LAGER                + " : ein Lager erzeugen\n" +
            RUF_ANLEGEN              + " : ein Artikel im Lager speichern\n" +
            RUF_ARTIKEL_ZUGANG       + " : Zusatz zu einem Artikel\n" +
            RUF_ARTIKEL_ABGANG       + " : Abgang\n" +
            RUF_ARTIKEL_PREIS_ANDERN + " : Preis eines Artikels aendern\n" +
            RUF_LAGER_DARSTELLUNG    + " : Der Lager darstellen");
        return input.nextInt();
    }
    
    /**
     * Ausführen der ausgewahlten Funktion
     * 
     * @param wahl fur die auszuführende Funktion
     */
    private void ausfuehrenFunktion(int wahl) {
          switch(wahl) {            
            case ENDE:
                System.out.println("Auf Wiedersehen <3");
                System.exit(0);
           
            case RUF_LAGER:
                ruf_lager();
                break;
        
            case RUF_ANLEGEN:
                ruf_anlegen();
                break;
               
            case RUF_ARTIKEL_ZUGANG:
                ruf_artikelZugang();
                break;
               
            case RUF_ARTIKEL_ABGANG:
                break;
                
            case RUF_ARTIKEL_PREIS_ANDERN:
                break;
         
            case RUF_LAGER_DARSTELLUNG:
                ruf_lagerDarstellung();
                break;
            
            default:            
                System.out.println("Der Wahl ist nicht bekannt. Bitte versuchen es neu");
                break;
        }
    }
    
    private void ruf_lager(){
        int groesse = helpers.readInt(input, "Groesse des Lagers: ");
        if(this.lager != null &&
           helpers.isInputTrue(input, 
                               "Wollen Sie wirklich den alten loeschen (j/n) ?"))
            lager = new Lager(groesse);
        else
            lager = new Lager(groesse);
        System.out.println("Lager ist erzeugt.");
    }
    
    private void ruf_anlegen(){
        int bestand = Artikel.MIN_BESTAND; 
        double preis = Artikel.STANDARTMAESSIGER_PREIS;
        int nummer = helpers.readInt(input, "Nummer: ");
        String bezeichnung = helpers.readLine(input, "Name des Artikels: ");
        
        if(helpers.isInputTrue(input, "Bestand einstellen? (j/n): ")){
            bestand = helpers.readInt(input, "Bestand: ");
        }
        if(helpers.isInputTrue(input, "Preis einstellen? (j/n): ")){
             preis = helpers.readDouble(input, "Preis: ");
        }
        
        try{
            lager.anlegen(nummer, bezeichnung, bestand, preis);
        } catch(ArrayStoreException|ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }   
    }
    
    public void ruf_artikelZugang(){
        int id = helpers.readInt(input, "Kennung des Artikels: ");
        int zusatz = helpers.readInt(input, "Zusatz des Artikels: ");
        
        try{
           lager.artikelZugang(id, zusatz);
        } catch (ArrayStoreException e) {System.out.println(e);}
    }
    
    public void ruf_lagerDarstellung(){
        System.out.println(lager);
    }
    
    /**
     * Main-Methode : Erzeuget des LagerDialog-Objekts und start der
     * Hauptschleife.
     */
    public static void main(String[] args) {
        new LagerDialog().start();
    }
}
