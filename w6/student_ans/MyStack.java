/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w6.student_ans;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author hueyling
 */
public class MyStack<E> {

    private ArrayList<E> list = new ArrayList<>();
    
    public MyStack(){}
    
    public void push(E o){
        list.add(o);
    }
    
    public E pop(){
        E tmp  = list.get(getSize()-1);
        list.remove(getSize()-1);
        return tmp;
    }
    
    public E peek(){
        return list.get(getSize()-1);
    }

    /*
     * public E pop() {
        if(list.isEmpty()) {
            return null;
        }
        return list.remove(list.size()-1);
    }
    
    public E peek() {
        if(list.isEmpty()) {
            return null;
        }
        return list.get(list.size()-1);
    }
     */
    
    public int getSize(){
        return list.size();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    @Override
    public String toString(){
        return "stack: "+list.toString();
    }
    
    public boolean search(E o){
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i).equals(o))
                return true;
        }
        return false;
    }
    
}
class TestMyStackClass{
    
    public static void main(String[] args) {
    MyStack<Character> stack = new MyStack<>();
    stack.push('a');
    stack.push('b');
    stack.push('c');
    System.out.println(stack);

    System.out.println(stack.search('b'));
    System.out.println(stack.search('k'));

    MyStack<Integer> stack1 = new MyStack<>();
    stack1.push(1);
    stack1.push(2);
    stack1.push(3);
    System.out.println(stack1);
    System.out.println(stack1.search(6));
    }
    
}

