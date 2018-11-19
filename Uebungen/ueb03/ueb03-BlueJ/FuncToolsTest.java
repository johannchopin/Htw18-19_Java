import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class FuncToolsTest.
 *
 * @author  Alexandre && Johann
 * @version 1.0
 */
public class FuncToolsTest
{
    private FuncTools ft;

    @Test
    public final void teilerSummeTest(){
        assertTrue("teilerSumme(6) == 12", ft.teilerSumme(6) == 12);
    }
    
    @Test
    public final void isbnRechnerTest(){
        assertTrue("ft.isbnRechner(123456789) == \"X\"",
                   ft.isbnRechner(123456789) == "X"); 
        assertEquals("ft.isbnRechner(386680192) == \"0\"", 
                      ft.isbnRechner(386680192),
                      "0");
        assertEquals("ft.isbnRechner(383622862) == \"9\"",
                     ft.isbnRechner(383622862),
                     "9");
    }
    
    @Test
    public final void quadratischeGleichungTest(){
       assertEquals("quadratischeGleichung(1, 2) == \"2 komplexe Nullstellen\"",
                    ft.quadratischeGleichung(1, 2),
                    "2 komplexe Nullstellen");
       assertEquals("quadratischeGleichung(20, 36) == \"2 reelle Nulstellen : -2.0 -18.0\"",
                    ft.quadratischeGleichung(20, 36),
                    "2 reelle Nulstellen : -2.0 -18.0");
       
    }    
}
