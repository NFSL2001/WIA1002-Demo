public class ArrayBag1<T> implements BagInterface<T>{
     private final int DEFAULT_CAPACITY = 25;
    private T[] bag = (T[]) new Object[DEFAULT_CAPACITY];
    private int numberOfEntries;
     
     @Override
     public int getCurrentSize(){
        return numberOfEntries;
     }
     @Override
     public boolean isFull(){
         return numberOfEntries == DEFAULT_CAPACITY;
     }    
     @Override
     public boolean isEmpty(){
        return numberOfEntries == 0;
     } 
     @Override
     public boolean add(T newEntry){
         if(isFull())
             return false;
         bag[numberOfEntries++]=newEntry;
            return true;
     }
     @Override
     public T remove() {
        if (isEmpty()) 
            return null;
        T item = bag[--numberOfEntries];
        bag[numberOfEntries] = null;
        return item;
    }
     public boolean remove(T anEntry) {
        int index = -1;
        for (int i = 0; i < numberOfEntries; i++)
            if (bag[i].equals(anEntry)) {
                index = i;
                break;
            }
        if (index == -1) return false;

        bag[index] = bag[--numberOfEntries];
        bag[numberOfEntries] = null;
        return true;
    }
    @Override
    public void clear() {
        for (int i = 0; i < numberOfEntries; i++)
            bag[i] = null;
    }
    @Override
    public int getFrequencyOf(T anEntry) {
        int freq = 0;
        for (T item : bag)
            if (item.equals(anEntry)) freq++;
        return freq;
    }
    @Override
    public boolean contains(T anEntry) {
        for (T item : bag)
            if (item.equals(anEntry)) return true;
        return false;
    }
    public T[] toArray() {
        T[] arr = bag.clone();
        return arr;
    }
    @Override
    public BagInterface<T> union(BagInterface<T> bag2) {
        ArrayBag1<T> union = new ArrayBag1<>();
        for (int i = 0; i < numberOfEntries; i++)
            union.add(bag[i]);
        T[] bag2Array = bag2.toArray();
        for (T item : bag2Array)
            union.add(item);
        return union;
    }
    @Override
    public BagInterface<T> intersection(BagInterface<T> bag2) {
        ArrayBag1<T> intersection = new ArrayBag1<>();
        T[] bag2Array = bag2.toArray();
        for (int i = 0; i < numberOfEntries; i++) {
            T item = bag[i];
            for (int j = 0; j < bag2Array.length; j++) {
                if (item.equals(bag2Array[j])) {
                    intersection.add(item);
                    bag2Array[j] = null;
                    break;
                }
            }
        }
        return intersection;
    }
    public BagInterface<T> difference(BagInterface<T> bag2) {
        ArrayBag1<T> difference = new ArrayBag1<>();
        for (int i = 0; i < numberOfEntries; i++)
            difference.add(bag[i]);
        T[] bag2Array = bag2.toArray();
        for (T t : bag2Array)
            difference.remove(t);
        return difference;
    }
}