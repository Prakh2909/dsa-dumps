public class RecursionSum {
    public static void main(String[] args) {
        System.out.println(getSum(10));
    }

    static int getSum(int n){
        if(n==0){
            return 0;
        }
        return n + getSum(n-1);
    }
}
