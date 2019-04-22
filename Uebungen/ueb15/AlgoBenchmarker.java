public abstract class AlgoBenchmarker implements Algorithmus {
    /**
    * Timeit the iterativ algorithm
    * @return time (in ns) taken for executing the function 
    */
    public long timeIterativ(){
        long before = System.nanoTime();
        this.iterativ();
        return System.nanoTime() - before;
    }

    /**
    * Timeit the rekursiv algorithm
    * @return time (in ns) taken for executing the function 
    */
    public long timeRekursiv(){
        long before = System.nanoTime();
        this.rekursiv();
        return System.nanoTime() - before;
    }

    /**
    * Calculate the mean time of the n-execution of the iterative method
    * @param n number of execution
    * @return mean time (in ns) taken for executing the function n times
    */
    public long ntimesIterativ(int n){
        long[] results = new long[n];
        while(--n >= 0){
            results[n] = timeIterativ();
        }
        return Helpers.mean(results);
    }

    /**
    * Calculate the mean time of the n-execution of the recursive method
    * @param n number of execution
    * @return mean time (in ns) taken for executing the function n times
    */
    public long ntimesRekursiv(int n){
        long[] results = new long[n];
        while(--n >= 0){
            results[n] = timeRekursiv();
        }
        return Helpers.mean(results);
    
}}
