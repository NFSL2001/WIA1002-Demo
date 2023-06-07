package w11;

public class insertionSort{
    public static void main(String[] args) {
        // Q4
        int[] arr2 = {10,34,2,56,7,67,88,4};
        insertionSort2(arr2);
        for (int i: arr2) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void insertionSort2(int[] arr) {
        for (int i=1; i < arr.length; i++){
            int current = arr[i];
            int j;
            for (j=i-1; j >= 0; j--){
                if (arr[j] > current){
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = current;
        }
    }

}