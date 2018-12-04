import static java.lang.Math.abs;
import static java.util.Arrays.parallelSort;

/**
 * Implementiert ein paar Methoden 
 *
 * @author Alexandre Guidoux & Johann Chopin
 * @version 1.0
 */
public class Tools
{
    
    final private static double MIN_UPSILON = 1e-15;
    final private static double MAX_UPSILON = 1e-15;
    
    
    /**
     * Rechnet die arithmetische Mittel einer Tabelle
     * 
     * @param tab
     */
    // TODO : BinarySearch in tab to find the 2 values :
    // - the most distant value
    // - the closest value
    public static void matheRechner(double[] tab){
        double average;
        double summe = 0;
        parallelSort(tab);
        
        for(double n : tab){     
            summe += n;
        }
        average = summe / tab.length;
        if(MIN_UPSILON <= average && average <= MAX_UPSILON)
            average = 0.0;
        
        // Need to find the closest value
        
        System.out.println("arithmetisches Mittel : " + average);
    }
    
    /**
     * Zaehlt wie viele Strings enthaelt diese Eigenschaften :
     * * Nur Großbuchstaben
     * * Nur Kleinbuchstaben
     * 
     * @param tab
     * @return {Großbuchstaben Ergebnis, Kleinbuchstaben Ergebnis}
     */
    public static int[] stringCount(String[] tab){
        int[] rv = {0, 0}; // {Großbuchstaben, Kleinbuchstaben}
        for(String str: tab){
            // Les lettres accentuées ?
            // Chaines de caractères avec 1 char ?
            if(str.matches("^[A-Z]+$"))
                rv[0]++;
            else if(str.matches("^[a-z]+$"))
                rv[1]++;
        }
        return rv;
    }
}
