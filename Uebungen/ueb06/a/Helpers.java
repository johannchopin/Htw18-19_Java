/**
 * Some helper functions specific to Tools
 *
 * @author Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class Helpers
{
    final private static double MIN_UPSILON = 1e-12;
    final private static double MAX_UPSILON = 1e-12;
    
    /**
     * Gibt der double-wert zueruck, der am nachsten vom Ziel ist.
     * 
     * @param goal das Ziel
     * @param n1   der erste Kandidat
     * @param n2   der zweite Kandidat
     */
    public static double amNaechstenVon(double goal, double n1, double n2){
        goal = Math.abs(goal);
        double candidate1 = Math.abs(n1) - goal;
        double candidate2 = Math.abs(n2) - goal;
        return (candidate1 <= candidate2) ? n1: n2;
    }

    /**
     * Gibt der double-wert zueruck, der am weitesten vom Ziel ist.
     * 
     * @param goal das Ziel
     * @param n1   der erste Kandidat
     * @param n2   der zweite Kandidat
     */
    public static double amWeitestenVon(double goal, double n1, double n2){
        goal = Math.abs(goal);
        double candidate1 = Math.abs(n1) - goal;
        double candidate2 = Math.abs(n2) - goal;
        return (candidate1 >= candidate2) ? n1: n2;
    }
    
    /**
     * Einfach summiert die Methode die double-werten in der Tabelle.
     * 
     * @param tab die Tabelle
     * @return sum die Summe
     */
    public static double tabSumme(double[] tab){
        double sum = 0;
        for(double n : tab){     
            sum += n;
        }
        return sum;
    }

    /**
     * Rechnet die Durschnitt eine Tabelle
     * Benutzt die sumTabelle methode
     * 
     * @param tab die Tabelle
     * @return average der Durchschnitt
     */
    public static double durchschnitt(double[] tab){
        double average = tabSumme(tab) / tab.length;
        if(MIN_UPSILON <= average && average <= MAX_UPSILON)
            average = 0.0;
        return average;
    }
}
