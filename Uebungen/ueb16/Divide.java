import java.util.Arrays;

/**
 * Implement the divide Operation :
 * Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten 
 * und speichert den neuenWert im Datenfeld des jeweils größeren Wertes. 
 * D.h. der größte Wert wird durch den Kleinsten geteilt. 
 * Der Zweitgrößte durch den Zweitkleinsten usw.
 * 
 * @author Alexandre Guidoux
 * @version 1.0
*/
public class Divide implements Operation {
    // Used to check if floats number are to close to 0
    public static final double lowBound = +0.1e-10;
    public static final double highBound = -0.1e-10;
    
    public float[] doIt(float[] array){
        // Copy and sort the ArrayElement from the array
        ArrayElement[] arrayCp = new ArrayElement[array.length];
        for(int i=0; i < array.length; i++)
            arrayCp[i] = new ArrayElement(i, array[i]);
        Arrays.sort(arrayCp);
        
        // Divide the lowest values by the highest
        for(int j=0; j < array.length/2; j++){
            if(lowBound <= arrayCp[j].value && arrayCp[j].value <= highBound)
                throw new ArithmeticException("A float number is equal to 0. Division impossible.");
            else
                arrayCp[array.length - 1 - j].value /= arrayCp[j].value;
        }
        
        // Rearrange the elements in good order (like the beginning)
        for(ArrayElement el: arrayCp)
            array[el.index] = el.value;
        
        return array;
    }
}