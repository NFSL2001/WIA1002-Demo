package w10;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(exponent(10, 3));
        System.out.println(exponentDouble(10, -3));
    }

    public static long exponent(int x, int m) {
        // special requirement from question, only valid function for m >= 0
        if (m < 0)
            return 0;

        if (m == 0)
            return 1;
        if (m == 1)
            return x; // quick optimization
        return x * exponent(x, m - 1);
    }

    // Additional question: exponent function that can accept positive and negative values of m
    public static double exponentDouble(double x, int m) {
        if (m == 0)
            return 1;
        if (m == 1)
            return x; // quick optimization
        if (m == -1)
            return 1 / x; // quick optimization
        if (m > 0)
            return x * exponentDouble(x, m - 1);
        else
            return (1 / x) * exponentDouble(x, m + 1);
            // return 1/ (exponentDouble(x, -m));
            // return exponentDouble(1/x, -m);
    }
}
