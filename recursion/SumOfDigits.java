// tc: n
// sc: d better to use iterative solution coz this is taking more space compared to iterative one.

public class SumOfDigits {
    public static void main(String[] args) {
        // 253
        System.out.println(getSumOfDigits(0));
    }


    public static int getSumOfDigits(int digit){
        if(digit<=0){
            return 0;
        }

        return (digit%10) + getSumOfDigits(digit/10);
    }
}
