package w6.sample_ans;

import java.util.*;

public class TowerOfHanoi2{
   public static Stack<Integer>[] tower = new Stack[4];

   public static int moveDisk(Stack<Integer> A,Stack<Integer> B){
      Integer a,b;

      if (A.size()!=0)
         a=A.peek();
      else a=0;
      if (B.size()!=0)
         b=B.peek();
      else b=0;

      if(a==b) return 0;
      if(a==0){
         A.push(B.pop());
         return 2;
      }
      else if(b==0){
         B.push(A.pop());
         return 1; 
      }
      if(a>b){
         A.push(B.pop());
         return 2;
      }
      else if(a<b){
         B.push(A.pop());
         return 1;
      }
      return -1;
   }
 
   public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      try {
         tower[1] = new Stack<Integer>();
         tower[2] = new Stack<Integer>();
         tower[3] = new Stack<Integer>();
         int stepno=0;
         int status=0;

         System.out.print("Enter no Of Disk:");
         int disk=Integer.parseInt(input.nextLine());

         if(disk<=0){
            System.out.println("Invalid Disk Size");
            System.exit(1);
         }

         for(int i=disk;i>0;i--)
            tower[1].push(i);

         int m=disk%2;
         do{
            if(m==1){
               status=moveDisk(tower[1],tower[2]);
               if(status==1){
                  System.out.println((++stepno)+": tower[1] --> tower[2]");
               }
               else if(status==2){
                  System.out.println((++stepno)+": tower[2] --> tower[1]");
               }
               status=moveDisk(tower[1],tower[3]);
               if(status==1){
                  System.out.println((++stepno)+": tower[1] --> tower[3]");
               }
               else if(status==2){
                  System.out.println((++stepno)+": tower[3] --> tower[1]");
               } 
               else
                  break;
            }else {
               status=moveDisk(tower[1],tower[3]);
               if(status==1){
                  System.out.println((++stepno)+": tower[1] --> tower[3]");
               }
               else if(status==2){
                  System.out.println((++stepno)+": tower[3] --> tower[1]");
               }
               status=moveDisk(tower[1],tower[2]);
               if(status==1){
                  System.out.println((++stepno)+": tower[1] --> tower[2]");
               }
               else if(status==2){
                  System.out.println((++stepno)+": tower[2] --> tower[1]");
               }
            }
            status=moveDisk(tower[3],tower[2]);
            if(status==1){
               System.out.println((++stepno)+": tower[3] --> tower[2]");
            }
            else if(status==2){
               System.out.println((++stepno)+": tower[2] --> tower[3]");
            }

         } while(tower[2].size()!=disk);
         System.out.println("\nfinish"); 
      } catch (Exception ex) {}
   }
}
