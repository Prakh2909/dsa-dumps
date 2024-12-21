public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(101));
    }

    public static int findSquareRoot(int num){
        int lo=0;
        int hi=num;
        // TTTTFFFF find last T
        while(lo<hi){
            int mid = lo + (hi-lo+1)/2;
            if(mid*mid<=num){
                lo=mid;
            }else{
                hi = mid-1;
            }
        }
        return lo;
    }
}
