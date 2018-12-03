import java.util.Scanner;

/**
 * Ermoeglicht die Lager-Klasse zu benutzen
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class LagerDialog
{
    private Scanner input = new Scanner(System.in);
    private Lager lager;
    
    // Klassenkonstanten : Wahl der Benutzer
    private static final int ENDE                        = 0;
    private static final int RUF_LAGER                   = 1;
    private static final int RUF_ANLEGEN                 = 2;
    private static final int RUF_ARTIKEL_ZUGANG          = 3;
    private static final int RUF_ARTIKEL_ABGANG          = 4;
    private static final int RUF_ARTIKEL_PREIS_ANDERN    = 5;
    private static final int RUF_LAGER_DARSTELLUNG       = 6;

    
    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
        int funktion = -1;
        
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
        try{ return input.nextInt(); }
        catch (Exception e) {
            System.out.println("Die eingabe ist nicht korrekt.");
            return -1;
        }
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
                int groesse = helpers.readInt(input, "Groesse des Lagers: ");
                lager = new Lager(groesse);
                break;
        
            case RUF_ANLEGEN:
                ruf_anlegen();
                break;
               
            case RUF_ARTIKEL_ZUGANG:
                break;
               
            case RUF_ARTIKEL_ABGANG:
                break;
                
            case RUF_ARTIKEL_PREIS_ANDERN:
                break;
         
            case RUF_LAGER_DARSTELLUNG:
                break;
            
            default:            
                System.out.println("Der Wahl ist nicht bekannt. Bitte versuchen es neu");
                break;
        }
    }
    
    private void ruf_anlegen(){
        int bestand = Artikel.MIN_BESTAND; 
        double preis = Artikel.STANDARTMAESSIGER_PREIS;
        int nummer = helpers.readInt(input, "Nummer: ");
        String bezeichnung = helpers.readLine(input, "Name des Artikel: ");
        
        if(helpers.isInputTrue(input, "Bestand einstellen? (j/n): ", 'j')){
            bestand = helpers.readInt(input, "Bestand: ");
        }
        if(helpers.isInputTrue(input, "Preis einstellen? (j/n): ", 'j')){
             preis = helpers.readDouble(input, "Preis (optionnal): ");
        }
        
        try{
            lager.anlegen(nummer, bezeichnung, bestand, preis);
        }
        catch(ArrayStoreException|ArrayIndexOutOfBoundsException e){           {System.out.println(e);} 
            System.out.println(e);
        }   
    }
    
    
    /**
     * Main-Methode : Erzeuget des LagerDialog-Objekts und start der
     * Hauptschleife.
     */
    public static void main(String[] args) {
        new LagerDialog().start();
    }
}
