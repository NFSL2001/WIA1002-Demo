package w5.student_ans.SList;

public class SNode<E> {
    E e;
    SNode<E> prev;
    SNode<E> next;

    public SNode(){
        this(null, null, null);
    }

    public SNode(E e) {
        this(e, null, null);
    }

    public SNode(E e, SNode<E> next, SNode<E> prev) {
        this.e = e;
        this.prev = prev;
        this.next = next;
    }
}

class SList<E> {
    SNode<E> head;
    SNode<E> tail;
    int size;

    public SList() {
        this.size = 0;
        this.head = null;
        this.tail = null;

    }

    public void appendEnd(E e) {
        SNode<E> temp = new SNode<>(e, null, tail);
        if (size == 0)
            head = tail = temp;
        else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public E removeInitial() {
        if (size == 0)
            return null;
        E temp = head.e;
        if (size == 1) head = tail = null;
        else {
            head = head.next;
        }
        size--;
        return temp;
    }

    public boolean contains(E e) {
        SNode<E> temp = head;
        for (int i = 1; i < size; i++) {
            if (temp.e.equals(e))
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void clear() {
        SNode<E> temp = head;
        while (head != null) {
            temp = head.next;
            head.next = head.prev = null;
            head = temp;
        }
        tail.prev = tail.next = null;
        tail = null;
        size = 0;
        System.out.println("The list is empty");
    }

    public void display() {
        SNode<E> current = head;
        while (current != null) {
            System.out.print(current.e + " ");
            current = current.next;
        }
        System.out.println();
    }
}