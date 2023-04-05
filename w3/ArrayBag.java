package w3;

public class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private int DEFAULT_CAPACITY = 25;
    private int numberOfEntries = 0;

    public ArrayBag(){
        bag = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayBag(int capacity){
        bag = (T[]) new Object[capacity];
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if(isFull()){
            return false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries += 1;
            return true;
        }
    }

    @Override
    public T remove() {
        if(isEmpty())
            return null;
        else{
            T ret = bag[numberOfEntries];
            bag[numberOfEntries] = null;
            numberOfEntries--;
            return ret;
        }
    }

    @Override
    public boolean remove(T anEntry) {
        boolean move = false;
        //search through entries
        for(int i=0; i < numberOfEntries; i++){
            // move previous item forward
            if (move){
                bag[i-1] = bag[i];
                continue;
            }
            //if found
            if (bag[i].equals(anEntry)){
                move = true;
            }
        }
        if (move) 
            numberOfEntries -= 1;
        return move;
    }

    @Override
    public void clear() {
        bag = (T[]) new Object[bag.length];
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        //search through entries
        for(int i=0; i < numberOfEntries; i++){
            //if found
            if (bag[i].equals(anEntry)){
                count += 1;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        //search through entries
        for(int i=0; i < numberOfEntries; i++){
            //if found
            if (bag[i].equals(anEntry)){
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] ret_arr = (T[]) new Object[numberOfEntries];
        //loop through entries
        for(int i=0; i < numberOfEntries; i++){
            ret_arr[i] = bag[i];
        }
        //or may use System function to copy
        //System.arraycopy(this.bag, 0, ret_arr, 0, numberOfEntries);
        return ret_arr;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> aBag) {
        int ret_bag_length = getCurrentSize() + aBag.getCurrentSize();
        ArrayBag<T> ret_bag = new ArrayBag<>(ret_bag_length);
        for(T t: this.toArray()){
            ret_bag.add(t);
        }
        for(T t: aBag.toArray()){
            ret_bag.add(t);
        }
        return ret_bag;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> aBag) {
        int ret_bag_length = getCurrentSize();
        ArrayBag<T> ret_bag = new ArrayBag<>(ret_bag_length);
        // copy incoming bag
        ArrayBag<T> copy_aBag = new ArrayBag<>(aBag.getCurrentSize());
        for(T t: aBag.toArray()){
            copy_aBag.add(t);
        }
        //compare this bag with another bag
        for(T t: this.toArray()){
            if(copy_aBag.contains(t)){
                ret_bag.add(t); //both contains t, add to ret_bag
                copy_aBag.remove(t); //remove it to do new comparison
            }
        }
        return ret_bag;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> aBag) {
        ArrayBag<T> ret_bag = new ArrayBag<>(this.getCurrentSize());
        // copy incoming bag
        ArrayBag<T> copy_aBag = new ArrayBag<>(aBag.getCurrentSize());
        for(T t: aBag.toArray()){
            copy_aBag.add(t);
        }
        //compare this bag with another bag
        for(T t: this.toArray()){
            if(copy_aBag.contains(t)){
                copy_aBag.remove(t); //remove it to do new comparison
            } else {
                ret_bag.add(t); //this contains t but not aBag, add to ret_bag
            }
        }
        return ret_bag;
    }
    
}
