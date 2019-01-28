/**
 * Ein Dialog um die Queue Klasse zu testen
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public abstract class QueueDialogAbstract
{
    public abstract Queue createInstance();
    public enum Funktion { ENDE, QUEUE, ADD_LAST, REMOVE_FIRST, PRINT, 
                           IS_FULL, IS_EMPTY, SIZE};
    String menu = printlnMenu();
    
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

    
                    
}
