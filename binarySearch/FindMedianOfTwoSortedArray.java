public class FindMedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {10,20,30,40,50};
        int[] arr2 = {5,15,25,35,45,55,65,75,85};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int lo = 0;
        int hi = n1;
        while(lo<=hi){
            int mid1 = lo + (hi-lo)/2;
            int mid2 = (n1+n2+1)/2 - mid1;

            int l1 = mid1-1>=0?nums1[mid1-1]:Integer.MIN_VALUE;
            int l2 = mid2-1>=0?nums2[mid2-1]:Integer.MIN_VALUE;

            int r1 = mid1<n1?nums1[mid1]:Integer.MAX_VALUE;
            int r2 = mid2<n2?nums2[mid2]:Integer.MAX_VALUE;
            
            if(r1>=l2 && r2>=l1){
                if((n1+n2)%2==0){
                    return (double)(Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }else{
                    
                    return (double)(Math.max(l1,l2));
                }
                
            }
            else if(l1 > r2){
                hi = mid1-1;
            }
            else{
                lo = mid1+1;
            }
        }
        return 0;
    }
}
