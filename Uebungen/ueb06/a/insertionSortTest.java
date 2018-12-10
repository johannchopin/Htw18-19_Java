import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

/**
 * Teste die Methode Tools.insertionSort
 *
 * @author  Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class insertionSortTest
{
    /**
     * Prueft automatisch, wenn die Tabelle gut sortiert ist.
     * 
     * @param text  Beschreibung der Testmethode
     * @param array Tabelle, die das Insertionsort-Algorithmus testet
     */
    private static void prueft(String text, int[] array){
        int[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);
        
        Tools.insertionSort(array);
        assertArrayEquals(text, array, expected);
    }
    
    @Test
    public void insertionSort1(){
        String text = "einfache Zahlen";
        int[] array = {100, 0, 42, 64};
        prueft(text, array);
    }
    
    @Test
    public void insertionSort2(){
        String text = "negative Zahlen";
        int[] array = {-100, -42, -84, 0, -64, -1024};
        prueft(text, array);
    }
    
    @Test
    public void insertionSort3(){
        String text = "Andere Zahlen";
        int[] array = {66666, 666, 66, 6, 0, -6, -66, -666, -6666};
        prueft(text, array);
    }   
}
