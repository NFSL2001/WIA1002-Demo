package w4.student_ans;

public class L4Q2<E> {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.print("Elements in list: ");
        for (int i=1; i<10; i++) {
            list.addLast(i);
            System.out.print(i + " ");
        }
        System.out.println("\nMiddle value: " + list.getMiddleValue());
    }
}

class LinkedList<E> {

    Node<E> head = null;
    Node<E> tail = null;

    private static class Node<E> {
        E element;
        Node<E> next;
    }

    public void addLast(E e) {
        Node<E> newTail = new Node<>();
        newTail.element = e;
        if (tail == null) {
            head = newTail;
        } else {
            tail.next = newTail;
        }
        tail = newTail;
    }

    public E getMiddleValue() {
        int n = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            n++;
        }

        Node<E> current = head;
        for (int i = 0; i < n / 2; i++) {
            current = current.next;
        }
        return (current == null ? null : current.element);
    }
}
