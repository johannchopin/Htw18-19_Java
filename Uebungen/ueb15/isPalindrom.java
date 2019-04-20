// Could be in other classe(s)
// TODO: Save results of the different speed in files
// TODO: Erzeugung des Diagramms (Ascii or Gnuplot)
// TODO: ? Write JUnit
// TODO: ? Write a command with flags ?
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class isPalindrom extends AlgoBenchmarker {
    private String sequence;

    public isPalindrom(String sequence, boolean caseSensitive) {
        Helpers.check(sequence != null, "The sequence can't be empty !");
        Helpers.check(sequence.length() > 0, "The sequence can't be empty !");
        if(!caseSensitive) // if not sensitive to the case
            sequence = sequence.toLowerCase();
        this.sequence = sequence;
    }

    public isPalindrom(String sequence){
        this(sequence, true);
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
        if(sequence.charAt(i) != sequence.charAt(j))
            return false;
        if(i > j)
            return true;
        return rekursiv(++i, --j);
    }
    
    public String getSequence() {
        return this.sequence;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String input;
        if(args.length <= 0 || (input = args[0]).length() <= 0){
            throw new IllegalArgumentException("A file or a string must be provided.");
        }
        if(new File(input).canRead()){
            String content = Helpers.readFile(input);
            System.out.println(new isPalindrom(content).iterativ());
        }
        else
            System.out.println(new isPalindrom(input).iterativ());
    }
}
