// "AB" -> "","A","B","AB"
// finding subsequences for a string of n length there going to be 2^n subsequences

import java.util.ArrayList;

public class GenerateSubset {

    public static void main(String[] args) {
        // try be generaing the subset of string "A"
        ArrayList<String> subsets = new ArrayList<>();
        getSubsets("AB", "", 0, subsets);
        System.out.println(subsets.toString());
    }

    public static void getSubsets(String str, String curr, int i, ArrayList<String> subsets) {
        if (i == str.length()) {
            subsets.add(curr);
            return;
        }

        getSubsets(str, curr, i + 1, subsets);
        getSubsets(str, curr + str.charAt(i), i + 1, subsets);
    }
}
