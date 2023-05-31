/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aviat
 */
public class Q3 {
    public static int exp(int x,int n) {
        if(n == 0){
            return 1;
        }
        return x * exp(x,n-1);
    }
    public static void main(String[] args) {
        System.out.println(exp(10,3));
    }
}
