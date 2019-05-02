
/**
 * Implement the average Operation:
 * Bestimmt den Durchschnitt aller Werte im Array und 
 * speichert den Durchschnittswert im Datenfeld mit dem größten Wert.
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Average implements Operation
{
    public float[] doIt(float[] array){
         double acc = 0;
                ArrayElement biggestSoFar = 
                    new ArrayElement(-1, Float.MIN_VALUE);
                
                for(int i=0; i<array.length; i++){
                    acc += array[i];
                    if(array[i] >= biggestSoFar.value)
                        biggestSoFar = new ArrayElement(i, array[i]);                  
                }
                
         array[biggestSoFar.index] = (float)acc / array.length;
         return array;
    }
}
