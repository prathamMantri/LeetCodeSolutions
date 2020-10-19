package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Solution315 {
    public List<Integer> countSmaller(int[] nums) {

        int len = nums.length;

        //Create an arrayof the object which will store array value and its position.

        Item[] items = new Item[len];

        for (int i = 0; i < len; i++) {
            items[i] = new Item(i, nums[i]);
        }

        int[] count = new int[len];

        // Now we will sort the object array using merge sort, while doing so, we are also updating the count array with number of positions an element with index i has moved to right of the i. That way we can keep the track of rightCount and update it in count array.

        mergeSort(items, 0, len - 1, count);

        List<Integer> res = new ArrayList<>();
        //Once we have count array updated with all elements, just add it in the result.
        for (int cnt : count) {
            res.add(cnt);
        }
        return res;
    }

    private void mergeSort(Item[] items, int lo, int hi, int[] count) {
        // base case
        if (lo >= hi)
            return;
        // get the mid
        int mid = lo + (hi - lo) / 2;
        // first half for mergeSort
        mergeSort(items, lo, mid, count);
        // second half for the mergeSort
        mergeSort(items, mid + 1, hi, count);

        // merging both half to have sorted array.

        merge(items, lo, mid, mid + 1, hi, count);

    }

    private void merge(Item[] items, int lo, int loEnd, int hi, int hiEnd, int[] count) {

        // get the length of whole array, which is ogoing to be formed after the merger
        int m = hiEnd - lo + 1;
        // create another array, which will be sorted once the merger is done.
        Item[] sorted = new Item[m];

        // index will be used to push element on sorted array, which will be starting from 0;
        int index = 0;

        // these are just pointers to traverse from start to end on both half (which is going to be merged), hence both are starting from
        // lo and hi, as its starting point.
        int loPtr = lo, hiPtr = hi;

        // a counter to keep track of the element, if its shifted right,
        // it means, those many number of small elements were to the right of the current element.
        int rightCounter = 0;


        //Real algorithm starts from here.


        // if BOTH BOTH BOTH pointers have not crossed end yet


        while (loPtr <= loEnd && hiPtr <= hiEnd) {

            // if second half's value is less than first half's value
            // then we will increase the rightCounter by one, why? because, it means, it has to be shifted to left side of that element.
            // example [3, 5, 6, 7] [2, 4, 8, 9] here 2 has to be shifted left of 3, hence [2, 3], meaning at 3's position, there was one element towards right, so we will increase the 3's position(not third position) in count array which is 0 by 1. so count[0] = count[0] + 1, which we have done in else part when all the shifting is done.

            // example [3, 5, 6, 7] [0, 1, 2, 9] here 0 is shifted to left of 3 and the 1 is shifted to left of 3 and the 2 is shifted to left of 3.
            // so we will increase the rightCounter by 3 and finally, when we will have no elements in array to be shifted to left,
            // we will come to else part and will just updated the count array at 3's position to whatever value in array + 3(rightCount value.).

            if (items[hiPtr].value < items[loPtr].value) {
                rightCounter++;
                sorted[index++] = items[hiPtr++];
            } else {
                count[items[loPtr].index] = count[items[loPtr].index] + rightCounter;
                sorted[index++] = items[loPtr++];
            }
        }

        // If hiPtr has reached end, it means, all the values are in first half which are already sorted. So just keep updating count array
        // by adding the values in the count  with rightCounter.

        while (loPtr <= loEnd) {
            count[items[loPtr].index] = count[items[loPtr].index] + rightCounter;
            sorted[index++] = items[loPtr++];
        }

        // If loPtr has reached end, it means, all the higher values are on rightSide, so, just keep updating the sorted Array

        while (hiPtr <= hiEnd) {
            sorted[index++] = items[hiPtr++];
        }

        //At the end just copy the items array in sorted array.

        System.arraycopy(sorted, 0, items, lo, m);
    }

    //Create am object which will store the index and value. We will use it in our calculations.
    class Item {
        int index;
        int value;

        public Item(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
