package w5;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private Node<E> head, tail;
    private int size;

    public DoublyLinkedList(){
        size = 0;
        this.head = null;
        this.tail = null;
    }
    
    public void addFirst(E element){
        Node<E> tmp = new Node<>(element, head, null);
        if(head != null){head.prev = tmp;}
        head = tmp;
        if(tail == null){tail = tmp;}
        size++;
        System.out.println("Adding: "+ element.toString());
    }
    public void addLast(E element){
        Node<E> tmp = new Node<>(element, null, tail);
        if(tail != null){tail.next = tmp;}
        tail = tmp;
        if(head == null){head = tmp;}
        size++;
        System.out.println("Adding: "+ element.toString());
    }
    public void add(int index, E element){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if(index == 0)
            addFirst(element);
        else if(index == size)
            addLast(element);
        else{
            Node<E> temp = head;
            for(int i=0; i<index; i++)
                temp = temp.next;
            //temp at [index]
            Node<E> insert = new Node<>(element, temp, temp.prev);
            temp.prev.next = insert;
            temp.prev = insert;
            size++;
        }
    }

    public void iterateForward(){
        System.out.println("Iterating forward....");
        Node<E> tmp = head;
        while (tmp != null){
            System.out.print(tmp.element);
            System.out.print(" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    public void iterateBackward(){
        System.out.println("Iterating backward....");
        Node<E> tmp = tail;
        while (tmp != null){
            System.out.print(tmp.element);
            System.out.print(" ");
            tmp = tmp.prev;
        }
        System.out.println();
    }

    public E removeFirst(){
        if(size == 0) throw new NoSuchElementException();
        Node<E> tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("Deleted: "+tmp.element);
        return tmp.element;
    }
    public E removeLast(){
        if(size == 0) throw new NoSuchElementException();
        Node<E> tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("Deleted: "+tmp.element);
        return tmp.element;
    }
    public E remove(int index){
        E element = null;
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(index == 0)
            element = removeFirst();
        else if(index == size-1)
            element = removeLast();
        else{
            Node<E> temp = head;
            for(int i=0; i<index; i++)
                temp = temp.next;
            //temp at [index]
            element = temp.element;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            //clear pointer
            temp.prev = null;
            temp.next = null;
            size--;
        }
        return element;
    }

    public void clear(){
        Node<E> temp = head;
        while(head != null){
            temp = head.next;
            head.prev = head.next = null;
            head = temp;
        }
        temp = null;
        tail.prev = tail.next = null;
        size = 0;
    }
    public int getSize(){
        return size;
    }
}
