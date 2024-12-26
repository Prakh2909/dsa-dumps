// In this we start by find the largest or smallest first and putting them in the correct place.
// In-place and unstable
// tc: n^2

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,7,1,90,0};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr){
        int minIndex;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            Swap.swap(arr, minIndex, i);
        }
    }
}
