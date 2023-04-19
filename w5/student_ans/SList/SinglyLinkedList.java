/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package w5.student_ans.SList;

/**
 *
 * @author Dell
 */
public class SinglyLinkedList<E> {
    private SNode<E> head;
    private SNode<E> tail;
    private int size;

    public SinglyLinkedList() {
    }

    public void add(E e) {
        if (tail == null) {
            head = tail = new SNode<>(e);
        }
        else {
            tail.next = new SNode<>(e);
            tail = tail.next;
        }
        size++;
    }

    public void removeElement(E e) {
        if (size == 0) {
            throw new IllegalStateException();
        }

        SNode<E> current;
        if (head.e.equals(e)) {
            current = head;
            head = head.next;
        }
        else {
            SNode<E> previous = head;
            while (!previous.next.e.equals(e)) {
                previous = previous.next;
            }
            current = previous.next;
            previous.next = current.next;
        }
        size--;
        System.out.println(current.e);
    }

    public void printList() {
        SNode<E> current = head;
        String separator = "";
        while (current != null) {
            System.out.print(separator + current.e);
            current = current.next;
            separator = ", ";
        }
        System.out.println(".");
    }

    public int getSize() {
        return size;
    }

    public boolean contains(E e) {
        SNode<E> current = head;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void replace(E e, E newE) {
        SNode<E> current = head;
        while (!current.e.equals(e)) {
            current = current.next;
        }
        current.e = newE;
    }
}
