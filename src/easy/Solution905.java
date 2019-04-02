package easy;

public class Solution905 {
    /*

    Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000




     */

    public int[] sortArrayByParity(int[] A) {
        int oddCount = 0, evenCount = 0;
        int n = 0;
        int[] B = new int[A.length];
        while (n < A.length) {
            if (A[n] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            n++;
        }
        n=0;
        while (n < A.length) {
            if (A[n] % 2 == 0) {
                B[--evenCount] = A[n];
            } else {
                B[A.length-oddCount] = A[n];
                oddCount--;
            }
            n++;
        }
        return B;
    }


    public static void main(String[] args) {
        Solution905 sol = new Solution905();
        int[] arr = {4,3,2,1};
        System.out.println(sol.sortArrayByParity(arr));
    }

}
