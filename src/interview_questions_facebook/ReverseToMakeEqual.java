package interview_questions_facebook;

import java.util.HashMap;
import java.util.Map;

public class ReverseToMakeEqual {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3};
        int[] b = {1, 3, 3, 2};

        ReverseToMakeEqual rv = new ReverseToMakeEqual();
        System.out.println(rv.areTheyEqual(a, b));

    }

    /**
     * Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
     * Signature
     * bool areTheyEqual(int[] arr_a, int[] arr_b)
     * Input
     * All integers in array are in the range [0, 1,000,000,000].
     * Output
     * Return true if B can be made equal to A, return false otherwise.
     * Example
     * A = [1, 2, 3, 4]
     * B = [1, 4, 3, 2]
     * output = true
     * After reversing the subarray of B from indices 1 to 3, array B will equal array A.
     */

    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here


        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array_a.length; i++) {
            map.put(array_a[i], map.getOrDefault(array_a[i], 1) + 1);
        }

        for (int i = 0; i < array_b.length; i++) {
            if (!map.containsKey(array_b[i])) {
                return false;
            }
            if (map.get(array_b[i]) > 1) {
                map.put(array_b[i], map.get(array_b[i]) - 1);
            } else {
                map.remove(array_b[i]);
            }
        }

        return map.isEmpty();


    }


}
