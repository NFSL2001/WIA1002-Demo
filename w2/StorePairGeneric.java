package w2;

public class StorePairGeneric<E extends Comparable<E>> implements Comparable<StorePairGeneric<E>> {
    private E first, second;

    public StorePairGeneric(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public void setPair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "first = " + first.toString() + " second = " + second.toString();
    }

    @Override
    public boolean equals(Object obj) {
        StorePairGeneric<E> other = (StorePairGeneric<E>) obj;
        return this.first.equals(other.first);
    }

    @Override
    public int compareTo(StorePairGeneric<E> o) {
        return this.first.compareTo(o.first);
    }

    public static void main(String[] args) {
        StorePairGeneric<Integer> a = new StorePairGeneric<Integer>(6, 4);
        StorePairGeneric<Integer> b = new StorePairGeneric<Integer>(2, 2);
        StorePairGeneric<Integer> c = new StorePairGeneric<Integer>(6, 3);

        System.out.println(Integer.toString(a.compareTo(b)));
        System.out.println(Integer.toString(a.compareTo(c)));
        System.out.println(Integer.toString(b.compareTo(c)));
        System.out.println(Boolean.toString(a.equals(b)));
        System.out.println(Boolean.toString(a.equals(c)));
        System.out.println(Boolean.toString(b.equals(c)));
    }
}
