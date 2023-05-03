package w6.student_ans;

import java.util.Scanner;

public class Q4 {
    public static boolean isPalindrome(MyStack<Character> stack){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string(max 15 characters): ");
        String word = sc.nextLine();
        
        for(int i = 0; i<word.length(); i++){
            stack.push(word.charAt(i));
        }
        
        boolean isPalindrome = true;
        
        for(int i = 0; i<word.length(); i++){
            if(stack.pop() != word.charAt(i)){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
       
        MyStack<Character> stack = new MyStack<>();
        System.out.println(isPalindrome(stack));
    }
}
