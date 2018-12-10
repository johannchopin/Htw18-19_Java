import java.lang.Math;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Implementiert ein paar Methoden 
 *
 * @author Alexandre Guidoux & Johann Chopin
 * @version 1.0
 */
public class Tools
{
    // Used to match a string full of letters only
    private final static Pattern LETTERS_PATTERN = Pattern.compile("\\A\\p{L}+\\Z");
    
    /**
     * Rechnet die arithmetische Mittel einer Tabelle
     * Wenn die Extrem-oder nahwerte im gleichen Abstand liegen, 
     * wird der kleinste Wert gewählt.
     * 
     * @return {average, closestToAverage, farthestToAverage}
     */
    static double[] matheRechnerAlgo(double[] tab){
        double average, closestToAverage, farthestToAverage;
        Arrays.parallelSort(tab);
        
        average = Helpers.durchschnitt(tab);
        farthestToAverage = Helpers.amWeitestenVon(average, tab[0], tab[tab.length-1]);
        
        // The closest value
        // improvement : binarySearch for the closest value
        double candidate1 = tab[0];
        double candidate2 = tab[tab.length-1];
        for(double v: tab){
            if(v <= average)
                candidate1 = v;
            else{
                candidate2 = v;
                break;
            }
        }
        closestToAverage = Helpers.amNaechstenVon(average, candidate1, candidate2);
        
        return new double[] {average, closestToAverage, farthestToAverage};               
    }
    
    /**
     * Oeffentliche methode von matheRechnerAlgo, die das Ergebnis darstellt
     * 
     */
    public static void matheRechner(double[] tab){
       double[] rv = matheRechnerAlgo(tab);
       System.out.println("average: "   + rv[0] +
                          " closest: "  + rv[1] +
                          " farthest: " + rv[2]); 
    }
    
    /**
     * Zaehlt wie viele Strings enthaelt diese Eigenschaften :
     * * Nur Großbuchstaben
     * * Nur Kleinbuchstaben
     * 
     * @param tab
     */
    public static int stringCount(String[] tab){
        int rv = 0;
        for(String str: tab){
            if(LETTERS_PATTERN.matcher(str).matches())
                rv++;
        }
        return rv;
    }
    
    /**
     * Sortiert eine Tabelle "in place" mit dem Insertionsort-Algorithmus an.
     */
    public static void insertionSort(int[] tab){
        int i, j, cur; 
        for(i=1; i < tab.length; i++){
            j = i;
            cur = tab[i];
            while(j > 0 && tab[j-1] > cur){
                tab[j] = tab[j - 1];
                j--;
            }
            tab[j] = cur;
        }
    }
}
