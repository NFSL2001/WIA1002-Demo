package w6.student_ans;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class TestIntMyStack {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        MyStack<Integer> stack = new MyStack<>();
        
        for(int i=1; i<=n; i++){
            stack.push(i);
        }
        
        System.out.println("Size: "+stack.getSize());
        System.out.println("Display Stack: ");
        for(int i=0; i<n; i++){
            System.out.print(stack.pop()+" ");
        }
        System.out.println("");
        
        
        
    }
    
}
