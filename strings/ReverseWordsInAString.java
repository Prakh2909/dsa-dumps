public class ReverseWordsInAString {
    public static void main(String[] args) {
        String str = "Hello How Are You";
        // str = reverseString(str,0,4);
        System.out.println(reverseWordsInAString(str));
    }

    public static String reverseWordsInAString(String str){
        int n = str.length();
        int startIndex=0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)==' '){
                str = reverseString(str,startIndex,i-1);
                startIndex=i+1;
            }
        }
        str = reverseString(str, startIndex, n-1);
        str = reverseString(str, 0, n-1);
        return str;
    }

    public static String reverseString(String str, int lo,int hi){
        int n = hi-lo+1;
        char[] arr = str.toCharArray();
        while(lo<hi){
            char temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
        return new String(arr);
    }
}
