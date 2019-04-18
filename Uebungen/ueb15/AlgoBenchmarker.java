public abstract class AlgoBenchmarker extends Algorithmus {

    //TODO: ? Using composition for benchmarking ?
    //TODO: ? Instanciation better than inheritance ?
    private Algorithmus Algo;

    public long timeIterativ(){
        long before = System.nanoTime();
        this.iterativ();
        return System.nanoTime() - before;
    }

    public long timeRekursiv(){
        long before = System.nanoTime();
        this.rekursiv();
        return System.nanoTime() - before;
    }

    public long[] ntimes(int n){
        long[] results = new long[n];
        while(n-- > 0){
            results[n] = timeIterativ();
        }
        return results;
    }
}