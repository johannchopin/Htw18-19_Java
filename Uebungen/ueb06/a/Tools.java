import java.lang.Math;
import java.util.Arrays;

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
    
    private static double amNaechstenVon(double goal, double n1, double n2){
        goal = Math.abs(goal);
        double candidate1 = Math.abs(goal - n1);
        double candidate2 = Math.abs(goal - n2);
        return (candidate1 <= candidate2) ? n1: n2;
    }
    
    
    /**
     * Rechnet die arithmetische Mittel einer Tabelle
     * 
     * @param tab
     */
    // TODO : Use BinarySearch to find the closest value
    public static void matheRechner(double[] tab){
        double average, closestToAverage, farthestToAverage;
        double summe = 0;
        double candidate1, candidate2;
        Arrays.parallelSort(tab);
        
        // The average
        for(double n : tab){     
            summe += n;
        }
        average = summe / tab.length;
        if(MIN_UPSILON <= average && average <= MAX_UPSILON)
            average = 0.0;
        
        // The farthest value
        farthestToAverage = amNaechstenVon(average, tab[0], tab[tab.length-1]);
        
        // The closest value
        candidate1 = tab[0]; // stupid value
        candidate2 = tab[tab.length-1]; // stupid value
        for(double v: tab){
            if(v <= average)
                candidate1 = v;
            else
                candidate2 = v;
                break;
        }
        closestToAverage = amNaechstenVon(average, candidate1, candidate2);
        
        System.out.printf("average: %f ; closest : %f ; farthest: %f\n", 
                          average, closestToAverage, farthestToAverage);
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
    
    public static void main(String[] args){
        double[] tab1 = {5,6,7,8,9};
        matheRechner(tab1);
    }
}
