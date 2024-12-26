public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("ABBA"));
    }

    public static boolean checkPalindrome(String str){
        int i=0;
        int n = str.length();
        while(i<n/2){
            if(str.charAt(i)!=str.charAt(n-i-1)){
                return false;
            }
            i++;
        }
        return true;
    }
}
