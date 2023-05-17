package w8.student_ans;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q1 {
    public static void main(String[] args) {
        Integer[] arr = {4, 8, 1, 2, 9, 6, 3, 7};
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(arr));

        //Display all the elements inside this priority queue.
        System.out.println(pq.toString());

        //retrieve and remove the first element in this priority queue.
        System.out.println(pq.poll());
        //add new element 5 into the priority queue
        pq.add(5);
        //convert the priority queue into an array and display
        System.out.println(Arrays.toString(pq.toArray()));
        //retrieve the first element in the priority queue.
        System.out.println(pq.peek());
        //check if the priority queue consists of element “1”.
        System.out.println(pq.contains(1));
        // get the current size of the priority queue.
        System.out.println(pq.size());
        //display while removing the elements in the queue until it is empty.
        while (!pq.isEmpty())
            System.out.println("Removed Element: " +pq.poll());
        //Sort the priority queue in reversing order.
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.addAll(Arrays.asList(arr));
        System.out.println(pq2.toString());
    }
}