public class CheckSubsequence {
    public static void main(String[] args) {
        System.out.println(checkSubsequence("Hello", "oll"));
    }

    public static boolean checkSubsequence(String str, String subStr){
        int i=0;
        int j=0;
        while(i<str.length() && j<subStr.length()){
            if(str.charAt(i) == subStr.charAt(j)){
                j++;
            }
            i++;
        }
        System.out.println(i);
        System.out.println(j);
        
        if(j==subStr.length()){
            return true;
        }
        return false;
    }
}
