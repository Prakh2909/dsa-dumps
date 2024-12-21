public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,1,2,3,4,5};
        System.out.println(findPeakElement(arr));
    }

    public static int findPeakElement(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        while(lo<hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid+1]>arr[mid]){
                lo = mid+1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
}
