package companies.interview_questions_amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1_Amazon {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(2);
        list2.add(5);
        list2.add(1);
        list2.add(6);


        Task1_Amazon task = new Task1_Amazon();
        System.out.println(task.splitArray(list2));
        System.out.println(task.splitArray(list));


    }

    public List<Integer> splitArray(List<Integer> nums) {

        if (nums == null || nums.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();

        Collections.sort(nums, Collections.reverseOrder());

        int n = nums.size();
        int setA = 0;

        for (int i = 0; i < n; i++) {

            int j = i + 1;

            int setB = 0, value = nums.get(i);

            setA = setA + value;


            while (j < n) {
                setB = setB + nums.get(j++);
            }
            ans.add(value);
            if (setA >= setB)
                break;

        }
        Collections.sort(ans);

        return ans;
    }

}
