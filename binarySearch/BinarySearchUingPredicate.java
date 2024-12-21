public class BinarySearchUingPredicate {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60};
        System.out.println(findUsingBinarySearch(arr, 20));
        System.out.println(binarySearch(arr, 30, 0, arr.length-1));
    }

    public static int findUsingBinarySearch(int[] arr, int num){
        int lo = 0;
        int hi = arr.length-1;
        //FFFTTTT find first T
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]>=num){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }

        if(arr[lo]==num){
            return lo;
        }

        return -1;
    }
    
    public static int binarySearch(int[] arr, int num, int lo, int hi){
        while(lo<hi){
            //TTTTFFFF find last T
            int mid = lo + (hi-lo + 1)/2;
            if(arr[mid]<=num){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        if(arr[lo]==num) return lo;

        return -1;
    }
}
