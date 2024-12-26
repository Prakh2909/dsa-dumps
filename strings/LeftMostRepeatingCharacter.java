public class LeftMostRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abccbd"; // answer will be b. left most repeating character
        System.out.println(findLeftMost(str));
    }

    public static int findLeftMost(String str){
        int n = str.length();
        int res=-1;
        boolean[] visited = new boolean[26];
        for (int i = n-1; i >=0; i--) {
            if(visited[str.charAt(i)-'a']){
                res = i;
            }else{
                visited[str.charAt(i)-'a'] = true;
            }
        }

        return res;
    }
}
