import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
* Implement the recursive and iterative algorithm with the main method.
*
* @author Alexandre Guidoux
* @version 1.0
*/
public class isPalindromIterativ extends isPalindromAbstract {
    protected final static String BENCH_FILENAME = "benchmarkIterativ.txt";

    public isPalindromIterativ(String sequence){run(sequence);}

    /**
    * Iterative algorithm
    */
    public static boolean run(String sequence) {
        int i = 0;
        int j = sequence.length()-1;
        
        while(i < j){
            if(sequence.charAt(i) != sequence.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        String input = mainToString(args);
        if(!input.isEmpty()){
            run(input);
        }
    }
}