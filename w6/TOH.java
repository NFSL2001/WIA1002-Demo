package w6;

import java.util.ArrayList;
import java.util.Stack;

public class TOH {
    private Tower tower1 = new Tower(1);
    private Tower tower2 = new Tower(2);
    private Tower tower3 = new Tower(3);
    private int size;
    
    public static void main(String[] args) {
        TOH a = new TOH(5);
        a.movePillar();
    }

    public TOH(){}

    public TOH(int size){
        this.size = size;
        // initialise tower1, push largest number in first
        for(int i=size; i >= 1; i--){
            tower1.stack.push(i);
        }

    }

    // entry point for recursive loop
    public void movePillar(){
        System.out.println("Start moving");
        displayTower(tower1, tower2, tower3);
        int steps = movePillar(tower1, tower3, tower2, this.size);
        System.out.printf("Total steps: %d", steps);
    }

    // recursive moving pillar
    public int movePillar(Tower from, Tower to, Tower spare, int target_size){
        if(target_size == 0){
            return 0;
        }
        // swap destination to `stay`, size - 1
        int before = movePillar(from, spare, to, target_size-1);

        System.out.printf("Move '%d' from stack %s to stack %s\n", target_size, from.num, to.num);
        to.stack.push(from.stack.pop());
        displayTower(from, to, spare);

        // move pillar on `stay` back to `to`
        int after = movePillar(spare, to, from, target_size-1);

        return before + 1 + after;
    }

    public void displayTower(Tower tower1, Tower tower2, Tower tower3){
        // sort towers based on tower.num
        ArrayList<Tower> listTower = new ArrayList<>();
        listTower.add(tower1);
        // insert before or after tower1
        if(tower2.num > tower1.num)
            listTower.add(tower2);
        else
            listTower.add(0, tower2);
        // enough length to use add(index)
        listTower.add(tower3.num - 1, tower3);
        
        
        ArrayList<ArrayList<Integer>> paddedToSize = new ArrayList<>();
        for (Tower t: listTower){
            // convert stack to arraylist in reverse order
            ArrayList<Integer> temp = new ArrayList<>(t.stack);
            while (temp.size() < this.size){
                temp.add(temp.size(), -1);
            }
            paddedToSize.add(temp);
        }

        System.out.printf("%12s%12s%12s\n", "Stack 1", "Stack 2", "Stack 3");
        // display in vertical order
        for(int i=this.size - 1; i >= 0; i--){
            System.out.printf("%12s%12s%12s\n", 
            dp(paddedToSize.get(0).get(i)), 
            dp(paddedToSize.get(1).get(i)), 
            dp(paddedToSize.get(2).get(i)));
        }
        System.out.println();
    }
    
    public String dp(int num){
        if (num == -1) return "┆";
        return Integer.toString(num);
    }
}

class Tower{
    int num;
    Stack<Integer> stack = new Stack<>();
    public Tower(){}
    public Tower(int num){
        this.num = num;
    }
}