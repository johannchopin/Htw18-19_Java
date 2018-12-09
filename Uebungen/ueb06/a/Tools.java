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
    /**
     * Rechnet die arithmetische Mittel einer Tabelle
     * Wenn die Extremwerte im gleichen Abstand liegen, 
     * wird der kleinste Wert gewählt.
     */
    // TODO : Use BinarySearch to find the closest value
    static double[] matheRechnerAlgo(double[] tab){
        double average, closestToAverage, farthestToAverage;
        Arrays.parallelSort(tab);
        
        average = Helpers.durschnitt(tab);
        farthestToAverage = Helpers.amWeitestenVon(average, tab[0], tab[tab.length-1]);
        
        // The closest value
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
     * @return {Großbuchstaben Ergebnis, Kleinbuchstaben Ergebnis}
     */
    public static int[] stringCount(String[] tab){
        int[] rv = {0, 0}; // {Großbuchstaben, Kleinbuchstaben}
        for(String str: tab){
            if(str.matches("^[A-Z]+$"))
                rv[0]++;
            else if(str.matches("^[a-z]+$"))
                rv[1]++;
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
