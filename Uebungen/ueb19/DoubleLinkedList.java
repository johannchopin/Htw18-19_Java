import java.util.Iterator;
import java.lang.Iterable;
import java.util.List;
import java.util.ListIterator;
import java.util.Collection;

/**
 * Write a description of class DoubleLinkedList here.
 *
 * @author Alexandre Guidoux
 * @version 1.0
 */
public class DoubleLinkedList<T> implements Iterable<T>, List<T>
{
    private int size; // number of elements in the list
    private Node<T> head;
    private Node<T> tail;

    /**
     * A node contains 3 variables :
     * - previous is a reference to the left side node
     * - value    is the element of the node
     * - next     is a reference to the right side node
     */
    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous; 

        public Node(T value){
            this.value = value;
        }
    }

    /**
     * A simple iterator on the DoubleLinkedList (iterate from left to right)
     */
    public class SimpleIterator implements Iterator<T>{
        Node<T> node;

        public SimpleIterator(){
            this.node = (Node<T>)head; // WTF ? Why this type-cast
        }

        @Override
        public boolean hasNext(){
            return node != null;
        }

        @Override
        public T next(){
            T el = node.value;
            this.node = node.next;
            return el;
        }
    }

    /**
     * Implementation of the ListIterator with all available methods
     * {@inheritDoc ListIterator 
     */
    public class FullIterator implements ListIterator<T> {
        Node<T> cursor;
        int     index;

        public FullIterator(){
            this.cursor = new Node(null); // Init node (before the head)
            this.cursor.next = (Node<T>)head;
            this.index = index;
        }

        public FullIterator(int index) {
            this();
            // Position the cursor at the right index
            while(index-- != 0)
                this.cursor = this.cursor.next;
        }

        @Override
        public void add(T e){
            insertNode(cursor, new Node(e));
        }

        @Override
        public boolean hasNext(){
            return cursor.next != null;
        }

        @Override
        public boolean hasPrevious(){
            return cursor.previous != null;
        }

        @Override
        public T next(){
            cursor = cursor.next;
            index++;
            return cursor.value;
        }

        @Override
        public int nextIndex(){   
            return index;
        }

        @Override
        public T previous(){
            cursor = cursor.previous;
            index--;
            return cursor.value;
        }

        @Override
        public int previousIndex(){
            return index-1;    
        }

        @Override
        public void remove(){
            removeNode(cursor);
            DoubleLinkedList.this.size--;
        }

        @Override
        public void set(T e){
            DoubleLinkedList.this.set(this.index, e);
        }
    }

    
    /**
     * Check if the 0 <= index <= size 
     * (avoid error during manipulation of the list)
     */
    private void checkIndex(int index) throws ArrayIndexOutOfBoundsException{
        if(0 > index || index >= size)
            throw new ArrayIndexOutOfBoundsException(
                "Incorrect Index - got "+ index + 
                " but it must be between 0 and "+ (this.size-1)
            );
    }

    /**
     * Add a new node as head of the list
     * 
     * @param node will become the head of the list
     */
    private void addHead(Node node){
        this.head.previous = node;
        node.next = this.head; 
        this.head = node;
    }

    /**
     * Add the first node in the list
     */
    private void addFirstHead(Node node){
        this.head = node;
        this.tail = node;
    }
    
    /**
     * Add a node at the end of the list
     */
    private void addTail(Node node){
        Node aux = this.tail;
        aux.next = node;
        node.previous = aux;
        this.tail = node;
    }

    /**
     * Add a node before the node "marker"
     * 
     * @node node as marker in the list
     * @inserted node which wil be inserted
     */
    private void insertNode(Node node, Node inserted){
        // Config new node reference
        inserted.previous = node.previous;
        inserted.next = node;
        // Config previous and next node to refer to the new node
        node.previous.next = inserted;
        node.previous = inserted;
    }

    /**
     * Remove a node in the list
     */
    private void removeNode(Node node){
        if(node == this.head){
            this.head = this.head.next;
            this.head.previous = null;
        }
        else if(node == this.tail){
            this.tail = this.tail.previous;
            this.tail.next = null;
        } 
        else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
    }

    /**
     * Parse the list to get the node at the index position
     * 
     * @param index must be 0 <= index < size() else throw ArrayIndexOutOfBoundsException
     */
    private Node<T> getNode(int index){
        checkIndex(index);
        Node<T> node;
        if(index <= size / 2){
            node = this.head;
            for(int j=0; j<index; j++)
                node = node.next;
        }
        else{
            node = this.tail;
            for(int j=this.size-1; j > index; j--)
                node = node.previous;
        }
        return node;
    }

    public DoubleLinkedList(){
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean contains(Object o){
        return indexOf(o) >= 0;
    }

    public <T> T[] toArray(T[] a){
        int listSize = size();
        Iterator it = iterator();
        int count = 0;

        if(a.length < listSize)
            a = (T[]) new Object[listSize];

        while(it.hasNext()){
            a[count++] = (T)it.next(); // Why type-casting is necessary ?
        }

        for( ; count < a.length; count++)
            a[count] = null;

        return a;
    }

    public boolean add(T e){
        Node node = new Node(e);
        if(isEmpty())
            addFirstHead(node);
        else
            addTail(node);
        this.size++;
        return true;
    }

    public boolean remove(Object o){
        Node node = this.head;
        while(!o.equals(node.value)){
            if(node.next == null)
                return false;
            node = node.next;
        }
        removeNode(node);
        this.size--;
        return true;
    }

    public boolean addAll(Collection<? extends T> c){
        if(c == null || c.size() == 0)
            return false;
        // Old and easiest way
        // for(T el: c)
        //    add(el);
        Iterator it = c.iterator();
        Node firstNodeChain = new Node(it.next());
        Node chain = firstNodeChain;
        while(it.hasNext()){
            chain.next = new Node(it.next());
            chain.next.previous = chain;
            chain = chain.next;
        }
        
        this.addTail(firstNodeChain);
        return true;
    }

    public void clear(){
        // Thank you Garbage Collector
        this.head = this.tail = null;
        this.size = 0;
    }

    public T get(int index){
        return getNode(index).value;
    }

    public void add(int index, T value){
        checkIndex(index);
        Node newNode = new Node(value);

        if(index == 0)
            addHead(newNode);
        else if(index == this.size)
            addTail(newNode);
        else{
            insertNode(getNode(index), newNode);
        }

        this.size++;
    }

    public T set(int index, T value) throws ArrayIndexOutOfBoundsException{
        Node node = getNode(index);
        T oldValue = (T)node.value;
        node.value = value;
        return oldValue;
    }

    public T remove(int index) throws ArrayIndexOutOfBoundsException{
        checkIndex(index);
        Node<T> node = getNode(index);
        removeNode(node);
        return node.value;
    }

    public int indexOf(Object o){
        Iterator it = iterator();
        int i = 0;
        while(it.hasNext()){
            if(it.next().equals(o))
                return i;
            i++;
        }
        return -1;
    }

    public Iterator<T> iterator() {
        return new SimpleIterator();
    }
    
    public ListIterator<T> listIterator(int index){
        return new FullIterator(index);
    }

    public ListIterator<T> listIterator(){
        return new FullIterator();
    }

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

    public List<T> subList(int fromIndex, int toIndex)
    {throw new java.lang.UnsupportedOperationException("subList not implemented");}

    public Object[] toArray()
    {throw new java.lang.UnsupportedOperationException("toArray not implemented");}
}
