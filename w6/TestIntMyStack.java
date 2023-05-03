package w6;

import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a number: ");
        int count = sc.nextInt();

        MyStack<Integer> stack = new MyStack<>();
        if (count >= 1){
            for(int i=1; i<=count; i++){
                stack.push(i);
            }
        } else {
            for(int i=1; i>=count; i--){
                stack.push(i);
            }
        }

        System.out.printf("Size of stack: %d\n", stack.getSize());
        
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
