// Could be in other classe(s)
// TODO: ? Write JUnit
// TODO: ? Write a command with flags ?

import java.lang.StringBuilder;
import java.io.IOException;

public abstract class isPalindromAbstract extends AlgoBenchmarker {
    protected final static String BENCH_FILENAME = "benchmarks.txt";
    private final static int BENCH_ACC = 2;
    protected final static int BENCH_REPETITION = 10000;
    protected final static int BENCH_BOUND = 16;
    protected String sequence;

    public isPalindromAbstract(String sequence) {
        setSequence(sequence);
    }
    
    public String getSequence() {
        return this.sequence;
    }

    public void setSequence(String sequence) {
        Helpers.check(sequence != null, "The sequence can't be empty !");
        Helpers.check(sequence.length() > 0, "The sequence can't be empty !");
        this.sequence = sequence;
    }

    /**
    * Arbitrary benchmark
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
