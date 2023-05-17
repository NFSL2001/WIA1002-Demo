package w8.student_ans;

import java.util.PriorityQueue;
public class PriorityQ2 {




        public static void main(String[] args) {
            // Create the first priority queue
            PriorityQueue<String> pq1 = new PriorityQueue<>();
            pq1.add("George");
            pq1.add("Jim");
            pq1.add("John");
            pq1.add("Blake");
            pq1.add("Kevin");
            pq1.add("Michael");

            // Create the second priority queue
            PriorityQueue<String> pq2 = new PriorityQueue<>();
            pq2.add("George");
            pq2.add("Katie");
            pq2.add("Kevin");
            pq2.add("Michelle");
            pq2.add("Ryan");

            // Find the union of the two priority queues
            PriorityQueue<String> union = new PriorityQueue<>(pq1);
            union.addAll(pq2);
            System.out.println("Union of the two priority queues: " + union.toString());

            // Find the difference of the two priority queues
            PriorityQueue<String> difference = new PriorityQueue<>(pq1);
            difference.removeAll(pq2);
            System.out.println("Difference of the two priority queues: " + difference.toString());

            // Find the intersection of the two priority queues
            PriorityQueue<String> intersection = new PriorityQueue<>(pq1);
            intersection.retainAll(pq2);
            System.out.println("Intersection of the two priority queues: " + intersection.toString());
        }
    }


