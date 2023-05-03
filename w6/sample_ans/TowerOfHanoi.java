package w6.sample_ans;

import java.util.*;

public class TowerOfHanoi{
   public static int makeTower(Stack A,Stack B){
      int a,b;
      try{
         a=Integer.parseInt(A.peek().toString());
      } 
      catch(Exception e) {
         a=0;
      }
      try{
         b=Integer.parseInt(B.peek().toString());
      }
      catch(Exception e){
         b=0;
      }
  
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
         Stack source=new Stack();
         Stack Auxilary=new Stack();
         Stack Destination=new Stack();
         int stepno=0;
         int status=0;

         System.out.print("Enter no Of Disk:");
         int disk=Integer.parseInt(input.nextLine());

         if(disk<=0){
            System.out.println("Invalid Disk Size");
            System.exit(1);
         }

         for(int i=disk;i>0;i--)
            source.push(i);

         int m=disk%2;
         do{
            if(m==1){
               status=makeTower(source,Destination);
               if(status==1){
                  System.out.println((++stepno)+"Source --> Destination");
               }
               else if(status==2){
                  System.out.println((++stepno)+"Destination --> Source");
               }
               status=makeTower(source,Auxilary);
               if(status==1){
                  System.out.println((++stepno)+"Source -->Auxilary");
               }
               else if(status==2){
                  System.out.println((++stepno)+"Auxilary --> Source");
               } 
               else
                  break;
            }else {
               status=makeTower(source,Auxilary);
               if(status==1){
                  System.out.println((++stepno)+"Source -->Auxilary");
               }
               else if(status==2){
                  System.out.println((++stepno)+"Auxilary --> Source");
               }
               status=makeTower(source,Destination);
               if(status==1){
                  System.out.println((++stepno)+"Source --> Destination");
               }
               else if(status==2){
                  System.out.println((++stepno)+"Destination --> Source");
               }
            }
   
            status=makeTower(Auxilary,Destination);
            if(status==1){
               System.out.println((++stepno)+"Auxilary --> Destination");
            }
            else if(status==2){
               System.out.println((++stepno)+"Destination --> Auxilary");
            }

         } while(Destination.size()!=disk);
         System.out.println("\nfinish"); 
      } catch (Exception ex) {}
   }
}
