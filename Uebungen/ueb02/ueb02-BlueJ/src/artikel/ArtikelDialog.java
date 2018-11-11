package src.artikel;

import java.util.Scanner;

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
    
    /*
     * @return die Wahl (input) des Benutzers
     */
    private int einlesen() {
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
     */
    private void ausfuehrenFunktion(int wahl) {
        switch(wahl) {
            case ENDE:
                System.exit(0);
                
            case ANLEGEN:
                System.out.print("Nummer : ");
                int nummer = input.nextInt(); input.nextLine();
                System.out.print("\nName des Artikel : ");
                String name = input.nextLine();
                System.out.print("\nBestand : ");
                int bestand = input.nextInt(); input.nextLine();
                System.out.print("\n");
                artikel1 = new Artikel(nummer, name, bestand);
                break;
            
            case ZUSTAND:
                System.out.println(artikel1);
                break;
                
            case SET_BESTAND:
                System.out.print("neuer Bestand : ");
                int neuerBestand = input.nextInt(); input.nextLine();
                System.out.print("\n");
                artikel1.setBestand(neuerBestand);
                break;
                
            case ZUGANG:
                System.out.print("Zusatz : ");
                int zusatz = input.nextInt(); input.nextLine();
                System.out.print("\n");
                artikel1.zugang(zusatz);
                break;
                
            case ABGANG:
                System.out.print("Absatz : ");
                int absatz = input.nextInt(); input.nextLine();
                System.out.print("\n");
                artikel1.zugang(absatz);
                break;
                
            default:
            
            System.out.println("Der Nummer ist nicht bekannt. Bitte versuchen es neu");
                break;
        }
    }

    /*
     * Main Funktion. Der benutzer kann das Objekt Artikel manipulieren.
     */
    private void start() {
        artikel1 = null;
        int funktion = -1;
        
        while(funktion != ENDE) {
            try {
                funktion = einlesen();
                ausfuehrenFunktion(funktion); 
            } 
            catch (Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        }
    }
    
   /*
    * Lauft die main-funktion
    */ 
   public static void main(String[] args) {
        new ArtikelDialog().start();
    }

}
