package w7.student_ans;

import java.util.Scanner;
public class Q4 {
    public static int sum = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String bs = "";
        String temp = "";
        int amount,price;
        MyQueue<Integer> listA = new MyQueue<>();
        MyQueue<Integer> listP = new MyQueue<>();
        
        while(true){
            System.out.print("Enter your query(In format 'Buy/Sell x shares at $y each'):");
            if((temp=input.nextLine()).equals("")){
                break;
            }
            else{
                
                String[] a = temp.split(" ");
                bs = a[0];
                amount = Integer.parseInt(a[1]);
                String temp2 = a[4].substring(1);
                price = Integer.parseInt(temp2);
            }
            if(bs.equals("Buy"))
                buy(listA,listP,amount,price);
            else
                sell(listA,listP,amount,price);
        }System.out.println("Final Capital Gain / Loss: " + sum);
        
        
    }
    public static void buy(MyQueue<Integer> list1,MyQueue<Integer> list2,int a,int b){
        System.out.println("Buying now...");
        list1.enqueue(a);
        System.out.println("Queue for share:"+list1.toString());
        list2.enqueue(b);
        System.out.println("Queue for price:"+list2.toString());
        
    }
    public static void sell(MyQueue<Integer> list1,MyQueue<Integer> list2,int a,int b){
        
        System.out.println("Selling the shares now...");
        while(a>0){
            if(list1.isEmpty()){
                System.out.println("No Shares to sell");
                break;
            }
            if(a>=list1.peek()){
               sum += list1.peek()*(b-list2.dequeue());
               a -= list1.dequeue();
                
            }
            else{
               sum += a* (b-list2.peek());
               list1.enqueue(list1.dequeue()-a);
               for (int i = list1.getSize(); i > 1; i--)
                    list1.enqueue(list1.dequeue());
                a = 0;
            }
            System.out.println("Total Capital Gain / Loss: " + sum);
        } 
        System.out.println("Queue for Share: Queue: " + list1);
        System.out.println("Queue for Price: Queue: " + list2);
    }
}