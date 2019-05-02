import java.util.Arrays;

/**
 * Implement the sum Operation : 
 * Summiert die Elemente des Arrays paarweise von links nach rechts auf 
 * und speichertden neuen Wert in dem jeweils rechten Datenfeld.
 * 
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Sum implements Operation
{    
    @Override
    public float[] doIt(float[] array){
        int i = 1;
        while(i < array.length)
              array[i] += array[i++-1];
        return array;
    }
}
