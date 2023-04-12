package w4;

/*
 * REMINDER
 * This version of the code does not track the number of total elements in the program.
 * You are free to use a variable to keep track of the number of total elements.
 */
public class MyLinkedList<E> {
    Node<E> head, tail;

    public MyLinkedList(){}

    public void addFirst(E e){
        //this.add(0, e);
        //new node
        Node<E> node = new Node<>(e);

        if(head == null && tail == null){
            //new list, just add
            head = tail = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    public void addLast(E e){
        //new node
        Node<E> node = new Node<>(e);

        if(head == null && tail == null){
            //new list, just add
            head = tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }

    /** Insert the given element in linkedlist, will insert at last if index is out of range
      @param index to insert
     */
    public void add(int index, E e){
        if(head == null && tail == null){
            //new list, just add
            Node<E> node = new Node<>(e);
            head = tail = node;
            return;
        }

        Node<E> currentNode = this.head;
        for(int i=1; i < index; i++){
            if(currentNode.next == null){
                //reached end of linkedlist
                break;
            }
            currentNode = currentNode.next;
        }
        // currentNode at index - 1
        Node<E> node = new Node<>(e);
        currentNode.next = node;
        this.tail = node;
        return;
    }

    public E removeFirst(){
        //return this.remove(0);
        if(this.head == null && this.tail == null){
            return null;
        } else if(this.head == this.tail){
            E e = this.head.element;
            head = tail = null;
            return e;
        }

        Node<E> ret = this.head;
        this.head = this.head.next;
        return ret.element;
    }

    public E removeLast(){
        if(this.head == null && this.tail == null){
            return null;
        } else if(this.head == this.tail){
            E e = this.head.element;
            head = tail = null;
            return e;
        }

        Node<E> currentNode = this.head;
        while(currentNode.next != this.tail){
            //stop before this.tail
            currentNode = currentNode.next;
        }
        Node<E> ret = this.tail;
        this.tail = currentNode;
        currentNode.next = null;
        return ret.element;
    }
    
    /** Remove the given index in linkedlist
      @param index to remove
      @return element at the index, null if index does not exist
     */
    public E remove(int index){
        if(this.head == null && this.tail == null){
            return null;
        } else if(this.head == this.tail){
            E temp = this.head.element;
            this.head = this.tail = null;
            return temp;
        }

        Node<E> currentNode = this.head;
        for(int i=1; i < index; i++){
            currentNode = currentNode.next;
        }
        //i=1, currentNode at index 1
        //i=index - 1 (i < index), currentNode at index-1
        
        //check if next node (at index) is null or currentNode is tail
        if(currentNode.next == null && currentNode == this.tail){
            return null;
        }

        Node<E> ret = currentNode.next;
        currentNode.next = ret.next;
        return ret.element;
    }

    public boolean contains(E e){
        if(this.indexOf(e) > -1) return true;
        else return false;
    }

    /** Returns the given index in linkedlist
      @param index to remove
      @return element at the index, null if index does not exist
     */
    public E get(int index){
        Node<E> currentNode = this.head;
        for(int i=1; i <= index; i++){
            if(currentNode.next == null && currentNode == this.tail){
                //reached end of linkedlist but not to index (not enough size)
                return null;
            }
            currentNode = currentNode.next;
        }
        //i=1, currentNode at index 1
        //i=index (i <= index), currentNode at index

        return currentNode.element;
    }

    public E getFirst(){
        if(this.head == null) return null;
        else return this.head.element;
    }

    public E getLast(){
        if(this.tail == null) return null;
        else return this.tail.element;
    }

    /** Returns the first index that has the element in linkedlist
      @param e element to find
      @return first index of element, -1 if not found
     */
    public int indexOf(E e){
        int index = -1;
        int i = 0;
        Node<E> currentNode = this.head;
        do{
            if(currentNode.element.equals(e)){
                //found and break (or alternatively return index)
                index = i;
                break;
            }
            //shift to next
            currentNode = currentNode.next;
            i++;
        } while (currentNode != null);

        return index;
    }

    /** Returns the last index that has the element in linkedlist
      @param e element to find
      @return last index of element, -1 if not found
     */
    public int lastIndexOf(E e){
        int index = -1;
        int i = 0;
        Node<E> currentNode = this.head;
        do{
            if(currentNode.element.equals(e)){
                //keep replace index until last index found
                index = i;
            }
            //shift to next
            currentNode = currentNode.next;
            i++;
        } while (currentNode != null);

        return index;
    }

    /** Set and replace the elemenet at the given index
      @param index index to replace
      @param e element to replace
      @return the original element before replacing
     */
    public E set(int index, E e){
        Node<E> currentNode = this.head;
        for(int i=1; i <= index; i++){
            if(currentNode.next == null && currentNode == this.tail){
                //reached end of linkedlist but not to index (not enough size)
                return null;
            }
            currentNode = currentNode.next;
        }
        //i=1, currentNode at index 1
        //i=index (i <= index), currentNode at index
        E temp = currentNode.element;
        currentNode.element = e;
        return temp;
    }

    public void clear(){
        this.head = this.tail = null;
    }

    public void print(){
        Node<E> currentNode = this.head;
        do{
            System.out.println(currentNode.element + " ");
            //shift to next
            currentNode = currentNode.next;
        } while (currentNode != null);
    }

    /** Print all elements in reverse order. Does not affect LinkedList. */
    public void reverse(){
        /* //cheating using getSize()
        for(int i = this.getSize() - 1; i >= 0; i--){
            System.out.println(get(i) + " ");
        }
        */
        Node<E> lastPrintNode = null;
        do{
            Node<E> currentNode = this.head;
            // loop if the next node is not the last printed node
            while(currentNode.next != lastPrintNode) {
                //shift to next
                currentNode = currentNode.next;
            }

            System.out.println(currentNode.element + " ");
            
            lastPrintNode = currentNode;
        } while (lastPrintNode != this.head);

    }


    /** Extra question: Reverse the LinkedList in place.  */
    public void reverseInPlace() {
        Node<E> previousNode = null;
        Node<E> currentNode = this.head;
        Node<E> nextNode = null;

        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        this.tail = this.head;
        this.head = previousNode;
    }

    public int getSize(){
        int size = 0;
        Node<E> currentNode = this.head;
        do{
            size++;
            //shift to next
            currentNode = currentNode.next;
        } while (currentNode != null);

        return size;
    }

    public E getMiddleValue(){
        int length = this.getSize();
        return this.get((length - 1)/2);
    }
}
