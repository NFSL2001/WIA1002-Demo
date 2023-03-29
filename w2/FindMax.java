package w2;

public class FindMax {
    static class Circle implements Comparable<Circle>{
        double radius;

        public Circle(double radius){
            this.radius = radius;
        }

        @Override
        public int compareTo(Circle o) {
            return Double.compare(this.radius, o.radius);
        }
    }

    public static <E extends Comparable<E>> E max(E[] list){
        E max = list[0];
        for(E item: list){
            if (item.compareTo(max) > 0){
                max = item;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"red", "green", "blue"};
        Circle[] circleArr = {new Circle(3.0), new Circle(2.9), new Circle(5.9)};

        System.out.println(max(intArr).toString());
        System.out.println(max(strArr));
        System.out.println(Double.toString(max(circleArr).radius));
    }
}
