package w4;

public class Node<T>{
    T element;
    Node<T> next;

    public Node(){}

    public Node(T t){
        this.element = t;
    }
}