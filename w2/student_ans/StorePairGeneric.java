package w2.student_ans;

public class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>> {
    
    private T first, second;
    
    public StorePairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst() {
        return first;
    }
    
    public T getSecond() {
        return second;
    }
    
    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public String toString() {
    return "first = " + first.toString() + " second = " + second.toString();
    }
    
    public boolean equals(StorePairGeneric<T> o){
        if(getFirst().compareTo(o.getFirst())==0){
            return true;
        }
        else
            return false;
    }
   
    @Override
    public int compareTo(StorePairGeneric<T> o){
        return getFirst().compareTo(o.getFirst());
    }
}

class test{
    public static void main(String[]args){
        StorePairGeneric <Integer> a =new StorePairGeneric<>(6,4);
        StorePairGeneric <Integer> b =new StorePairGeneric<>(2,2);
        StorePairGeneric <Integer> c =new StorePairGeneric<>(6,3);
        
        System.out.println("Object 1 compare with object 2 ? "+a.compareTo(b));
        System.out.println("Object 1 compare with Object 3 ? "+a.compareTo(c));
        System.out.println("Object 2 compare with Object 3 ? "+b.compareTo(c));
        System.out.println("Object 1 first value equals with Object 2 ?"+a.equals(b));
        System.out.println("Object 1 first value equals with Object 3 ?"+a.equals(c));
        System.out.println("Object 2 first value equals with Object 3 ?"+b.equals(c));
    }
}
