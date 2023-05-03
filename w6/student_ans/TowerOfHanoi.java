package w6.student_ans;

import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
    private Stack<Integer> tower1;
    private Stack<Integer> tower2;
    private Stack<Integer> tower3;
    private int numberOfDisks;
    private static int move = 0;

    public TowerOfHanoi(int numberOfDisks) {
        this.numberOfDisks = numberOfDisks;
        tower1 = new Stack<>();
        tower2 = new Stack<>();
        tower3 = new Stack<>();

        // Initialize source stack with disks in ascending order of size
        for (int i = numberOfDisks; i >= 1; i--) {
            tower1.push(i);
        }
    }

    public void solve() {
        moveDisks(numberOfDisks, tower1, tower2, tower3);
    }

    private void moveDisks(int numberOfDisks, Stack<Integer> tower1, Stack<Integer> tower2, Stack<Integer> tower3) {
        if (numberOfDisks == 1) {
            // Move the top disk from tower1 to tower3
            int disk = tower1.pop();
            tower3.push(disk);
            System.out.print("Move (" + ++move + ") ");
            System.out.println("Moved disk " + disk + " from " + sourceName(tower1) + " to " + sourceName(tower3));
        } else {
            // Move n-1 disks from tower1 to tower2 using recursively
            // So we switch tower2 and tower3 to make destination as tower 2
            moveDisks(numberOfDisks - 1, tower1, tower3, tower2);

            // Move the nth disk from tower1 to tower3
            int disk = tower1.pop();
            tower3.push(disk);
            System.out.print("Move (" + ++move + ") ");
            System.out.println("Moved disk " + disk + " from " + sourceName(tower1) + " to " + sourceName(tower3));

            // Move n-1 disks from tower2 to tower3 using tower1 as tower2
            moveDisks(numberOfDisks - 1, tower2, tower1, tower3);
        }
    }

    private String sourceName(Stack<Integer> stack) {
        if (stack == tower1) {
            return "tower 1";
        } else if (stack == tower2) {
            return "tower 2";
        } else {
            return "tower 3";
        }
    }

    public static void main(String[] args) {
        //Default number of disks
        int numberOfDisks = 3;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        numberOfDisks = sc.nextInt();
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi(numberOfDisks);
        towerOfHanoi.solve();
    }
}
