package monthlyChallange;

import java.util.ArrayList;
import java.util.List;

public class CountingElements {
    public static void main(String[] args) {
        CountingElements sol = new CountingElements();
        int[] nums = {1, 3, 2, 3, 5, 0};
        System.out.println(sol.countElements(nums));
    }

    public int countElements(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        int count = 0;

        for (int i : arr) {
            arrList.add(i);
        }

        for (int i : arr) {
            if (arrList.contains(i + 1))
                count++;
        }
        return count;
    }
}
