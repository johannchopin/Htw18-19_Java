public abstract class AlgoBenchmarker extends Algorithmus {

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