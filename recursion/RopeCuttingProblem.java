// tc: 3^n by assuming a b and c as 1 then we will need to run the same thing 3 times for the value of n.

public class RopeCuttingProblem {
    public static void main(String[] args) {
        System.out.println(getNumberOfCuts(23, 11, 9, 12, 0));
        System.out.println(getNumberOfCuts(5, 2, 4, 2, 0));
    }

    public static int getNumberOfCuts(int length, int a, int b, int c, int cuts) {
        if (length == 0) {
            return cuts;
        }
        if (length < 0) {
            return -1;
        }

        return Math.max(getNumberOfCuts(length - a, a, b, c, cuts + 1),
                (Math.max(getNumberOfCuts(length - b, a, b, c, cuts + 1),
                        getNumberOfCuts(length - c, a, b, c, cuts + 1))));
    }
}
