// Could be in other classe(s)
// TODO: Read from Textdatei
// TODO: Write benchmarks
// TODO: Save results of the different speed in files
// TODO: Erzeugung des Diagramms (Ascii or Gnuplot)
// TODO: ? Write JUnit

public class isPalindrom {
    private String sequence;
    private int length;

    public isPalindrom(String sequence, boolean caseSensitive) {
        if(!caseSensitive)
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
    /*
    public boolean rekursiv2(){

    }*/
    
    public String getSequence() {
        return this.sequence;
    }

    public static void main(String[] args){
        String s1 = "Miette";
        isPalindrom test = new isPalindrom(s1);
        System.out.print(test.getSequence() + " --> ");
        System.out.println("Iterativ: " + test.iterativ());
        System.out.println("Rekursiv: " + test.rekursiv());
    }
}
