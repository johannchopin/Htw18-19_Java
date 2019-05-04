import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class Testklasse.
	 *
 * @author  Alexandre && Johann
 * @version 1.0
 */
public class Testklasse
{
    private FuncTools ft;

    @Test
    public final void teilerSummeTest(){
        assertTrue("teilerSumme(6) == 12", ft.teilerSumme(6) == 12);
    }
     
}