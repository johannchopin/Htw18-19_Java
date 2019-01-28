import java.util.Scanner;
import java.lang.StringBuffer;
/**
 * Ein Testprogramm, um die Queue Implementierungen zu testen
 *
 * @author Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class QueueDialog
{
    enum Funktion {ENDE, QUEUE, ADD_LAST, REMOVE_FIRST, GET, IS_EMPTY, IS_FULL, SIZE, PRINT};
    enum Queues {StringQueue, PersonQueue};
    String menuString = printlnMenu();
    String queuesString = printlnQueues();
    
    private Scanner sc = new Scanner(System.in);
    private Queue queue;
    
    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
        if(!(this.queue instanceof Queue))
            this.queue = queueDialog();

        Funktion wahl = Funktion.GET; // BAD VALUE
        while (wahl != Funktion.ENDE) {
            try {
                wahl = einlesenFunktion();
                ausfuehrenFUNKTION(wahl);
            } catch (IllegalArgumentException e) {
                e.printStackTrace(System.out);
            } catch (Exception e) {
                System.out.println("Irgendeine Ausnahme gefangen: " + e);
                e.printStackTrace(System.out);
                wahl = Funktion.ENDE;
            }
        }
    }
    
    /**
     * Menü ausgeben und FUNKTION einlesen.
     * 
     * @return eingelesene FUNKTION als ganzzahliger Wert
     */
    private Funktion einlesenFunktion() {        
        System.out.println(menuString);
        int eingabe = sc.nextInt();
        if (eingabe >= 0 && eingabe < Funktion.values().length)
            return intToFunktion(eingabe);
        else{
            System.out.println("Falsche FUNKTION: " + eingabe + 
                ".Bitte versucht es neue\nWeitermachen...Druck ENTER");
            sc.next();
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
            
            case QUEUE:
                this.queue = queueDialog();
                break;
                
            case ADD_LAST:
                addLastDialog();
                break;
                
            case REMOVE_FIRST:
                removeFirstDialog();
                break;
            
            case GET:
                getDialog();
                break;
                
            case IS_EMPTY:
                isEmptyDialog();
                break;
                
            case IS_FULL:
                isFullDialog();
                break;
                
            case SIZE:
                sizeDialog();
                break;
           
            case PRINT:
                printQueue(queue);
                break;
                
            default:            
                System.out.println("Der FUNKTION ist nicht bekannt. Bitte versuchen es neu");
            break;
        }
    }
    
    private void addLastDialog(){
        if(this.queue instanceof StringQueue){
            String s = ScannerHelpers.readLine(sc, "String hinzufuegen: ");    
            this.queue.addLast(new String(s));
        }
        else if(this.queue instanceof PersonQueue){
            String name = ScannerHelpers.readLine(sc, "Name: ");
            String vorname = ScannerHelpers.readLine(sc, "Vorname: ");
            this.queue.addLast(new Person(name, vorname));
        }
        else
            System.out.println("Der Queue ist nicht vereinbar");
    }
    
    private void removeFirstDialog(){
        System.out.println(this.queue.removeFirst());
    }
    
    private void getDialog(){
        System.out.println(this.queue.get(
            ScannerHelpers.readInt(sc, "Stelle des Element: ")
        ));
    }
    
    private void isEmptyDialog(){
        System.out.println(this.queue.isEmpty());
    }
    
    private void isFullDialog(){
        System.out.println(this.queue.isFull());
    }
    
    private void sizeDialog(){
        System.out.println(this.queue.size());
    }
    
    private void printQueue(Queue q){
       int obereGrenze = q.size() + 1;
       for(int i=1; i < obereGrenze; i++) // get-Methode start at 1 
            System.out.println(i + " -> " + q.get(i).toString());
    }
    
    /**
     * Stellt ein neuer Queue ein.
     * @return der neue Queue
     */
    private Queue queueDialog(){
        if (this.queue instanceof Queue){
            System.out.println("Der alte Queue wird geloescht.");
            boolean abbruch = !(ScannerHelpers.isInputTrue(sc, "Abbruch (J/n)? "));
            if(abbruch)
                return queue;
        }
        int wahl = ScannerHelpers.readInt(sc, queuesString);
        int groesse = ScannerHelpers.readInt(sc, "Groesse: ");
        switch(wahl){
            case 0:
                this.queue = new StringQueue(groesse);
                break;
                
            case 1:
                this.queue = new PersonQueue(groesse);
                break;
                
            default:
                System.out.println("Unbekannter Nummer.");
                return queueDialog();
        }
        return queue;
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
     * @return String Darstellung des Menues
     */
    private String printlnQueues(){
        StringBuffer output = new StringBuffer();
        output.append("\n==== Waehlen Sie ein Nummer ====\n");
        for (Queues value : Queues.values()){
            output.append(value.ordinal()).append(": ")
            .append(value).append('\n');
        }
        output.append("--> ");    
        output.trimToSize();
        return output.toString();
    }
    
    public QueueDialog(){
        start();
    }
    
    public QueueDialog(Queue q){
        this.queue = q;
        start();
    }
    
    public static void main(String[] args){
        new QueueDialog().start();
    }
}
