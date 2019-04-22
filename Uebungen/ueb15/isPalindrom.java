import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
* Implement the recursive and iterative algorithm with the main method.
*
* @author Alexandre Guidoux
* @version 1.0
*/
public class isPalindrom extends isPalindromAbstract {
    public isPalindrom(String sequence){
        super(sequence);
    }

    /**
    * Iterative algorithm
    */
    public boolean iterativ() {
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
    
    /**
    * Alias to start the recursive call
    */
    public boolean rekursiv() {
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

    /**
    * Use -t to start benchmarks (written in bechmarks.txt)
    * Or write the filename. It will test if the content is palindromic.
    * Or write a string in "" to check if this string is palindromic.
    */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String input;
        if(args.length <= 0 || (input = args[0]).length() <= 0){
            throw new IllegalArgumentException("A file or a string must be provided as argument.");
        }
        if(input.equals("-t")){
            new isPalindrom("a").PalindromBenchmark();
        }
        else if(new File(input).canRead()){
            String content = Helpers.readFile(input);
            System.out.println(new isPalindrom(content).iterativ());
        }
        else
            System.out.println(new isPalindrom(input).iterativ());
    }
}