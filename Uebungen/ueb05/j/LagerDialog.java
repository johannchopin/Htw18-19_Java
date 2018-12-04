package a;

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
    private static final int ENDE                       = 0;
    private static final int RUF_LAGER                  = 1;
    private static final int RUF_ANLEGEN                = 2;
    private static final int RUF_LOESCHT_ARTIKEL        = 3;
    private static final int RUF_ARTIKEL_ZUGANG         = 4;
    private static final int RUF_ARTIKEL_ABGANG         = 5;
    private static final int RUF_ARTIKEL_PREIS_AENDERN  = 6;
    private static final int RUF_LAGER_DARSTELLUNG      = 7;
    private static final int RUF_ARTIKEL_DARSTELLUNG    = 8;
    // Konstanten
    private static final String KENNUNG_ARTIKEL_MSG = "Kennung des Artikels: ";
    
    private Scanner input = new Scanner(System.in);
    private Lager lager;
    
    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
        int funktion = -1;
        
        if (!(lager instanceof Lager)){
            System.out.println("\nEin Lager muss geschaffen sein.");
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
            ENDE                      + " : beenden\n" +
            RUF_LAGER                 + " : ein Lager erzeugen\n" +
            RUF_ANLEGEN               + " : ein Artikel im Lager speichern\n" +
            RUF_LOESCHT_ARTIKEL       + " : loescht ein Artikel\n" +
            RUF_ARTIKEL_ZUGANG        + " : Zusatz\n" +
            RUF_ARTIKEL_ABGANG        + " : Abgang\n" +
            RUF_ARTIKEL_PREIS_AENDERN + " : Preis eines Artikels aendern\n" +
            RUF_LAGER_DARSTELLUNG     + " : Der Lager darstellen\n" +
            RUF_ARTIKEL_DARSTELLUNG   + " : Ein Artikel darstellen");
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
                ruf_artikelDarstellung();
                break;
            
            default:            
                System.out.println("Der Wahl ist nicht bekannt. Bitte versuchen es neu");
                break;
        }
    }
    
    /**
     * ruft den Kontruktor des Lagers
     */
    private void ruf_lager(){
        int groesse = helpers.readInt(input, "Groesse des Lagers: ");
        if(this.lager == null) {
            lager = new Lager(groesse);
            System.out.println("Lager ist erzeugt.");}
        else if (helpers.isInputTrue(input, 
                               "Wollen Sie wirklich den alten loeschen (j/n) ?")) {
            lager = new Lager(groesse);
            System.out.println("Lager ist erzeugt.");
        }      
    }
    
    /**
     * ruf die "anlegen" Methode des Lagers
     */
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
            System.out.println("Artikel: %s mit der Kennung %d hinzugefuegt"
                                .format(bezeichnung, nummer));
        } catch(ArrayStoreException|ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }   
    }
    
    /**
     * ruft die "loeschen" Methode des Lagers
     */
    private void ruf_loeschtArtikel(){
        int id = helpers.readInt(input, KENNUNG_ARTIKEL_MSG);
        
        try{
            lager.loeschen(id);
            System.out.println("Artikel ist geloescht.");
        } catch(ArrayStoreException|ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
    
    /**
     * ruft die "Zugang" methode des Lagers
     */
    private void ruf_artikelZugang(){
        int id = helpers.readInt(input, KENNUNG_ARTIKEL_MSG);
        int zusatz = helpers.readInt(input, "Zusatz des Artikels: ");
        
        try{
            lager.artikelZugang(id, zusatz);
            System.out.println(id + "sind hinzugefuegt");
        } catch (ArrayStoreException|IllegalArgumentException e){
            System.out.println(e);
        }
    }
    
    /**
     * ruft die "Abgang" Methode des Lagers
     */
    private void ruf_artikelAbgang(){
        int id = helpers.readInt(input, KENNUNG_ARTIKEL_MSG);
        int absatz = helpers.readInt(input, "Absatz des Artikels: ");
        
        try{
            lager.artikelAbgang(id, absatz);
            System.out.println(absatz + "sind weggenommen.");
        } catch (ArrayStoreException|IllegalArgumentException e){
            System.out.println(e);
        }
    }
    
    /**
     * ruft die "ChangePreis" Methode des Lagers
     */
    private void ruf_artikelPreisAendern(){
       int id = helpers.readInt(input, KENNUNG_ARTIKEL_MSG);
       double prozentsatz = helpers.readDouble(input, "Prozensatz: ");
       
       try{
           lager.artikelPreisAendern(id, prozentsatz);
           System.out.println("gemacht");
       } catch(ArrayStoreException|IllegalArgumentException e){
           System.out.println(e);
       }
    }
    
    /**
     * Stellt die String-Darstellung des Lagers dar.
     */
    private void ruf_lagerDarstellung(){
        System.out.println(lager);
    }
    
    /**
     * Stellt die String-Darstellung des artikel dar.
     */
    private void ruf_artikelDarstellung(){
        int artikelId = helpers.readInt(input, "Artikel Id: ");
        
        try{
            String artikelStrint = lager.getArtikel(artikelId).toString();
            System.out.println(artikelStrint);
        } catch (ArrayStoreException|IllegalArgumentException e){
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
