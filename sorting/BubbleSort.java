// Stable Bubble sort. With each iteration we put largest element at the end, also making sure we dont change the order of equal elements.
// time complexity= (n*(n-1))/2 => n^2
// In-place and stable
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,7,1,90,0};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr){
        int n = arr.length;
        boolean swapped = false;
        for(int i=0;i<n-1;i++){
            swapped = false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
        
    }

    public static void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
