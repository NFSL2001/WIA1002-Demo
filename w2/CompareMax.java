package w2;

public class CompareMax {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        if(x.compareTo(y) > 0 && x.compareTo(z) > 0)
            return x;
        else if(y.compareTo(x) > 0 && y.compareTo(z) > 0)
            return y;
        else
            return z;
    }

    public static void main(String[] args) {
        System.out.printf("The maximum of %d, %d and %d is: %d\n", 4, 3, 2, maximum(4, 3, 2));
        System.out.printf("The maximum of %f, %f and %f is: %f\n", 15.744, 17.454, 17.445, maximum(17.444, 17.454, 17.445));
        System.out.printf("The maximum of %s, %s and %s is: %s\n", "apple", "orange", "zebra", maximum("apple", "orange", "zebra"));
    }
}
