package w11;

public class selectionSort {
    public static void main(String[] args) {
        // Q3
        int[] arr = {45, 7, 2, 8, 19, 3};
        selectionSortSmallest(arr);
        for (int i: arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        selectionSortLargest(arr);
        for (int i: arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
    
    public static void selectionSortSmallest(int[] arr){
        for (int i=0; i < arr.length - 1; i++) {
            // assume current is smallest
            int smallestIndex = i;
            for (int j=i+1; j < arr.length; j++) 
                if (arr[j] < arr[smallestIndex])
                    smallestIndex = j;
            // swap
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    public static void selectionSortLargest(int[] arr){
        for (int i=0; i < arr.length; i++) {
            // assume current is largest
            int largestIndex = i;
            for (int j=i; j < arr.length; j++) 
                if (arr[j] > arr[largestIndex])
                largestIndex = j;
            // swap
            int temp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = temp;
        }
    }
}
