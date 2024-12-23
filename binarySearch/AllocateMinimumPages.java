// We are provided with an array that represents the number of pages in each book, as well as the number of students available. Each student is required to read the books in a contiguous manner. Our objective is to determine the maximum number of pages that a single student needs to read in order to minimize the allocation. Array is not sorted.

// {10,20,30,40} for k=2 OP=> 60(10,20,30)(40)
// we need to allocate books to each students but to make sure that the allocated book to each student is minimum in a contigous manner, and provide the maximum of pages allocated to student as answer from that partition.

// LC 410. Split Array Largest Sum -> in this problem we are returning minimum

public class AllocateMinimumPages {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        System.out.println(getMaxBooks(arr,2));
    }    

    public static int getMaxBooks(int[] arr, int k){
        int sum = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum+= arr[i];
            max = Math.max(max,arr[i]);
        }

        //FFFTTT firstT
        int lo = max;
        int hi = sum;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(isPossible(arr, mid, k)){
                hi = mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;

    }

    public static boolean isPossible(int[] arr, int mid, int k){
        int sum=0;
        int count=1;
        for (int i = 0; i < arr.length; i++) {
            if(sum+arr[i]>mid){
                sum=arr[i];
                count++;
            }else{
                sum+=arr[i];
            }
        }
        return count<=k;
    }
}
