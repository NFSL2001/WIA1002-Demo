package w2;

public class MinMaxTwoDArray {
    public static <E extends Comparable<E>> E min(E[][] list){
        E min = list[0][0];
        for(E[] arr: list){
            for(E item: arr){
                if (item.compareTo(min) < 0){
                    min = item;
                }
            }
        }
        return min;
    }

    public static <E extends Comparable<E>> E max(E[][] list){
        E max = list[0][0];
        for(E[] arr: list){
            for(E item: arr){
                if (item.compareTo(max) > 0){
                    max = item;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[][] numbers = {{4, 5, 6}, {1, 2, 3}};

        System.out.printf(
            "Min: %d\nMax: %d",
            min(numbers),
            max(numbers)
            );
    }
}
