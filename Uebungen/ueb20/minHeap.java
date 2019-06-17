import java.util.Queue;
import java.lang.UnsupportedOperationException;
import java.util.Collection;
import java.util.Iterator;

/**  
 * A simple minHeap
 *
 * @author Alexandre Guidoux && Johann Chopin
 * @version 1.0
 */
public class minHeap<T extends Comparable> implements Queue<T>
{       
    private static final int ROOT_INDEX = 0; // Index of the head of the heap
    private final int maxsize; // Upper bound number of items in the heap
    
    private GenericArray<T> tree; // Array storage for the heap
    private int size;          // Current number of items in the heap

    /**
     * Wrapper to create a generic array than can accept implementations
     * instances of the comparable interface
     * 
     * new T[size]  --> new GenericArray(size)
     * array[i]     --> obj.get(i)
     * array[i] = n --> obj.set(i, n)
     */
    private class GenericArray<T>{
        private Object[] array;
        
        public GenericArray(int size){
            this.array = new Object[size];
        }
       
        /**
         * Exchange the value between to two indexes i and j
         */
        private void swap(int i, int j){
            Object aux = array[i];
            array[i] = array[j];
            array[j] = aux;
        }
        
        /**
         * Trick : type-cast the object to simulate an array<T>
         */
        private T get(int i){
            return (T)array[i];
        }
        
        /**
         * Trick : only accept object of type T
         */
        private void set(int i, T element){
            this.array[i] = element;
        }
    }
    
    /**
     * Constructor
     * @param size the max number of elements that the heap can contains
     */
    public minHeap(int size){
        this.tree = new GenericArray(size);
        this.maxsize = size;
        this.size = 0;
    }
    
    /**
     * Get the index of the upper value in the heap
     */
    private int parentIndex(int i){
        if(i==0)
            return 0;
        return (i-1)/2;
    }
    
    /**
     * At the position i in the heap, get the index of the left value
     */
    private int leftIndex(int i){
        return 2*i + 1;
    }
    
    /**
     * At the position i in the heap, get the index of the right value
     */
    private int rightIndex(int i){
        return 2*i + 2;
    }
    
    /**
     * A method to improve clarity
     */
    private boolean isElementLowerAtThan(int i, int j){
        return tree.get(i).compareTo(tree.get(j)) < 0; 
    }
    
    /**
     * Place the new item at the good place in the heap
     */
    private void heapifyUp(int i){
        int iParent = parentIndex(i);
        if(i > 0 && isElementLowerAtThan(i, iParent)){
            tree.swap(i, iParent);
            heapifyUp(iParent);
        }
    }
    
    /**
     * Place the old item at the good place in the heap
     */
    private void heapifyDown(int i){
        int left = leftIndex(i);
        int right = rightIndex(i);
        int biggestIndexSoFar = i;

        if(left < size() && isElementLowerAtThan(left, i))
        
            biggestIndexSoFar = left;
        if(right < size() && isElementLowerAtThan(right, biggestIndexSoFar))
            biggestIndexSoFar = right;
            
        if(biggestIndexSoFar != i){
            tree.swap(i, biggestIndexSoFar);
            heapifyDown(biggestIndexSoFar);
        }
    }
    
    public boolean offer(T element){
        if(element == null)
            throw new NullPointerException(element + " is null");
        if(size == maxsize)
            return false;
            //try{
            //    throw new minHeapException("The heap is full");
            //} catch (minHeapException e){return false}
        if(isEmpty())
            tree.set(0, element);
        else{
            int i = size();
            tree.set(i, element);
            heapifyUp(i);
        }
        this.size++;
        return true;
    }
    
    public T peek(){
        if(isEmpty())
            return null;
        return tree.get(0);
    }
    
    public T poll(){
        if(isEmpty())
            return null;
            
        int tailIndex = size() - 1;
        T root = tree.get(ROOT_INDEX);
        tree.set(ROOT_INDEX, tree.get(tailIndex));
        tree.set(tailIndex, null);
        
        this.size--;
        
        heapifyDown(ROOT_INDEX);
        return root;
    }
    
    public int size(){
        return this.size;
    }
    
    public int getMaxSize(){
        return this.maxsize;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }

    public void clear(){
        for(int i = 0; i < size; i++)
            tree.set(i, null);
        this.size = 0;
    }
    
    public String toString(){
        String acc = "minHeap: ";
        for(Object el: tree.array)
            acc += el + ", ";
        return acc;
    }
    
    public T element()
    {throw new UnsupportedOperationException("element() not implemented.");}
    
    public T remove()
    {throw new UnsupportedOperationException("remove() not implemented.");}

    public boolean add(T item)
    {throw new UnsupportedOperationException("add() not implemented.");}
    
    // --------------------------
    // Not Implemented methods
    // --------------------------
    public boolean addAll(int index, Collection<? extends T> c )
    {throw new java.lang.UnsupportedOperationException("addAll not implemented");}

    public boolean containsAll(Collection<?> c)
    {throw new java.lang.UnsupportedOperationException("containsAll not implemented");}

    public boolean equals(Object o)
    {throw new java.lang.UnsupportedOperationException("equals not implemented");}

    public int hashCode()
    {throw new java.lang.UnsupportedOperationException("hashCode not implemented");}

    public int lastIndexOf(Object o)
    {throw new java.lang.UnsupportedOperationException("lastIndexOf not implemented");}

    public boolean removeAll(Collection<?> c)
    {throw new java.lang.UnsupportedOperationException("removeAll not implemented");}

    public boolean retainAll(Collection<?> c)
    {throw new java.lang.UnsupportedOperationException("retainAll not implemented");}

    public boolean addAll(Collection<? extends T> c)
    {throw new java.lang.UnsupportedOperationException("addAll not implemented");}

    public Object[] toArray()
    {throw new java.lang.UnsupportedOperationException("toArray not implemented");}
    
    public boolean remove(Object o)
    {throw new java.lang.UnsupportedOperationException("remove not implemented");}

    public <T> T[] toArray(T[] arr)
    {throw new java.lang.UnsupportedOperationException("toArray not implemented");}
    
    public Iterator iterator()
    {throw new java.lang.UnsupportedOperationException("iterator not implemented");}
    
    public boolean contains(Object o)
    {throw new java.lang.UnsupportedOperationException("contains not implemented");}
}
