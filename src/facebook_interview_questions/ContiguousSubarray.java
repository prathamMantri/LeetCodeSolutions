package facebook_interview_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ContiguousSubarray {
    public static void main(String[] args) {

        ContiguousSubarray contiguousSubarray = new ContiguousSubarray();
        int[] arr = {3, 4, 1, 6, 2};
        System.out.println(Arrays.toString(contiguousSubarray.countSubarrays(arr)));
        int[] arr2 = {2, 4, 7, 1, 5, 3};
        System.out.println(Arrays.toString(contiguousSubarray.countSubarrays(arr2)));


    }

    int[] countSubarrays(int[] arr) {
        // Write your code here

        Stack<Integer> arrNums = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[arr.length];
        int count = 0;

        arrNums.push(arr[0]);
        map.put(arr[0], 0);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arrNums.peek()) {
                while (!arrNums.isEmpty() && arrNums.peek() < arr[i]) {
                    int pop = arrNums.pop();
                    map.put(pop, map.get(pop) + 1);
                    count = count + map.get(pop);
                }
                if (!arrNums.isEmpty()) {
                    for (Integer arrNum : arrNums) {
                        int next = arrNum;
                        map.put(next, map.get(next) + 1);
                    }
                }
                arrNums.push(arr[i]);
                map.put(arr[i], count);
            } else {

                map.put(arrNums.peek(), map.get(arrNums.peek()) + 1);
                arrNums.push(arr[i]);
                map.put(arr[i], 0);
            }
            count = 0;
        }

        for (int i = 0; i < arr.length; i++) {


            res[i] = map.get(arr[i]) + (arrNums.peek() == arr[i] ? 1 : 0);

        }

        return res;

    }


}
