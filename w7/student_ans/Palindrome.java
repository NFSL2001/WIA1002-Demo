package w7.student_ans;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        MyQueue<Character> q = new MyQueue<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String str1 = sc.nextLine();

        for (int i = str1.length()-1; i >=0; i--) {
            q.enqueue(str1.charAt(i));
        }

        boolean reverse = true;
        for (int i = 0; i< str1.length();i++) {
            if (q.dequeue() != str1.charAt(i)){
            reverse = false;
            break;}
        }

        if (reverse) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
    }
