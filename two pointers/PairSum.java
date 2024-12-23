// In this particular problem, we are provided with a sorted array of integers. Our objective is to determine whether there exists a pair of integers in the array that adds up to a given target value.

public class PairSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(findSum(arr, 19));
    }
    
    public static boolean findSum(int[] arr, int target){
        int lo = 0;
        int hi = arr.length -1;

        while(lo<hi){
            int sum = arr[lo]+arr[hi];
            if(sum==target){
                return true;
            }
            if(sum>target){
                hi--;
            }else{
                lo++;
            }
        }
        return false;
    }

    public static boolean pairSumUtil(int[] arr, int targetSum, int i, int j){
        while(i<j){
            int sum = arr[i]+ arr[j];
            if(sum==targetSum){
                return true;
            }

            if(sum>targetSum){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
