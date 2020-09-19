package monthly_challange;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber sol = new SingleNumber();
    }

    public int singleNumber(int[] nums) {

        Set<Integer> numsSet = new HashSet<Integer>();

        for (int i : nums) {
            if (numsSet.contains(i)) {
                numsSet.remove(i);
            } else {
                numsSet.add(i);
            }
        }
        return numsSet.iterator().next();
    }

}
