package w7.student_ans;

public class MyQueue<E> {
    private java.util.LinkedList<E> list=new java.util.LinkedList<>();
    
    public MyQueue() {
    }
    
    public MyQueue(E[] e){
        for(E item: e){
            this.enqueue(item);
        }
    }
    
    public void enqueue(E e){
        list.addLast(e);
    }
    
    // public void offer(E e){
    //     list.addFirst(e);
    // }
    
    // public E poll(){
    //     E o=list.get(getSize()-1);
    //     list.remove(getSize()-1);
    //     return o;
    // }
    
    public E dequeue(){
        return list.removeFirst();
    }

    public E getElement(int i) {
        if (i < 0 || i >= list.size()) {
            throw new IndexOutOfBoundsException();
        }

        int index = 0;
        for (E element : list) {
            if (index == i) {
                return element;
            }
            index++;
        }

        // We should never get here
        throw new RuntimeException("Unexpected error");
    }

    //returns the top elements
    public E peek(){
        return list.get(0);
    }
    
    public int getSize(){
        return list.size();
    }
    
    public boolean contains(E o) {
        return list.contains(o);
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }   
    
    public String toString(){
        return "Queue"+list.toString();
    }
    
}

class Tester{
    public static void main(String[] args) {
        String[] fruits = {"Durian","Blueberry"};
        MyQueue<String> fruitQ = new MyQueue<>(fruits);

        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");

        System.out.println(fruitQ.toString());

        System.out.println("Top item: " + fruitQ.peek());
        System.out.println("The size of queue: " + fruitQ.getSize());

        fruitQ.dequeue();

        System.out.println("Item in index position of 2: " + fruitQ.getElement(2));

        System.out.println("Is Cherry in the queue? " + fruitQ.contains("Cherry"));
        System.out.println("Is Durian in the queue? " + fruitQ.contains("Durian"));

        while (!fruitQ.isEmpty()){
            System.out.println(fruitQ.dequeue());
        }
    }
}