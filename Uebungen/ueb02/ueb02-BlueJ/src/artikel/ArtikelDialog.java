package src.artikel;

import java.util.Scanner;

/**
 * Interaktive Testklasse für die Klasse Artikel
 *
 * @author Guidoux Alexandre && Chopin Johann
 * @version 1.0
 */
public class ArtikelDialog {
    private Artikel artikel1;
    private Scanner input = new Scanner(System.in);

    // Klassenkonstanten
    private static final int ENDE        = 0;
    private static final int ANLEGEN     = 1;
    private static final int ZUSTAND     = 2;
    private static final int SET_BESTAND = 3;
    private static final int ZUGANG      = 4;
    private static final int ABGANG      = 5;

    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
        artikel1 = artikelAnlegen();
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
            }
        }
    }

    /**
     * Menü ausgeben und Funktion einlesen.
     * 
     * @return eingelesene Funktion als ganzzahliger Wert
     */
    private int einlesenFunktion() {
        System.out.println(ENDE + ": beenden; " +
            ANLEGEN + ": anlegen; " +
            ZUSTAND + ": zustand; " +
            SET_BESTAND + ": bestand einstellen; " + 
            ZUGANG + ": zugang; " +
            ABGANG + ": abgang; ");
        return input.nextInt();
    }

    /**
     * Ausführen der ausgewahlten Funktion
     * 
     * @param wahl auszuführende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion(int wahl) {
        switch(wahl) {
            case ENDE:
                System.exit(0);

            case ANLEGEN:
                artikel1 = artikelAnlegen();
                break;

            case ZUSTAND:
                System.out.println(artikel1);
                break;

            case SET_BESTAND:
                artikel1.setBestand(einleseBetrag("neuer Bestand : "));
                break;

            case ZUGANG:
                artikel1.zugang(einleseBetrag("Zusatz : "));
                break;

            case ABGANG:
                artikel1.abgang(einleseBetrag("Absatz : "));
                break;

            default:            
                System.out.println("Der Wahl ist nicht bekannt. Bitte versuchen es neu");
                break;
        }
    }


    /**
     * @return Ein ergestellte Artikel Object
     */
    private Artikel artikelAnlegen() {
        System.out.print("Nummer : ");
        int nummer = input.nextInt();
        input.nextLine();
        System.out.print("Name des Artikel : ");
        String name = input.nextLine();
        System.out.print("Bestand (optionnal) : ");
        String bestand = input.nextLine();
        System.out.println();
        if(bestand.trim().isEmpty())
            return new Artikel(nummer, name);
        else
            return new Artikel(nummer, name, Integer.parseInt(bestand));
    }

    
    /**
     * @param meldung Meldung fur der Benutzer 
     * @return Das Wahl der benutzer
     */
    private int einleseBetrag(String meldung) {
        System.out.print(meldung);
        return input.nextInt();
    }


    /**
     * Main-Methode zum Erzeugen des KontoDialog-Objektes und zum Anstarten der
     * Testschleife
     */
    public static void main(String[] args) {
        new ArtikelDialog().start();
    }

}
