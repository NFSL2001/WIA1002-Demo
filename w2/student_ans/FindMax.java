package w2.student_ans;

import java.util.Arrays;

public class FindMax {

    public static void main(String[] args) {

        // Create array of integers
        Integer[] intArray = {1, 2, 3};
        // Find max integer
        Integer maxInt = max(intArray);
        System.out.println("Max integer: " + maxInt);

        // Create array of strings
        String[] strArray = {"red", "green", "blue"};
        // Find max string
        String maxStr = max(strArray);
        System.out.println("Max string: " + maxStr);

        // Create array of circles
        Circle[] circleArray = {new Circle(3), new Circle(2.9), new Circle(5.9)};
        // Find max circle
        Circle maxCircle = max(circleArray);
        System.out.println("Max circle radius: " + maxCircle.getRadius());
    }

    public static <E extends Comparable<E>> E max(E[] list) {
        Arrays.sort(list);
        return list[list.length-1];
    }

    public static class Circle implements Comparable<Circle> {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public int compareTo(Circle c) {
            if (this.radius < c.radius) {
                return -1;
            } else if (this.radius > c.radius) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
