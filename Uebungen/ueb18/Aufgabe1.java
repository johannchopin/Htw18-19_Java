import java.util.Random;

/**
 * Implement the Aufgabe 1
 *
 * @author Guidoux Alexandre & Chopin Johann
 * @version 1.0.0
 */
public class Aufgabe1
{
    protected static double rndDouble = new Random().nextDouble();
    
    public void iterate(double x0, int n, FunctionInterface fn) {
        double end = x0 + n;
        
        for(double i = x0; i<=end; i++) {
            double result = fn.apply(i);
            
            System.out.println(i + " -> " + result);
        }
    }
    
    public FunctionInterface iLambda() {
        return (double n) -> 2 * n;
    }
    
    public FunctionInterface iiLambda() {
        return (double n) -> 0.5 * n;
    }
    
    public FunctionInterface iiiLambda() {
        double a = rndDouble;
        return (double n) -> a * n * (n - 1);
    }
    
    protected void run() {
        Aufgabe1 test = new Aufgabe1();
        
        System.out.println("\niLambda (2x) :");
        test.iterate(2.0, 10, test.iLambda());
        
        System.out.println("\niiLambda (0.5x) :");
        test.iterate(2.0, 10, test.iiLambda());
        
        System.out.println("\niiiLambda (ax(x − 1)) || a = " + rndDouble + " :");
        test.iterate(2.0, 10, test.iiiLambda());
    }
    
    public static void main(String[] args) {
       Aufgabe1 test = new Aufgabe1();
       test.run();
    }
}
