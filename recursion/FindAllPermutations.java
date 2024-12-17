// find all permutations of ABC => ABC,ACB,BAC,BCA,CAB,CBA
// approach: keep one index fix and swap each index with it to recursively

public class FindAllPermutations {
    public static void main(String[] args) {
        permute("ABC", 0);
    }

    public static void permute(String str, int i) {
        if (i == str.length() - 1) {
            System.out.print(str + " ");
        }

        for (int j = i; j < str.length(); j++) {
            str = swap(str,i,j);
            permute(str,i+1);
            str = swap(str,i,j);
        }
    }

    public static String swap(String str, int a, int b) {
        char[] charArr = str.toCharArray();
        char temp = charArr[a];
        charArr[a] = charArr[b];
        charArr[b] = temp;
        return String.valueOf(charArr);
    }
}
