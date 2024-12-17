// find the subet whose sum is equal to given value.
// tc: 2^n
public class SubsetSumProblem {
    public static void main(String... a) {
        int[] arr = {10,20,15,5};
        System.out.println(getTargetSubsetSum(arr, arr.length,25));
    }

    public static int getTargetSubsetSum(int[] arr, int n, int sum) {
        if(n==0){
            return sum==0?1:0;
        }

        return getTargetSubsetSum(arr, n-1, sum) + getTargetSubsetSum(arr, n-1, sum-arr[n-1]);
    }
}
