package interview_questions_microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PilesManagement {


    public static void main(String[] args) {
        PilesManagement piles = new PilesManagement();
        int[] nums = {4, 5, 5, 4, 2};

        System.out.println(piles.removePiles(nums));
    }

    /***
     *
     * https://leetcode.com/discuss/interview-question/364618/
     *
     * @param nums
     * @return
     */

    public int removePiles(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            list.add(nums[i]);
        }
        Collections.sort(list);
        int count = 0;


        return sum - list.get(list.size() - 1);
    }
}
