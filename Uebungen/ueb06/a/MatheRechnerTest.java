import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

/**
 * Teste die Methode Tools.matheRechner
 *
 * @author  Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class MatheRechnerTest
{   
    @Test
    public void MatheRechner1(){
        double[] array = {0.0, 0.0, 0.0 ,1.0, -1.0};
        double[] expected = {0.0, 0.0, -1.0};
        final String text = "0.0, 0.0, -1.0:"   + 
                            "average == 0 and " +
                            "closest is the average";
        
        assertTrue(text, 
                   Arrays.equals(Tools.matheRechnerAlgo(array), expected));
    }
    
    @Test
    public void MatheRechner2(){
        double[] array = {5,6,7,8,9};
        double[] expected = {7.0, 7.0, 9.0};
        final String text = "7.0, 7.0, 9.0 : " +
                            "closest value is the average";
        
        assertTrue(text, 
                   Arrays.equals(Tools.matheRechnerAlgo(array), expected));
    }
    
    @Test
    public void MatheRechner3(){
        double[] array = {-1,-6,-10,-24,41};
        double[] expected = {0.0, -1, 41};
        final String text = "0.0, -1, 41: "     + 
                            "average == 0 and " +
                            "farthest value is the lonely positive value";
        
        assertTrue(text, 
                   Arrays.equals(Tools.matheRechnerAlgo(array), expected));
    }
    
    @Test
    public void MatheRechner4(){
        double[] array = {-10, -50, -40, -100, -200}; // sum = -400
        double[] expected = {-80, -50, -200};
        final String text = "-80, -50, -200: "  + 
                            "negative values ";
        
        assertTrue(text, 
                   Arrays.equals(Tools.matheRechnerAlgo(array), expected));
    }
}
