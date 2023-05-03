package w6;

import java.util.Stack;

public class Q4 {
    public static void main(String[] args) {
        String input = "noon";
        System.out.printf("Is %s a palindrome? %b\n", input, isPalindrome(input));

        input = "eve";
        System.out.printf("Is %s a palindrome? %b\n", input, isPalindrome(input));

        input = "fifa";
        System.out.printf("Is %s a palindrome? %b\n", input, isPalindrome(input));

        input = "radars";
        System.out.printf("Is %s a palindrome? %b\n", input, isPalindrome(input));
    }

    public static boolean isPalindrome(String input){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            stack.push(input.charAt(i));
        }

        boolean isPalindrome = true;
        for(int i = 0; i < input.length(); i++){
            if (!stack.pop().equals(input.charAt(i))){
                isPalindrome = false;
            }
        }
        return isPalindrome;
    }
}
