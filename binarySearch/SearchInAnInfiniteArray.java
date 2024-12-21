// unbounded binary search algo. Takes logn time where n is the position we found the hi.

public class SearchInAnInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        System.out.println(searchInAnInfiniteArray(arr, 17));
    }

    public static int searchInAnInfiniteArray(int[] arr, int num){
        int lo = 0;
        int hi = 1;
        while(lo<hi){
            if(arr[hi]<num){
                lo = hi;
                hi = hi*2;
                System.out.println(lo+" "+hi);
                continue;
            }
            int mid = lo + (hi-lo)/2;
            if(arr[mid]>=num){
                hi=mid;
            }else{
                lo = mid+1;
            }
        }

        if(arr[lo]==num){
            return lo;
        }
        return -1;
    }
}
