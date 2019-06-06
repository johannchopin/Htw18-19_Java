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
public class DoubleLinkedList<T> implements Iterable<T>
{
    private int size;
    private Node<T> head;
    private Node<T> tail;
    private Iterator<T> it;

    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value){
            this.value  = value;
        }
    }

    public class SimpleIterator<T> implements Iterator<T> {
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

    public class FullIterator<T> implements ListIterator<T> {
        Node<T> cursor;
        int     index;

        public FullIterator() {
            this.cursor = new Node(null); // Init node (before the head)
            this.cursor.next = (Node<T>)head;
            this.index = 0;
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

    private void checkIndex(int index){
        if(0 > index || index >= size)
            throw new ArrayIndexOutOfBoundsException(
                "Incorrect Index - got "+ index + 
                " but it must be between 0 and "+ (this.size-1)
            );
    }

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

    private void addHead(Node node){
        if(this.head != null){
            this.head.previous = node;
            node.next = this.head; 
        }
        this.head = node;
        if(this.tail == null)
            this.tail = node;
    }

    private void addTail(Node node){
        Node aux = this.tail;
        aux.next = node;
        node.previous = aux;
        this.tail = node;
    }

    private void insertNode(Node node, Node inserted){
        // Config new node reference
        inserted.previous = node.previous;
        inserted.next = node;
        // Config previous and next node to refer to the new node
        node.previous.next = inserted;
        node.previous = inserted;
    }

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
        Iterator it = iterator();
        while(it.hasNext()){
            if(o.equals(it.next()))
                return true;
        }
        return false;
    }

    public T[] toArray(T[] a){
        int listSize = size();
        Iterator<T> it = iterator();
        int count = 0;

        if(a.length < listSize)
            a = (T[]) new Object[listSize];

        while(it.hasNext()){
            a[count++] = it.next(); // Why type-casting is necessary ?
        }

        for( ; count < a.length; count++){
            a[count] = null;
        }

        return a;
    }

    public boolean add(T e){
        Node node = new Node(e);
        if(isEmpty())
            addHead(node);
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

    // TODO: Improve the algorithm (new List then concatenate the two lists)
    public boolean addAll(Collection<? extends T> c){
        for(T el: c)
            add(el);
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

    public <T> T set(int index, T value){
        Node node = getNode(index);
        T oldValue = (T)node.value;
        node.value = value;
        return oldValue;
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

    // TODO: transfer to test class, just used for debug
    public String printList(){
        it = this.iterator();
        String acc = "";
        while(it.hasNext())
            acc += it.next() + ", ";
        return acc + "\n";
    }

    // TODO: transfer to test class, just used for debug
    public int testSize(){
        int count= 0;
        for(Iterator it = iterator() ; it.hasNext(); it.next())
            count++;
        return count;
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

    public static void main(String[] main){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.print("Initial List: " + list.printList());

        System.out.println("contains(1): " + list.contains(1));
        System.out.println("contains(42): " + list.contains(42));

        Integer[] arr = list.toArray(new Integer[list.size()]);
        System.out.print("toArray(new Integer[list.size()]): ");
        for(int n: arr)
            System.out.print(n + ", ");
        System.out.println();

        list.remove(1);
        System.out.print("remove(1): " + list.printList());

        System.out.println("get(1): " + list.get(1));
        System.out.println("get(0): " + list.get(0));
        System.out.println("get(4): " + list.get(4));

        list.set(1, 42);
        System.out.print("set(1, 42): " + list.printList());
        System.out.println("contains(42): " + list.contains(42));

        list.add(0, 0);
        System.out.print("add(0,0): " + list.printList());
        list.add(3, 80);
        System.out.print("add(3, 80): " + list.printList());

        System.out.println("get(3): " + list.get(3));

        System.out.println("indexOf(42): " + list.indexOf(42));
        System.out.print("List: " + list.printList());
    }
}
