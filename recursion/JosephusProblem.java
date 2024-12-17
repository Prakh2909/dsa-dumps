// n people are standing in a circle and once we start killing every kth person in that circle starting from 0 th person. Out the one that remains alive.
// using recursion we solve for n-1, k. With every kill we can assume we are starting fresh from the next number its just that values are shifted by k.
// for example: in a circle of 5 people and k=3,
// 0th person kills 2nd person and the gun will be handed to 3rd peron, so this 3rd person will act as a 0th person for n=4, k=3
// we can then derice the formula  (josephus(n-1, k)+k)%n; for n 
// space = n tc = n

public class JosephusProblem {
    public static void main(String ...args){
        System.out.println(josephus(5,3)); // answer is based on zero index.
    }

    public static int josephus(int n, int k){
        if(n==1){
            return 0;
        }

        return (josephus(n-1, k)+k)%n;
    }
}