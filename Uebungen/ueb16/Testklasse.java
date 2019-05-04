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
    
    private Person p = new Person("Harry", "Bo");
    private ObjectQueue oQ = new ObjectQueue();

    @Test
    public final void personGetNameTest(){
        assertTrue("Harry name is Bo", p.getName() == "Harry");
    } 

    @Test
    public final void personGetVornameTest(){
        assertTrue("Harry name is Bo", p.getVorname() == "Bo");
    }
    
    @Test
    public final void objectQueueEmptyHasInitialisationTest(){
        assertTrue("ObjectQueue is empty", oQ.empty());
    }
    
    @Test(expected = RuntimeException.class)
    public final void removeFirstEmptyobjectQueueExceptionTest(){
        oQ.removeFirst();
    }
    
    @Test(expected = RuntimeException.class)
    public final void getEmptyobjectQueueExceptionTest(){
        oQ.get(42);
    }
}