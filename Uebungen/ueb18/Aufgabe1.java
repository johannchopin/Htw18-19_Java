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
    
    public double iterate(double x0, int n, FunctionInterface fn) {
        double result = x0;
        
        for(int i = 0; i < n; i++){
            result = fn.apply(x0);
            x0 = result;}

        return result;
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
        System.out.println("\niLambda (2x) with x0=2.0 and n=2 :");
        System.out.println(this.iterate(2.0, 2, this.iLambda()));
        
        System.out.println("\niiLambda (0.5x) with x0=2.0 and n=2 :");
        System.out.println(this.iterate(2.0, 2, this.iiLambda()));
        
        System.out.println("\niiiLambda (ax(x − 1)) || a = " + rndDouble + " with x0=2.0 and n=2 :");
        System.out.println(this.iterate(2.0, 2, this.iiiLambda()));
    }
    
    public static void main(String[] args) {
       Aufgabe1 test = new Aufgabe1();
       test.run();
    }
}
