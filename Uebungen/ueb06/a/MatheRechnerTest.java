import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

/**
 * Teste die Methode Tools.matheRechner
 *
 * @author  Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class MatheRechnerTest
{
    private final static String REGEX_EXTRACT_RESULT = "[^\\d\\.]+";
    
    private static double[] extractResult(ByteArrayOutputStream byteArray){
        double[] rv = new double[3];
        String[] str = byteArray.toString().split(REGEX_EXTRACT_RESULT);
        for(int i = 0; i < rv.length; i++){
            rv[i] = Double.valueOf(str[i]);
        }
        return rv;
    }
    
    /**
     * Catch the system.out.println() into a ByteArrayOutputStream.
     */
    @Before
    public void setUp(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream outErr     = new ByteArrayOutputStream();
        
        PrintStream catchOut = new PrintStream(outContent);
        PrintStream catchErr = new PrintStream(outErr);
        
        System.setOut(catchOut);
        System.setErr(catchErr);
    }
}
