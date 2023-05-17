package w8;

import java.util.PriorityQueue;

public class Q2 {
    public static void main(String[] args) {
        String[] one = { "George", "Jim", "John", "Blake", "Kevin", "Michael" };
        String[] two = { "George", "Katie", "Kevin", "Michelle", "Ryan" };
        PriorityQueue<String> pq1 = new PriorityQueue<>();
        PriorityQueue<String> pq2 = new PriorityQueue<>();

        for (String i : one)
            pq1.add(i);
        for (String i : two)
            pq2.add(i);
        
        System.out.println("Priority Queue 1: " + pq1.toString());
        System.out.println("Priority Queue 2: " + pq2.toString());

        System.out.println("Union");
        PriorityQueue<String> union = new PriorityQueue<>(pq1);
        for (String element : pq2){
            if (!union.contains(element))
                union.add(element);
        }
        System.out.println(union);

        System.out.println("Difference");
        PriorityQueue<String> diff = new PriorityQueue<>(pq1);
        for (String element : pq2){
            if (diff.contains(element))
                diff.remove(element);
        }
        System.out.println(diff);
        
        System.out.println("Intersection");
        PriorityQueue<String> intersect = new PriorityQueue<>(pq1);
        for (Object element : intersect.toArray()){
            if (!pq2.contains(element))
                intersect.remove(element);
        }
        System.out.println(intersect);
    }
}
