public class TowerOfHanoi {
    public static void main(String[] args) {
        helper(3, 'A', 'B', 'C');
    }

    public static void helper(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("Move 1 form " + A + " to " + C);
            return;
        }
        helper(n - 1, A, C, B);
        System.out.println("Move " + n + " from " + A + " to " + C);
        helper(n - 1, B, A, C);
    }
}
