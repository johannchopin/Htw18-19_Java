public class minHeapTest {
    public static void main(String[] args){
        minHeap<Integer> heap = new minHeap(10);
        for(int n = 9; n >= 0; n--){
            System.out.println("Adding: " + n);
            heap.offer(n);
        } 
        System.out.println(heap);
        System.out.println("Peek: " + heap.peek());
        System.out.println("Poll: " + heap.poll());
        System.out.println(heap);
        System.out.println("Poll: " + heap.poll());
        System.out.println(heap);
        System.out.println("Poll: " + heap.poll());
        System.out.println("Peek: " + heap.peek());
    }
} 
