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
    
    /*
     * Tests TeilerSumme
     */
    @Test
    public final void testTeilerSumme_with6_result12(){
        assertTrue(ft.teilerSumme(6) == 12);
    }
    
    
    /*
     * Tests IsbnRechner
     */
    @Test
    public final void isbnRechnerTest_with123456789_resultX(){
        assertEquals(ft.isbnRechner(123456789), "X"); 
    }
    
    @Test
    public final void isbnRechnerTest_with386680192_result0(){
        assertEquals(ft.isbnRechner(386680192), "0");
    }
    
    @Test
    public final void isbnRechnerTest_with383622862_result9(){
        assertEquals(ft.isbnRechner(383622862), "9");
    }
    
    
    /*
     * Tests quadratische Gleichung
     */
    @Test
    public final void quadratischeGleichungTest_with1_2_result_komplexeNullstellen(){
        assertEquals(ft.quadratischeGleichung(1, 2), "2 komplexe Nullstellen");
    }
    
    @Test
    public final void quadratischeGleichungTest_with20_36_result_2_18_negative() {
        assertEquals(ft.quadratischeGleichung(20, 36), "2 reelle Nulstellen : -2.0 -18.0");
    }  
  
    
    /*
     * Tests mathematischeFolgeRechner
     */
    @Test
    public final void mathematischeFolgeTest_with3_2_result_0dot6666666() {
        assertEquals("mathematischeFolge(3, 2.0) ~= 0.6666666", ft.mathematischeFolge(3, 2.0), 0.6666666, 0.0000001);
    }
}
