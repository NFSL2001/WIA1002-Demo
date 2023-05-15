package w7;

import java.util.LinkedList;

public class MyQueue<E>{
    private LinkedList<E> list = new LinkedList<>();

    public MyQueue(E[] e){
        for(E item: e){
            list.add(item);
        }
    }

    public MyQueue(){}

    public void enqueue(E e){
        list.add(e);
    }

    /**
     * Removes and return the first element
     * @return the first element, null if nothing in list
     */
    public E dequeue(){
        if(list.size() == 0)
            return null;
        return list.pop();
    }

    /**
     * Get element at position i
     * @param i position in list
     * @return element at position i, null if i is out of bound or nothing in list
     */
    public E getElement(int i){
        if(i >= list.size() || i < 0)
            return null;
        return list.get(i);
    }

    /**
     * Return the first element
     * @return the first element, null if nothing in list
     */
    public E peek(){
        if(list.size() == 0)
            return null;
        return list.get(0);
    }

    public int getSize(){
        return list.size();
    }

    public boolean contains(E e){
        return list.contains(e);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return list.toString();
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>(new String[] {"Durian", "Blueberry"});
        queue.enqueue("Apple");
        queue.enqueue("Orange");
        queue.enqueue("Grapes");
        queue.enqueue("Cherry");
        System.out.println(queue);
        System.out.printf("Top item: %s\n", queue.peek());
        System.out.printf("Queue size: %d\n", queue.getSize());
        queue.dequeue();
        System.out.printf("Item at index position 2: %s\n", queue.getElement(2));
        System.out.printf("Queue has Cherry? %b\n", queue.contains("Cherry"));
        System.out.printf("Queue has Durian? %b\n", queue.contains("Durian"));
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}