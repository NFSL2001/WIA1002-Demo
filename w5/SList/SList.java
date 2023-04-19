package w5.SList;

public class SList<E> {
    protected SNode<E> head, tail;

    public void appendEnd(E e){
        SNode<E> node = new SNode<>(e);
        if(head == null && tail == null){
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public E removeInitial(){
        if(head == null && tail == null){
            return null;
        }

        E ret = head.item;
        if(head == tail){
            head = tail = null;
        } else {
            head = head.next;
        }
        return ret;
    }

    public boolean contains(E e){
        if(head == null && tail == null){
            return false;
        }
        
        for(SNode<E> current = head; current != null; current = current.next){
            if (current.item.equals(e))
                return true;
        }
        return false;
    }

    public void clear(){
        head = tail = null;
        System.out.println("List is cleared.");
    }

    public void display(){
        if(head == null && tail == null){
            return;
        }
        String out = "";
        for(SNode<E> current = head; current != null; current = current.next){
            out += current.item.toString();
            if(current.next != null)
                out += ", ";
        }
        System.out.println(out);
    }

    /**
     * Adds an element to the end of SList
     * @param e element to be added
     */
    public void add(E e){
        this.appendEnd(e);
    }

    /**
     * Remove the element e from SList once
     * @param e element to  be removed
     */
    public void removeElement(E e) {
        if(!contains(e) || (head == null && tail == null)){
            return;
        }

        if(head.item.equals(e)){
            this.removeInitial();
            return;
        }

        SNode<E> current;
        for(current = head; !current.next.item.equals(e); current = current.next){
            //move current to the node before e
            //code stops when current.next.item equals e
        }
        current.next = current.next.next;
    }

    public void printList() {
        this.display();
    }

    public int getSize() {
        int size = 0;
        for(SNode<E> current = head; current != null; current = current.next){
            size++;
        }
        return size;
    }

    /**
     * Replace only the first element matching e with newE.
     * @param e element to be replaced
     * @param newE element to replace into
     */
    public void replace(E e, E newE){
        if(!contains(e) || (head == null && tail == null)){
            return;
        }

        SNode<E> current;
        for(current = head; current != null; current = current.next){
            if(current.item.equals(e)){
                current.item = newE;
            }
        }
    }
}
