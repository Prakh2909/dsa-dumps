// tc: n
// sc: n/2 => n

public class CheckPalindrome {

    public static void main(String[] args) {
        System.out.println(checkPalindrome("abccba"));
    }

    public static boolean checkPalindrome(String str){
        return helper(str, 0, str.length()-1);
    }

    public static boolean helper(String str, int i, int j){
        if(i>=j){
            return true;
        }

        if(str.charAt(i) != str.charAt(j)){
            return false;
        }
        return helper(str, i+1, j-1);

    }

}

