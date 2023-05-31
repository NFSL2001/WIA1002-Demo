/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aviat
 */
public class Q4 {
    public static boolean even(int n) {
        if(n%2==0){
            return true;
        }
        else{
            return false;
        }
    }
    public static double reciprocal(double n) {
        double r = 1.000/n;
        return r;
    }
    public static void positive(int n) {
        
    }
    public static double exp(double x,int n) {
        if(n < 0){
            return reciprocal(x) * exp(x,n+1);
        }
        if(n == 0){
            return 1;
        }
        return x * exp(x,n-1);
    }
    public static void main(String[] args) {
        System.out.println(exp(4,-2));
    }
}
