import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class isPalindrom extends isPalindromAbstract {
    public isPalindrom(String sequence){
        super(sequence);
    }

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
    
    public boolean rekursiv() {
        return rekursiv(0, sequence.length() - 1);
    }

    private boolean rekursiv(int i, int j){
        if(i > j)
            return true;
        if(sequence.charAt(i) != sequence.charAt(j))
            return false;
        return rekursiv(++i, --j);
    }

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