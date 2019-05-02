import java.util.Random;

/**
 * Implement the swirl Operation :
 * Führt n zufällige Vertauschungen der Datenfelder durch;
 * n ist durch die Länge des float-Arrays gegeben.
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class Swirl implements Operation
{
    
    private Random randomizer;
    
    public float[] doIt(float[] array){
        float aux;
        int pos1, pos2;
        for(int i = 0; i < array.length; i++){
            pos1 = randomizer.nextInt(array.length);
            pos2 = randomizer.nextInt(array.length);
            aux = array[pos1];
            array[pos1] = array[pos2];
            array[pos2] = aux;
        }
        return array;
    }
}
