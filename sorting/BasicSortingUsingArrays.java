import java.util.Arrays;

public class BasicSortingUsingArrays {
    public static void main(String[] args) {
        Integer[] arr = {8,3,56,2,1,7,2};

        Arrays.sort(arr,(Integer a,Integer b)-> a-b); // using functional interface here
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }
}
