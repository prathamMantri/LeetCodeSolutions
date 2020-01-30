package leetCode.easy;

class Solution27 {

    public static void main(String[] args) {
        Solution27 sol = new Solution27();
        int[] arr = {3, 3, 2, 2};

        sol.removeElement(arr, 3);

    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i : nums) {
            if (i != val) {
                nums[index++] = i;
            }
        }
        return index;
    }

}
