//Collections sort works on only classes implenting List interface.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicSortingUsingCollections {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();

        l1.add(2);
        l1.add(1);
        l1.add(0);
        l1.add(4);
        l1.add(9);
        Collections.sort(l1);
        System.out.println(l1);
        Collections.sort(l1,Collections.reverseOrder());
        System.out.println(l1);
        Collections.sort(l1,(Integer a, Integer b)-> a-b);
        System.out.println(l1);
    }
}
