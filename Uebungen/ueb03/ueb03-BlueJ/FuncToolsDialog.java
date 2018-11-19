import java.util.Scanner;

/**
 * Interaktive Testklasse für die FuncTools methoden
 *
 * @author Guidoux Alexandre
 * @version 1.0
 */
public class FuncToolsDialog {
    private static FuncTools methoden;
    private Scanner input = new Scanner(System.in);

    // Klassenkonstanten : Wahl der Benutzer
    private static final int ENDE                      = 0;
    private static final int RUF_TEILERSUMME           = 1;
    private static final int RUF_ISBNRECHNER           = 2;
    private static final int RUF_QUADRATISCHEGLEICHUNG = 3;

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
     * Menü ausgeben und Funktion einlesen.
     * 
     * @return eingelesene Funktion als ganzzahliger Wert
     */
    private int einlesenFunktion() {
        System.out.println(
            "\n==== Waehlen Sie ein Nummer ====\n" +
            ENDE + " : beenden\n" +
            RUF_TEILERSUMME + " : teilersumme\n" +
            RUF_ISBNRECHNER + " : isbnRechner\n" +
            RUF_QUADRATISCHEGLEICHUNG + " : quadratische Gleichung\n");
        return input.nextInt();
    }
    
    /**
     * Ausführen der ausgewahlten Funktion
     * 
     * @param wahl fur die auszuführende Funktion
     */
    private void ausfuehrenFunktion(int wahl) {
        double p, q;
        switch(wahl) {
            case ENDE:
                System.out.println("Auf Wiedersehen <3");
                System.exit(0);
           
            case RUF_TEILERSUMME:
                ruf_teilerSumme();
                break;
               
            case RUF_ISBNRECHNER:
                ruf_isbnRechner();
                break;
               
            case RUF_QUADRATISCHEGLEICHUNG:
                ruf_quadratischeGleichung();
                break;
         
            default:            
                System.out.println("Der Wahl ist nicht bekannt. Bitte versuchen es neu");
                break;
        }
    }
    
    private void ruf_teilerSumme(){
        System.out.print("Nummer eintragen: ");
        try {
            long n = input.nextLong(); input.reset();
            long result = methoden.teilerSumme(n);
            System.out.println("Result : " + result);
        } catch(Exception e){
            System.out.println(methoden.MSG_TEILERSUMME);
        }
    }
    
    private void ruf_isbnRechner(){
        System.out.print("ISBN eintragen: ");
        try {
            long isbn = input.nextLong(); input.reset();
            String result = methoden.isbnRechner(isbn);
            System.out.println("\nLetze nummer ausgerechnet: " + result); 
        } catch(IllegalArgumentException e) {
            System.out.println(methoden.MSG_ISBNRECHNER);
        }
    }
    
    private void ruf_quadratischeGleichung(){
        System.out.print("p-Wert: ");
        try{
            double p = input.nextDouble(); input.reset();
            System.out.print("\nq-Wert: ");
            double q = input.nextDouble(); input.reset();
            String result = methoden.quadratischeGleichung(p, q);
            System.out.println("\nNachricht zurueckgegeben: " + result);
        } catch(Exception e){
            System.out.println("Es muss ein nummer sein (" + e + ")");
        }
    }
    
    /**
     * Main-Methode zum Erzeugen des KontoDialog-Objektes und zum Anstarten der
     * Testschleife
     */
    public static void main(String[] args) {
        new FuncToolsDialog().start();
    }
}
