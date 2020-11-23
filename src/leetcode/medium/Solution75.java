package leetcode.medium;

public class Solution75 {
    public static void main(String[] args) {
        Solution75 sol = new Solution75();
        System.out.println(sol.solution("SMS"));
    }

    private String solution(String T) {

        int S = 0, M = 0, L = 0;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == 'S') {
                S++;
            } else if (T.charAt(i) == 'M') {
                M++;
            } else {
                L++;
            }
        }
        while (S > 0) {
            res.append('S');
            S--;
        }
        while (M > 0) {
            res.append('M');
            M--;
        }
        while (L > 0) {
            res.append('L');
            L--;
        }
        return res.toString();
    }

    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return;

        int left = 0;
        int right = len - 1;
        int current = 0;
        while (current <= right) {
            if (nums[current] == 0)
                swap(nums, left++, current++);
            else if (nums[current] == 1)
                current++;
            else
                swap(nums, right--, current);
        }
    }

    private void swap(int[] nums, int x, int y) {

        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;

    }


}

