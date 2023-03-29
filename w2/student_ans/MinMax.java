package w2.student_ans;

public class MinMax{

    public static <T extends Comparable> String minmax(T[] list){   //declaring a method which implements comparable interface

        T min = list[0];
        T max = list[0];

        for(int i = 1;i<list.length;i++){

            T n = list[i];

            if(n.compareTo(max)>0){
                max = n;
            }
            else if (n.compareTo(min)<0){
                min = n;
            }
        }

        return String.format("Min = <%s>, Max = <%s>", min,max);

    }

    public static void main(String[] args){
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red","blue","orange","tan"};

        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));


    }

}
