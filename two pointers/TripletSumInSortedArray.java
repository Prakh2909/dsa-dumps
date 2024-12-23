public class TripletSumInSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,5,10,15,18};
        System.out.println(isTriplet(arr, 35));
    }

    public static boolean isTriplet(int[] arr, int sum){
        int n = arr.length - 1;
        for (int i = 0; i < arr.length-2; i++) {
            if(PairSum.pairSumUtil(arr, sum-arr[i], i+1, n)){
                return true;
            }
        }
        return false;
    }
}
