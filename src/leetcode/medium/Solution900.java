package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution900 {
    public static class RLEIterator {
        int[] A;
        int index = 0; // index, which will keep track of number of elements

        public RLEIterator(int[] A) {
            this.A = A;
        }

        public int next(int n) {
            while (index < A.length && A[index] == 0) { // if at all, we find number of elements as 0, just increase the index by 2
                index = index + 2;
            }
            if (index > A.length - 2) { // if index goes beyond the length of Array's last but one element, just keep on returning -1
                return -1;
            }
            if (n <= A[index]) { // if number of occurrences are less than or equal to the iterator called value, just return next A[index + 1] element, and also update the A[index] value, by negating the n
                // so for example 8 is present 3 times, and iterator call was 2 (n=2), it means, return 8 and now only 1 time 8 remains.
                A[index] = A[index] - n; // if
                return A[index + 1];
            } else { // else called value is greater than number of times element is present

                while (index < A.length && n > A[index]) { // loop until either index goes beyond the A.length or n becomes less than A[index] (no of tiems value value)
                    n = n - A[index]; // update n by exhausting the times value at particular index.
                    A[index] = 0; // set the A[index] times value to 0, as the n value was greater
                    index = index + 2; // also go to next A[index] "times" value
                }
                // once we are out of from loop, two cases possible, we still have our index alive , in that case return A[index+1] else, index must have gone beyond A.length, in that case return -1.
                if (index < A.length) {
                    A[index] = A[index] - n; // update the A[index] "times" value .
                    return A[index + 1];
                }
                return -1;
            }
        }
    }

    public static class RLEIteratorTLE {

        List<Integer> decoded;
        int pointer = -1;

        public RLEIteratorTLE(int[] A) {
            int length = 0;
            for (int i = 0; i < A.length; i += 2) {
                length = length + A[i];
            }
            decoded = new ArrayList<>();
            int i = 0, j = 1, d = 0;
            while (j < A.length) {
                for (int k = 0; k < A[i]; k++) {
                    decoded.add(d++, A[j]);
                }
                i = i + 2;
                j = j + 2;
            }
        }

        public int next(int n) {
            for (int i = 0; i < n; i++) {
                pointer++;
            }
            if (pointer < decoded.size()) {
                return decoded.get(pointer);
            }
            return -1;
        }
    }
}
