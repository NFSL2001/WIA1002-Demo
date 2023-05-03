package w6;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<E> {
    private ArrayList<E> arrayList = new ArrayList<>();

    public void push(E o){
        arrayList.add(0, o);
    }

    public E pop(){
        if (isEmpty())
            throw new EmptyStackException();
        return arrayList.remove(0);
    }

    public E peek(){
        if (isEmpty())
            throw new EmptyStackException();
        return arrayList.get(0);
    }

    public int getSize(){
        return arrayList.size();
    }

    public boolean isEmpty(){
        return arrayList.isEmpty();
    }

    @Override
    public String toString(){
        return arrayList.toString();
    }

    public boolean search(E o){
        for(E e: arrayList){
            if (e.equals(o))
                return true;
        }
        return false;
        // or:
        // return arrayList.contains(o);
    }
}