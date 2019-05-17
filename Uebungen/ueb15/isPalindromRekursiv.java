import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
* Implement the recursive and iterative algorithm with the main method.
*
* @author Alexandre Guidoux
* @version 1.0
*/
public class isPalindromRekursiv extends isPalindromAbstract {
    protected final static String BENCH_FILENAME = "benchmarkRekursiv.txt";

    public isPalindromRekursiv(String sequence){
        super(sequence);
    }
    
    /**
    * Start the recursive call
    */
    public boolean run() {
        return rekursiv(0, sequence.length() - 1);
    }

    /**
    * Main algorithm of the recursive method
    */
    private boolean rekursiv(int i, int j){
        if(i > j)
            return true;
        if(sequence.charAt(i) != sequence.charAt(j))
            return false;
        return rekursiv(++i, --j);
    }
}