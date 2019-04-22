import java.lang.StringBuilder;
import java.io.IOException;

/**
* Wrapper around the real class. 
* Implement useful and general methods for the class isPalindromic
*
* @author Alexandre Guidoux
* @version 1.0
*/
public abstract class isPalindromAbstract extends AlgoBenchmarker {
    // Constants for testing
    protected final static String BENCH_FILENAME = "benchmarks.txt"; // Results written in file
    protected final static int BENCH_BOUND = 16; // Number of iterations
    private final static int BENCH_ACC = 2; // indicate the growth of the string on each iteration
    protected final static int BENCH_REPETITION = 10000; // Number of test on each iteration (avoid extrems values)
    // Main container
    protected String sequence;

    public isPalindromAbstract(String sequence) {
        setSequence(sequence);
    }
    
    public String getSequence() {
        return this.sequence;
    }

    /**
    * The string can't be empty (or null)
    * @throws IllegalArgumentException
    */
    public void setSequence(String sequence) {
        Helpers.check(sequence != null, "The sequence can't be empty !");
        Helpers.check(sequence.length() > 0, "The sequence can't be empty !");
        this.sequence = sequence;
    }

    /**
    * Arbitrary benchmark
    * Output is written in file BENCH_FILENAME
    * BENCH_BOUND 
    * BENCH_ACC 
    */
    public void PalindromBenchmark(){
        long timing;
        long[] inputSize = new long[BENCH_BOUND];
        long[] timingRecordIterativ = new long[BENCH_BOUND];
        long[] timingRecordRekursiv = new long[BENCH_BOUND];
        String stringTest = "a";

        for(int i=0; i<BENCH_BOUND; i++){
            this.setSequence(stringTest);
            inputSize[i] = (long)stringTest.length();
            timingRecordIterativ[i] = ntimesIterativ(BENCH_REPETITION);
            timingRecordRekursiv[i] = ntimesRekursiv(BENCH_REPETITION);
            stringTest = Helpers.repeat(stringTest, BENCH_ACC);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(Helpers.longArrToString(inputSize)).append("\n")
          .append(Helpers.longArrToString(timingRecordIterativ)).append("\n")
          .append(Helpers.longArrToString(timingRecordRekursiv)).append("\n");

        try{
        Helpers.writeInFile(BENCH_FILENAME, sb.toString());
        } catch (IOException e){
            System.out.println(e);
            System.out.println("Fail to write in file !");
        }
    }
}
