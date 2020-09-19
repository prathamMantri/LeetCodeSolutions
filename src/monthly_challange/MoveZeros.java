package monthly_challange;

public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros sol = new MoveZeros();
        int[] nums = {0};
        sol.moveZeroes(nums);
        for (int i : nums)
            System.out.print(i + ", ");
    }

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0, count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }
        while (i < (nums.length - count) && j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        i = nums.length - 1;
        while (count != 0) {
            nums[i] = 0;
            count--;
            i--;
        }
    }

}
