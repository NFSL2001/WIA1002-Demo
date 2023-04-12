package w4.student_ans;

public class MyLinkedList_Q1_3<E> {
    Node<E> head, tail;
    int size;


    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> node = new Node<>(e);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            System.out.println("The list is empty. ");
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    public E removeLast(){
        if (size == 0){
            System.out.println("The list is empty. ");
            return null;
        }
        else if (size == 1){
            Node <E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else{
            Node <E> current = head;
            for (int i = 0; i < size - 2; i++){
                current = current.next;
            }
            Node <E> removed = tail;
            tail = current;
            tail.next = null;
            size --;
            return removed.element;
        }
    }

    public E remove(int index){
        if (index < 0 || index >= size){
            return null;
        }
        else if (index == 0){
            return removeFirst();
        }
        else if (index == size - 1){
            return removeLast();
        }
        else{
            Node <E> current = head;
            for (int i = 1; i < index; i++){
                current = current.next;
            }
            Node <E> removed = current.next;
            current.next = (current.next).next;
            size --;
            return removed.element;
        }
    }
}
