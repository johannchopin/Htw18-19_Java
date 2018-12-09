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
    private static final int[] NULL = {0, 0};
    
    // BAD VALUES
    @Test
    public void bad_value1(){
       String[] tab = {"b0njour", "B0NJOUR", "hell0", "HELL0",
                       "t4g", "T4G", "42", "l33t", "L33T"};
       assertArrayEquals("Strings mit Nummer",
                         Tools.stringCount(tab),
                         NULL);
    }
    
    @Test
    public void bad_value2(){
       String[] tab = {"JoJo", "bonjouR", "assertArrayEquals", "Ok"};
       assertArrayEquals("Strings mit Groß-und Kleinbuchstaben",
                         Tools.stringCount(tab),
                         NULL);
    }
    
    @Test
    public void bad_value3(){
       String[] tab = {"guten tag", "hello world", "l apero du captain", 
                       " ", " gluecksbaerchen", "gluecksbaerchen "};
       assertArrayEquals("Strings mit Leerzeichnen",
                         Tools.stringCount(tab),
                         NULL);
    }
    
    @Test
    public void bad_value4(){
       String[] tab = {"%s/java/python/g", "ein+ein", "--'", "<script>",
                       ":D", "python>java", "€uro", ":(){ :|: & };:"};
       assertArrayEquals("Strings mit Sonderzeichen",
                         Tools.stringCount(tab),
                         NULL);  
    }
    
    // GOOD VALUES
    @Test
    public void good_value1(){
       String[] tab = {"JAVA", "PYTHON", "BASH", "C", "LUA", "HASKELL"};
       int[] result = {tab.length, 0};
       assertArrayEquals("Strings mit Großbuchstaben",
                         Tools.stringCount(tab),
                         result);  
    }
    
    @Test
    public void good_value2(){
       String[] tab = {"elixir", "clojure", "rust", "go"};
       int[] result = {0, tab.length};
       assertArrayEquals("Strings mit Kleinbuchstaben",
                         Tools.stringCount(tab),
                         result);  
    }
}
