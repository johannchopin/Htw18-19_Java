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
    
    public static double amNaechstenVon(double goal, double n1, double n2){
        goal = Math.abs(goal);
        double candidate1 = Math.abs(n1) - goal;
        double candidate2 = Math.abs(n2) - goal;
        return (candidate1 <= candidate2) ? n1: n2;
    }

    public static double amWeitestenVon(double goal, double n1, double n2){
        goal = Math.abs(goal);
        double candidate1 = Math.abs(n1) - goal;
        double candidate2 = Math.abs(n2) - goal;
        return (candidate1 >= candidate2) ? n1: n2;
    }
    
    public static double sumTabelle(double[] tab){
        double sum = 0;
        for(double n : tab){     
            sum += n;
        }
        return sum;
    }

    public static double durschnitt(double[] tab){
        double average = sumTabelle(tab) / tab.length;
        if(MIN_UPSILON <= average && average <= MAX_UPSILON)
            average = 0.0;
        return average;
    }
}
