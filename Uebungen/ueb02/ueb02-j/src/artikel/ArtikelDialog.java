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
    
    // Moglichkeiten der Wahl des Benutzers
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
        artikel1 = null;
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
    
    /*
     * @return die Wahl (input) des Benutzers
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
    
    /*
     * Lauft die richtige gewaehlte Funktion
     * 
     * @param wahl auszuführende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion(int wahl) {
        int nummer;
        int bestand;
        int neuerBestand;
        int zusatz;
        int absatz;
        
        switch(wahl) {
            case ENDE:
                System.exit(0);
                
            case ANLEGEN:
                System.out.print("Nummer : ");
                nummer = input.nextInt(); input.nextLine();
                System.out.print("Name des Artikel : ");
                String name = input.nextLine();
                System.out.print("Bestand : ");
                bestand = input.nextInt(); input.nextLine();
                System.out.print("\n");
                artikel1 = new Artikel(nummer, name, bestand);
                break;
            
            case ZUSTAND:
                System.out.println(artikel1);
                break;
                
            case SET_BESTAND:
                System.out.print("neuer Bestand : ");
                neuerBestand = input.nextInt(); input.nextLine();
                System.out.print("\n");
                artikel1.setBestand(neuerBestand);
                break;
                
            case ZUGANG:
                System.out.print("Zusatz : ");
                zusatz = input.nextInt(); input.nextLine();
                System.out.print("\n");
                artikel1.zugang(zusatz);
                break;
                
            case ABGANG:
                System.out.print("Absatz : ");
                absatz = input.nextInt(); input.nextLine();
                System.out.print("\n");
                artikel1.zugang(absatz);
                break;
                
            default:
            
            System.out.println("Der Wahl ist nicht bekannt. Bitte versuchen es neu");
                break;
        }
    }

   /*
    * Main-Methode zum Erzeugen des ArtikelDialog-Objektes und zum Anstarten der Testschleife
    */ 
   public static void main(String[] args) {
        new ArtikelDialog().start();
    }

}
