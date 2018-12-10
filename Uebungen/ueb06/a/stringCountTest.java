import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Teste die Methode Tools.StringCount.
 *
 * @author  Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class stringCountTest
{
    private static final int NULL = 0;
    
    // BAD VALUES
    @Test
    public void bad_value1(){
       String[] tab = {"b0njour", "B0NJOUR", "hell0", "HELL0",
                       "t4g", "T4G", "42", "l33t", "L33T"};
       assertEquals("Strings mit Nummer",
                    Tools.stringCount(tab),
                    NULL);
    }
    
    @Test
    public void bad_value3(){
       String[] tab = {"guten tag", "hello world", "l apero du captain", 
                       " ", " gluecksbaerchen", "gluecksbaerchen "};
       assertEquals("Strings mit Leerzeichnen",
                         Tools.stringCount(tab),
                         NULL);
    }
    
    @Test
    public void bad_value4(){
       String[] tab = {"%s/java/python/g", "ein+ein", "--'", "<script>",
                       ":D", "python>java", "€uro", ":(){ :|: & };:"};
       assertEquals("Strings mit Sonderzeichen",
                    Tools.stringCount(tab),
                    NULL);  
    }
    
    // GOOD VALUES
    @Test
    public void good_value1(){
       String[] tab = {"JAVA", "PYTHON", "BASH", "C", "LUA", "HASKELL"};
       assertEquals("Strings mit Großbuchstaben",
                    Tools.stringCount(tab),
                    tab.length);
    }
    
    @Test
    public void good_value2(){
       String[] tab = {"elixir", "clojure", "rust", "go", "d"};
       assertEquals("Strings mit Kleinbuchstaben",
                    Tools.stringCount(tab),
                    tab.length);  
    }
        
    @Test
    public void good_value3(){
       String[] tab = {"JoJo", "bonjouR", "assertArrayEquals", "Ok"};
       assertEquals("Strings mit Groß-und Kleinbuchstaben",
                    Tools.stringCount(tab),
                    tab.length);
    }
    
    @Test
    public void good_value4(){
       String[] tab = {"straßenbahn", "étoile", "à", "pétale", "königin"};
       assertEquals("Strings mit Sonderbuchstaben",
                    Tools.stringCount(tab),
                    tab.length);
    }
}
