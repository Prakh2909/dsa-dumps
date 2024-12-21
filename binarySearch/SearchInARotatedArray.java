public class SearchInARotatedArray {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,8,9};
        System.out.println(findInARotatedArray(arr, 8));
    }

    public static int findInARotatedArray(int[] arr, int num){
        int n=arr.length-1;
        int peak = findPeak(arr);
        
        if(peak == n){
            return BinarySearchUingPredicate.binarySearch(arr, num, 0, n);
        }

        if(arr[0]>num){
            return BinarySearchUingPredicate.binarySearch(arr, num, peak+1, n);
        }else{
            return BinarySearchUingPredicate.binarySearch(arr, num, 0, peak);
        }
    }

    public static int findPeak(int[] a){
        int lo=0;
        int hi=a.length-1;
        while(lo<hi){
            //   TTTTFF a[mid]>=a[0] last T
            int mid = lo + (hi-lo+1)/2;
            if(a[mid]>=a[0]){
                lo = mid;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }



}
