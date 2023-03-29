package w2.student_ans;

public class CompareMax {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
    
    public static void main(String[] args) {
        Integer x = 3;
        Integer y = 5;
        Integer z = 2;
        Integer max = maximum(x, y, z);
        System.out.println("The maximum of " + x + ", " + y + ", and " + z + " is " + max);
    }
}