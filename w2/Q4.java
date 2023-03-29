package w2;

public class Q4 {
    public static <E extends Comparable<E>> String minmax(E[] e){
        E min = e[0];
        E max = e[0];
        for(E item: e){
            if (item.compareTo(min) < 0){
                min = item;
            } else if (item.compareTo(max) > 0){
                max = item;
            }
        }
        return String.format("Min = %s\tMax = %s", min, max);
    }

    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};

        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }
}
