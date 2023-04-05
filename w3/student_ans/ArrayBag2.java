
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 60111
 */
public class ArrayBag2<T> implements BagInterface<T> {

    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag2() {
        this.bag = (T[]) new Object[this.DEFAULT_CAPACITY];
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == 25;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        boolean result = true;
        if (isFull()) {
            result = false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;

    }

    /* public boolean add (T newEntry){
      boolean result = false;
    
     if(newEntry != null && ! isFull()){
       result = true;
       bag[numberOfEntries] = newEntry;
       numberOfEntries++;
     }
      return result;
    } */
    @Override
    public T remove() {
        T result = null;
        if (numberOfEntries > 0) {
            numberOfEntries--;
            result = bag[numberOfEntries];
            bag[numberOfEntries] = null;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                numberOfEntries--;
                bag[i] = bag[numberOfEntries];
                bag[numberOfEntries] = null;
                result = true;
                break;
            }

        }
        return result;

    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                frequency++;
            }
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean result = false;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;

    }

    @Override
    public BagInterface<T> union(BagInterface<T> bag2) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(bag));
        T[] items = bag2.toArray();
        int size = numberOfEntries;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                list.set(size, items[i]);
                size++;
            }
        }

        BagInterface<T> everything = new ArrayBag2<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                break;
            }
            everything.add(list.get(i));
        }
        return everything;

    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> bag2) {
        ArrayList<T> list = new ArrayList<>();
        T[] items = bag2.toArray();
        for (int i = 0; i < items.length; i++) {
            int frequency1 = this.getFrequencyOf(items[i]);
            int frequency2 = bag2.getFrequencyOf(items[i]);
            int frequency = Math.min(frequency1, frequency2);
            int counter = 0;
            boolean stored = list.contains(items[i]);
            if (items[i] == null) {
                break;
            }
            if (frequency > 0 && !stored) {
                while (counter < frequency) {
                    list.add(items[i]);
                    counter++;
                }
            }

        }

        BagInterface<T> commonItems = new ArrayBag2<>();
        for (int i = 0; i < list.size(); i++) {
            commonItems.add(list.get(i));
        }
        return commonItems;

    }

    @Override
    public BagInterface<T> difference(BagInterface<T> bag2) {
        ArrayList<T> list = new ArrayList<>();
        T[] items = bag2.toArray();
        for (int i = 0; i < bag.length; i++) {
            int frequency1 = this.getFrequencyOf(bag[i]);
            int frequency2 = bag2.getFrequencyOf(bag[i]);
            boolean afterMinus = frequency1 - frequency2 > 0;
            int counter = 0;
            boolean stored = list.contains(bag[i]);
            if (bag[i] == null) {
                break;
            }
            if (afterMinus && !stored) {
                int frequency = frequency1 - frequency2;
                while (counter < frequency) {
                    list.add(bag[i]);
                    counter++;

                }
            }

        }

        BagInterface<T> leftOver = new ArrayBag2<>();
        for (int i = 0; i < list.size(); i++) {
            leftOver.add(list.get(i));

        }
        return leftOver;
    }

}
