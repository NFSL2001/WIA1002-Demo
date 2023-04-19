package w5;

public class Node<E> {
    E element;
    Node<E> prev, next;

    public Node(E element, Node<E> next, Node<E> prev){
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public Node(E element){
        this(element, null, null);
    }
}
